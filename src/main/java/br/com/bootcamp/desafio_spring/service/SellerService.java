package br.com.bootcamp.desafio_spring.service;

import br.com.bootcamp.desafio_spring.dto.SellerFollowersListDTO;
import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.entity.UserFollow;
import br.com.bootcamp.desafio_spring.exception.DatabaseException;
import br.com.bootcamp.desafio_spring.exception.UserNotExistException;
import br.com.bootcamp.desafio_spring.handler.UserHandler;
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

    public SellerFollowersListDTO followerList (int userId){
        try{
            User user = userRepository.getById(userId);

            if(user == null){
                throw new UserNotExistException("Vendedor " + userId + " não encontrado.");
            }
            if(user.getIsSeller()){
                List <UserFollow> followerUserRelationship = userFollowRepository.getBySellerId(userId);
                List <User> followerUsers = new ArrayList<>();

                for (UserFollow userFollow : followerUserRelationship){
                    User userFollower = userRepository.getById(userFollow.getUser());
                    followerUsers.add(userFollower);
                }
                return UserHandler.convertSellerFollowers(userId, user.getName(), followerUsers);
            }else{
                throw new UserNotExistException("Usuário " + userId + " não é vendedor.");
            }
        }catch (IOException e){
            throw new DatabaseException("Falha ao tentar acessar o banco de dados.");
        }
    }
}
