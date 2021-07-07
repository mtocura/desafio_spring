package br.com.bootcamp.desafio_spring.service;

import br.com.bootcamp.desafio_spring.dto.SellerPostsDTO;
import br.com.bootcamp.desafio_spring.dto.UserDefaultDTO;
import br.com.bootcamp.desafio_spring.dto.UserFollowingListDTO;
import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.entity.UserFollow;
import br.com.bootcamp.desafio_spring.exception.DatabaseException;
import br.com.bootcamp.desafio_spring.exception.UserNotExistException;
import br.com.bootcamp.desafio_spring.form.UserForm;
import br.com.bootcamp.desafio_spring.handler.UserHandler;
import br.com.bootcamp.desafio_spring.repository.UserFollowRepository;
import br.com.bootcamp.desafio_spring.repository.UserRepository;
import br.com.bootcamp.desafio_spring.utils.sorters.SortByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

            List<UserFollow> followedSellersRelationship = userFollowRepository.getByUserId(userId);

            List<User> followedSellers = new ArrayList<>();

            for (UserFollow userFollow : followedSellersRelationship) {
                User seller = userRepository.getById(userFollow.getID());

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
}
