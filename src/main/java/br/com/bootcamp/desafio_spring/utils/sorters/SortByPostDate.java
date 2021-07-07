package br.com.bootcamp.desafio_spring.utils.sorters;

import br.com.bootcamp.desafio_spring.entity.Post;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByPostDate {

    public static void sortByDatePostASC(List<Post> posts) {
        Collections.sort(posts, Comparator.comparing(Post::getCreatedAt));
    }

    public static void sortByDatePostDESC(List<Post> posts) {
        Collections.sort(posts, Comparator.comparing(Post::getCreatedAt).reversed());
    }
}
