package br.com.bootcamp.desafio_spring.service;

import br.com.bootcamp.desafio_spring.dto.PostDTO;
import br.com.bootcamp.desafio_spring.dto.SellerPostsDTO;
import br.com.bootcamp.desafio_spring.dto.UserDefaultDTO;
import br.com.bootcamp.desafio_spring.dto.UserFollowingListDTO;
import br.com.bootcamp.desafio_spring.entity.Post;
import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.entity.UserFollow;
import br.com.bootcamp.desafio_spring.exception.DatabaseException;
import br.com.bootcamp.desafio_spring.exception.UserNotExistException;
import br.com.bootcamp.desafio_spring.form.UserForm;
import br.com.bootcamp.desafio_spring.handler.PostHandler;
import br.com.bootcamp.desafio_spring.handler.UserHandler;
import br.com.bootcamp.desafio_spring.repository.UserFollowRepository;
import br.com.bootcamp.desafio_spring.repository.UserRepository;
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

            if(user == null) {
                throw new UserNotExistException("Usuário " + userId + " não encontrado");
            }

            List<UserFollow> followedSellersRelationship = userFollowRepository.getUserFollowed(userId);

            List<User> followedSellers = new ArrayList<>();

            for (UserFollow userFollow : followedSellersRelationship) {
                User seller = userRepository.getById(userFollow.getSeller());

                followedSellers.add(seller);
            }

            if(order.equals("name_asc")) {
                SortByName.sortByNameASC(followedSellers);
            }

            if(order.equals("name_desc")) {
                SortByName.sortByNameDESC(followedSellers);
            }

            return UserHandler.convertFollowingUsers(userId, user.getName(), followedSellers);
        } catch (IOException e) {
            throw new DatabaseException("Falha ao tentar acessar o banco de dados.");
        }
    }

    public SellerPostsDTO followedPosts(int userId, String order) {
        try {
            User user = this.userRepository.getById(userId);
            if (user == null) {
                throw new UserNotExistException("Usuário " + userId + " não encontrado");
            }

            List<UserFollow> follows = this.userFollowRepository.getUserFollowed(userId);
            List<User> sellers = new ArrayList<>();
            for (UserFollow f : follows) {
                sellers.add(this.userRepository.getById(f.getSeller()));
            }

            final long DAY_LIMIT = 15;
            List<Post> postsEntities = new ArrayList<>();
            ZonedDateTime now = ZonedDateTime.now();
            ZonedDateTime limit = ZonedDateTime.now().minusDays(DAY_LIMIT);

            for (User seller : sellers) {
                for (Post p : seller.getPosts()) {
                    ZonedDateTime date = p.getCreatedAt().toInstant().atZone(ZoneId.systemDefault());
                    ZonedDateTime expire = p.getExpireAt().toInstant().atZone(ZoneId.systemDefault());
                    if (isFollowedPostsValidDate(now, limit, date, expire)) {
                        postsEntities.add(p);
                    }
                }
            }

            if (order.equals("date_asc")) {
                SortByPostDate.sortByDatePostASC(postsEntities);
            } else if (order.equals("date_desc")) {
                SortByPostDate.sortByDatePostDESC(postsEntities);
            }

            postsEntities.sort(null);

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
