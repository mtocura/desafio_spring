package br.com.bootcamp.desafio_spring.repository;

import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.storage.State;

import java.io.IOException;
import java.util.Map;

@org.springframework.stereotype.Repository
public class UserRepository extends Repository<User>{
    @Override
    protected Map<Integer, User> getState(State s) {
        return s.getUsers();
    }
}
