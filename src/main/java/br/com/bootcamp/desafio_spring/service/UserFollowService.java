package br.com.bootcamp.desafio_spring.service;

import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.entity.UserFollow;
import br.com.bootcamp.desafio_spring.exception.SellerIsNotFollowedException;
import br.com.bootcamp.desafio_spring.exception.UserIsNotSellerException;
import br.com.bootcamp.desafio_spring.exception.UserNotExistException;
import br.com.bootcamp.desafio_spring.repository.UserFollowRepository;
import br.com.bootcamp.desafio_spring.repository.UserRepository;
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

    public void follow(int userID, int sellerID) throws IOException {
        User user = this.userRepository.getById(userID);
        if (user == null) {
            throw new UserNotExistException("Usuário " + userID + " não encontrado");
        }

        User seller = this.userRepository.getById(sellerID);
        if (seller == null) {
            throw new UserNotExistException("Vendedor " + userID + " não encontrado");
        }
        if (!seller.isSeller()) {
            throw new UserIsNotSellerException("Usuario " + sellerID + " não é um vendedor e não pode ser seguido");
        }

        UserFollow uf = this.userFollowRepository.get(userID, sellerID);
        if (uf == null) {
            this.userFollowRepository.save(new UserFollow(userID, sellerID));
        }
    }



    public void unfollow(int userID, int sellerID) {
        try {
            User user = this.userRepository.getById(userID);
            if (user == null) {
                throw new UserNotExistException("Usuário " + userID + " não encontrado");
            }

            User seller = this.userRepository.getById(sellerID);
            if (seller == null) {
                throw new UserNotExistException("Vendedor " + userID + " não encontrado");
            }

            if (!seller.isSeller()) {
                throw new UserIsNotSellerException("Usuário " + sellerID + " não é um vendedor e não pode deixar de ser seguido");
            }

            UserFollow uf = this.userFollowRepository.get(userID, sellerID);
            if (uf != null) {
                this.userFollowRepository.remove(uf);
            } else {
                throw new SellerIsNotFollowedException("Usuário" + userID + " não segue vendedor " + sellerID);
            }
        } catch (IOException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
