package br.com.bootcamp.desafio_spring.utils.sorters;

import br.com.bootcamp.desafio_spring.entity.Post;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByPostDate {

    public static void sortByDate(List<Post> posts, String order) {
        if (FieldSortOrder.isDateDesc(order)) {
            Collections.sort(posts, Comparator.comparing(Post::getCreatedAt).reversed());
        }
        if (FieldSortOrder.isDateAsc(order)) {
            Collections.sort(posts, Comparator.comparing(Post::getCreatedAt));
        }
    }
}
