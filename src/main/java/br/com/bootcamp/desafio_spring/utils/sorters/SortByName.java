package br.com.bootcamp.desafio_spring.utils.sorters;

import br.com.bootcamp.desafio_spring.entity.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByName {
    public static void sortByNameASC(List<User> users) {
        Collections.sort(users, Comparator.comparing(User::getName));
    }

    public static void sortByNameDESC(List<User> users) {
        Collections.sort(users, Comparator.comparing(User::getName).reversed());
    }
}
