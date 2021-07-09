package br.com.bootcamp.desafio_spring.utils;

import br.com.bootcamp.desafio_spring.entity.Post;
import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.exception.PostIdAlreadyExistsException;

public class PostUtil {

    public static void idAlreadyExists(User seller, Post newPost) {
        for (Post post : seller.getPosts()) {
            if (newPost.getId().equals(post.getId())) {
                throw new PostIdAlreadyExistsException("O vendedor já possui um post com este ID.");
            }
        }
    }
}
