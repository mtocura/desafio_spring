package br.com.bootcamp.desafio_spring.service;

import br.com.bootcamp.desafio_spring.dto.PostDTO;
import br.com.bootcamp.desafio_spring.dto.SellerPostsDTO;
import br.com.bootcamp.desafio_spring.dto.UserDefaultDTO;
import br.com.bootcamp.desafio_spring.dto.UserFollowingListDTO;
import br.com.bootcamp.desafio_spring.entity.Post;
import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.exception.DatabaseException;
import br.com.bootcamp.desafio_spring.form.UserForm;
import br.com.bootcamp.desafio_spring.handler.PostHandler;
import br.com.bootcamp.desafio_spring.handler.UserHandler;
import br.com.bootcamp.desafio_spring.repository.UserFollowRepository;
import br.com.bootcamp.desafio_spring.repository.UserRepository;
import br.com.bootcamp.desafio_spring.utils.RepositoryUtil;
import br.com.bootcamp.desafio_spring.utils.UserUtil;
import br.com.bootcamp.desafio_spring.utils.sorters.SortByName;
import br.com.bootcamp.desafio_spring.utils.sorters.SortByPostDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserFollowRepository userFollowRepository;

    public UserService() {
    }

    @Autowired
    public UserService(UserRepository userRepository, UserFollowRepository userFollowRepository) {
        this.userRepository = userRepository;
        this.userFollowRepository = userFollowRepository;
    }

    public UserDefaultDTO createUser(UserForm userForm) {
        try {
            User user = UserHandler.create(userForm);
            int userId = userRepository.save(user);

            User savedUser = userRepository.getById(userId);

            return UserHandler.convert(savedUser);
        } catch (IOException e) {
            throw new DatabaseException("Falha ao tentar acessar o banco de dados.");
        }
    }

    /*
    Método que retorna uma lista de vendedores que um determinado usuário, seja ele vendedor ou não, segue.
     */
    public UserFollowingListDTO followedList(int userId, String order) {
        try {
            User user = userRepository.getById(userId);

            UserUtil.userExists(user, userId);

            List<User> followedSellers = RepositoryUtil.getFollowedSellers(userId, userRepository, userFollowRepository);

            SortByName.sortByName(followedSellers, order);

            return UserHandler.convertFollowingUsers(userId, user.getName(), followedSellers);
        } catch (IOException e) {
            throw new DatabaseException("Falha ao tentar acessar o banco de dados.");
        }
    }

    public SellerPostsDTO followedPosts(int userId, String order) {
        try {
            User user = this.userRepository.getById(userId);
            UserUtil.userExists(user, userId);

            List<User> sellers = RepositoryUtil.getFollowedSellers(userId, userRepository, userFollowRepository);

            final long DAY_LIMIT = 15;
            List<Post> postsEntities = new ArrayList<>();
            ZonedDateTime now = ZonedDateTime.now();
            ZonedDateTime limit = ZonedDateTime.now().minusDays(DAY_LIMIT);

            for (User seller : sellers) {
                for (Post p : seller.getPosts()) {
                    ZonedDateTime date = p.getCreatedAt().toInstant().atZone(ZoneId.systemDefault());
                    ZonedDateTime expire = p.getExpireAt() != null ? p.getExpireAt().toInstant().atZone(ZoneId.systemDefault()) : null;
                    if (isFollowedPostsValidDate(now, limit, date, expire)) {
                        postsEntities.add(p);
                    }
                }
            }

            postsEntities.sort(null);

            SortByPostDate.sortByDate(postsEntities, order);

            List<PostDTO> posts =
                    postsEntities
                    .stream()
                    .map(PostHandler::convert)
                    .collect(Collectors.toList());
            return new SellerPostsDTO(userId, posts);
        } catch (IOException e) {
            throw new DatabaseException("Falha ao tentar acessar o banco de dados.");
        }
    }

    private boolean isFollowedPostsValidDate(ZonedDateTime now, ZonedDateTime limit, ZonedDateTime date, ZonedDateTime expire) {
        boolean isWithinLimit = limit.isBefore(date);
        if (expire == null) {
            return isWithinLimit;
        }
        return now.isBefore(expire) || now.isEqual(expire);
    }
}
