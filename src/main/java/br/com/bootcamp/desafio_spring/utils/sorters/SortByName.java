package br.com.bootcamp.desafio_spring.utils.sorters;

import br.com.bootcamp.desafio_spring.entity.Post;
import br.com.bootcamp.desafio_spring.entity.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByName {

    public static void sortByName(List<User> users, String order) {
        if (FieldSortOrder.isNameDesc(order)) {
            Collections.sort(users, Comparator.comparing(User::getName).reversed());
        }
        if (FieldSortOrder.isNameAsc(order)) {
            Collections.sort(users, Comparator.comparing(User::getName));
        }
    }

    public static void sortByProductName(List<Post> postsPromo, String order) {
        if (FieldSortOrder.isNameDesc(order)) {
            postsPromo.sort((p1, p2) -> -p1.getProduct().getName().compareToIgnoreCase(p2.getProduct().getName()));
        }
        if (FieldSortOrder.isNameAsc(order)) {
            postsPromo.sort((p1, p2) -> p1.getProduct().getName().compareToIgnoreCase(p2.getProduct().getName()));
        }
    }
}
