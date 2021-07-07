package br.com.bootcamp.desafio_spring.utils.comparators;

import br.com.bootcamp.desafio_spring.entity.User;

import java.util.Comparator;

public class SortByNameASC implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user1.getName().compareToIgnoreCase(user2.getName());
    }
}
