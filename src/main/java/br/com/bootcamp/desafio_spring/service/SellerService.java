package br.com.bootcamp.desafio_spring.service;

import br.com.bootcamp.desafio_spring.dto.SellerFollowersListDTO;
import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.entity.UserFollow;
import br.com.bootcamp.desafio_spring.exception.DatabaseException;
import br.com.bootcamp.desafio_spring.exception.UserNotExistException;
import br.com.bootcamp.desafio_spring.handler.UserHandler;
import br.com.bootcamp.desafio_spring.dto.SellerFollowersCountDTO;
import br.com.bootcamp.desafio_spring.exception.UserIsNotSellerException;
import br.com.bootcamp.desafio_spring.repository.UserFollowRepository;
import br.com.bootcamp.desafio_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
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

    public SellerFollowersListDTO followerList (int userId) {
        try {
            User user = userRepository.getById(userId);

            if (user == null) {
                throw new UserNotExistException("Vendedor " + userId + " não encontrado.");
            }
            if (user.getIsSeller()) {
                List<UserFollow> followerUserRelationship = userFollowRepository.getSellerFollowers(userId);
                List<User> followerUsers = new ArrayList<>();

                for (UserFollow userFollow : followerUserRelationship) {
                    User userFollower = userRepository.getById(userFollow.getUser());
                    followerUsers.add(userFollower);
                }
                return UserHandler.convertSellerFollowers(userId, user.getName(), followerUsers);
            } else {
                throw new UserNotExistException("Usuário " + userId + " não é vendedor.");
            }
        } catch (IOException e) {
            throw new DatabaseException(e.getMessage());
        }
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
}
