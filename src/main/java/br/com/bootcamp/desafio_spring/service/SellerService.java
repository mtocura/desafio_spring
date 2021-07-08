package br.com.bootcamp.desafio_spring.service;

import br.com.bootcamp.desafio_spring.dto.SellerFollowersCountDTO;
import br.com.bootcamp.desafio_spring.entity.Post;
import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.entity.UserFollow;
import br.com.bootcamp.desafio_spring.exception.*;
import br.com.bootcamp.desafio_spring.form.PostForm;
import br.com.bootcamp.desafio_spring.form.PostPromoForm;
import br.com.bootcamp.desafio_spring.handler.PostHandler;
import br.com.bootcamp.desafio_spring.handler.PostPromoHandler;
import br.com.bootcamp.desafio_spring.repository.UserFollowRepository;
import br.com.bootcamp.desafio_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

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


    public void createPost(PostForm postForm) {
        try {
            User seller = this.userRepository.getById(postForm.getUserId());
            if (seller == null) {
                throw new UserNotExistException("Usuário " + postForm.getUserId() + " não encontrado.");
            }

            if (!seller.getIsSeller()) {
                throw new UserIsNotSellerException("Usuário " + seller.getId() + " não é um vendedor e não pode criar uma postagem.");
            }

            Post newPost = PostHandler.create(postForm);
            seller.getPosts().add(newPost);
            int userId = userRepository.update(seller);
        } catch (IOException e) {
            throw new DatabaseException("Falha ao tentar acessar o banco de dados.");
        }
    }

    public void createPromoPost(PostPromoForm postPromoForm) {
        try {
            User seller = this.userRepository.getById(postPromoForm.getUserId());
            if (seller == null) {
                throw new UserNotExistException("Usuário " + postPromoForm.getUserId() + " não encontrado.");
            }

            if (!seller.getIsSeller()) {
                throw new UserIsNotSellerException("Usuário " + seller.getId() + " não é um vendedor e não pode criar uma postagem.");
            }

            Post newPromoPost = PostPromoHandler.create(postPromoForm);

            seller.getPosts().add(newPromoPost);
            int userId = userRepository.update(seller);
        } catch (IOException e) {
            throw new DatabaseException("Falha ao tentar acessar o banco de dados.");
        }
    }


}
