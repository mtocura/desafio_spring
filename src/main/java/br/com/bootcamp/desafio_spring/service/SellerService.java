package br.com.bootcamp.desafio_spring.service;

import br.com.bootcamp.desafio_spring.dto.SellerFollowersCountDTO;
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

    public SellerFollowersCountDTO sellerFollowersCount(int userID) {
        try {
            User seller = this.userRepository.getById(userID);
            if (seller == null) {
                throw new UserNotExistException("Usuário " + userID + " não encontrado");
            }

            if (!seller.getIsSeller()) {
                throw new UserIsNotSellerException("Usuário " + seller.getID() + " não é um vendedor e não pode ter seguidores");
            }

            List<UserFollow> sellerFollowers = this.userFollowRepository.getBySellerId(seller.getID());
            return new SellerFollowersCountDTO(seller.getID(), seller.getName(), sellerFollowers.size());
        } catch (IOException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
