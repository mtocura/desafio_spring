package br.com.bootcamp.desafio_spring.utils.comparators;

import br.com.bootcamp.desafio_spring.entity.User;

import java.util.Comparator;

public class SortByNameDESC implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user2.getName().compareToIgnoreCase(user1.getName());
    }
}
