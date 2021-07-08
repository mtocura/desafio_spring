package br.com.bootcamp.desafio_spring.service;

import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.entity.UserFollow;
import br.com.bootcamp.desafio_spring.exception.SellerIsNotFollowedException;
import br.com.bootcamp.desafio_spring.exception.DatabaseException;
import br.com.bootcamp.desafio_spring.exception.InvalidFollowException;
import br.com.bootcamp.desafio_spring.exception.UserIsNotSellerException;
import br.com.bootcamp.desafio_spring.exception.UserNotExistException;
import br.com.bootcamp.desafio_spring.repository.UserFollowRepository;
import br.com.bootcamp.desafio_spring.repository.UserRepository;
import br.com.bootcamp.desafio_spring.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserFollowService {
    private UserRepository userRepository;
    private UserFollowRepository userFollowRepository;

    @Autowired
    public UserFollowService(UserRepository userRepository, UserFollowRepository userFollowRepository) {
        this.userRepository = userRepository;
        this.userFollowRepository = userFollowRepository;
    }

    public void follow(int userId, int sellerId)  {
        try {
            if (userId == sellerId) {
                throw new InvalidFollowException("Um usuário não seguir-se");
            }

            User user = this.userRepository.getById(userId);

            UserUtil.userExists(user, userId);

            User seller = this.userRepository.getById(sellerId);

            UserUtil.userIsSeller(seller, sellerId);

            UserFollow uf = this.userFollowRepository.get(userId, sellerId);
            if (uf == null) {
                this.userFollowRepository.save(new UserFollow(userId, sellerId));
            }
        } catch (IOException e) {
            throw new DatabaseException(e.getMessage());
        }
    }



    public void unfollow(int userId, int sellerId) {
        try {
            User user = this.userRepository.getById(userId);

            UserUtil.userExists(user, userId);

            User seller = this.userRepository.getById(sellerId);

            UserUtil.userIsSeller(seller, sellerId);

            UserFollow uf = this.userFollowRepository.get(userId, sellerId);
            if (uf != null) {
                this.userFollowRepository.remove(uf.getId());
            } else {
                throw new SellerIsNotFollowedException("Usuário" + userId + " não segue vendedor " + sellerId);
            }
        } catch (IOException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
