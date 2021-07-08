package br.com.bootcamp.desafio_spring.service;

import br.com.bootcamp.desafio_spring.dto.SellerFollowersCountDTO;
import br.com.bootcamp.desafio_spring.dto.SellerPromoPostsCountDTO;
import br.com.bootcamp.desafio_spring.entity.Post;
import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.entity.UserFollow;
import br.com.bootcamp.desafio_spring.exception.DatabaseException;
import br.com.bootcamp.desafio_spring.exception.UserIsNotSellerException;
import br.com.bootcamp.desafio_spring.exception.UserNotExistException;
import br.com.bootcamp.desafio_spring.repository.UserFollowRepository;
import br.com.bootcamp.desafio_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

    public SellerFollowersCountDTO sellerFollowersCount(int userId) {
        try {
            User seller = this.userRepository.getById(userId);
            if (seller == null) {
                throw new UserNotExistException("Usuário " + userId + " não encontrado");
            }

            if (!seller.getIsSeller()) {
                throw new UserIsNotSellerException("Usuário " + seller.getId() + " não é um vendedor e não pode ter seguidores");
            }

            List<UserFollow> sellerFollowers = this.userFollowRepository.getSellerFollowers(seller.getId());
            return new SellerFollowersCountDTO(seller.getId(), seller.getName(), sellerFollowers.size());
        } catch (IOException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public SellerPromoPostsCountDTO sellerPromoPostsCount(int userId) {
        try {
            User seller = userRepository.getById(userId);

            if(seller == null) {
                throw new UserNotExistException("Usuário " + userId + " não encontrado");
            }

            if(!seller.getIsSeller()) {
                throw new UserIsNotSellerException("Usuário " + seller.getId() + " não é um vendedor");
            }

            Predicate<Post> isPromoAndNotExpired = post -> post.getHasPromo() && post.getExpireAt().after(new Date());

            // somente os posts que são promocionais e que não estão expirados
            List<Post> promoPosts = seller.getPosts().stream().filter(isPromoAndNotExpired).collect(Collectors.toList());

            return new SellerPromoPostsCountDTO(seller.getId(), seller.getName(), promoPosts.size());
        } catch(IOException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
