package br.com.bootcamp.desafio_spring.service;

import br.com.bootcamp.desafio_spring.dto.UserFollowingListDTO;
import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.exception.DatabaseException;
import br.com.bootcamp.desafio_spring.exception.UserNotExistException;
import br.com.bootcamp.desafio_spring.repository.UserFollowRepository;
import br.com.bootcamp.desafio_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

    /*
    Método que retorna uma lista de vendedores que um determinado usuário, seja ele vendedor ou não, segue.
     */
    public List<UserFollowingListDTO> followingList(int userId) {
        try {
            User user = userRepository.getById(userId);

            if(user == null) {
                throw new UserNotExistException("Usuário " + userId + " não encontrado");
            }

            return userFollowRepository.getByUserId(userId);
        } catch (IOException e) {
            throw new DatabaseException("Falha ao tentar acessar o banco de dados.");
            return null;
        }
    }
}
