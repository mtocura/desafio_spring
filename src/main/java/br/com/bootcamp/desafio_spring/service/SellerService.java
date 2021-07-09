package br.com.bootcamp.desafio_spring.service;

import br.com.bootcamp.desafio_spring.dto.*;
import br.com.bootcamp.desafio_spring.entity.Post;
import br.com.bootcamp.desafio_spring.dto.SellerFollowersCountDTO;
import br.com.bootcamp.desafio_spring.form.PostForm;
import br.com.bootcamp.desafio_spring.form.PostPromoForm;
import br.com.bootcamp.desafio_spring.handler.PostHandler;
import br.com.bootcamp.desafio_spring.handler.PostPromoHandler;
import br.com.bootcamp.desafio_spring.dto.SellerPromoPostsCountDTO;
import br.com.bootcamp.desafio_spring.dto.SellerFollowersListDTO;
import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.entity.UserFollow;
import br.com.bootcamp.desafio_spring.exception.DatabaseException;
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
import java.time.ZonedDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class SellerService {

    private UserRepository userRepository;
    private UserFollowRepository userFollowRepository;

    @Autowired
    public SellerService(UserRepository userRepository, UserFollowRepository userFollowRepository) {
        this.userRepository = userRepository;
        this.userFollowRepository = userFollowRepository;
    }

    public SellerFollowersListDTO followerList (int userId, String order) {
        try {
            User user = userRepository.getById(userId);

            UserUtil.userIsSeller(user, userId);

            List<User> followerUsers = RepositoryUtil.getSellerFollowers(userId, userRepository, userFollowRepository);

            SortByName.sortByName(followerUsers, order);

            return UserHandler.convertSellerFollowers(userId, user.getName(), followerUsers);
        } catch (IOException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public SellerFollowersCountDTO sellerFollowersCount(int userId) {
        try {
            User seller = this.userRepository.getById(userId);

            UserUtil.userIsSeller(seller, userId);

            List<UserFollow> sellerFollowers = this.userFollowRepository.getSellerFollowers(seller.getId());
            return new SellerFollowersCountDTO(seller.getId(), seller.getName(), sellerFollowers.size());
        } catch (IOException e) {
            throw new DatabaseException(e.getMessage());

        }
    }

    public SellerPromoPostsDTO productList (int userId, String order) {
        try {
            User user = userRepository.getById(userId);

            UserUtil.userIsSeller(user, userId);

            ZonedDateTime now = ZonedDateTime.now();

            Predicate<Post> isPromoAndNotExpired = post -> post.getHasPromo() && post.getExpireAt().toInstant().isAfter(now.toInstant());

            List<Post> postsPromoUser = user.getPosts().stream().filter(isPromoAndNotExpired).collect(Collectors.toList());

            SortByName.sortByProductName(postsPromoUser, order);
            SortByPostDate.sortByDate(postsPromoUser, order);

            return PostPromoHandler.convertSellerPromoPostsDTO(userId, user.getName(), postsPromoUser);

        } catch (IOException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public SellerPromoPostsCountDTO sellerPromoPostsCount(int userId) {
        try {
            User seller = userRepository.getById(userId);

            UserUtil.userIsSeller(seller, userId);

            ZonedDateTime now = ZonedDateTime.now();

            Predicate<Post> isPromoAndNotExpired = post -> post.getHasPromo() && post.getExpireAt().toInstant().isAfter(now.toInstant());

            // somente os posts que são promocionais e que não estão expirados
            List<Post> promoPosts = seller.getPosts().stream().filter(isPromoAndNotExpired).collect(Collectors.toList());

            return new SellerPromoPostsCountDTO(seller.getId(), seller.getName(), promoPosts.size());
        } catch(IOException e) {
            throw new DatabaseException(e.getMessage());
        }
    }


    public void createPost(PostForm postForm) {
        try {
            User seller = this.userRepository.getById(postForm.getUserId());

            UserUtil.userIsSeller(seller, postForm.getUserId());

            Post newPost = PostHandler.create(postForm);
            seller.getPosts().add(newPost);
            userRepository.update(seller);
        } catch (IOException e) {
            throw new DatabaseException("Falha ao tentar acessar o banco de dados.");
        }
    }

    public void createPromoPost(PostPromoForm postPromoForm) {
        try {
            User seller = this.userRepository.getById(postPromoForm.getUserId());

            UserUtil.userIsSeller(seller, postPromoForm.getUserId());

            Post newPromoPost = PostPromoHandler.create(postPromoForm);

            seller.getPosts().add(newPromoPost);
            userRepository.update(seller);
        } catch (IOException e) {
            throw new DatabaseException("Falha ao tentar acessar o banco de dados.");
        }
    }

}
