package br.com.bootcamp.desafio_spring.handler;

import br.com.bootcamp.desafio_spring.dto.PostDTO;
import br.com.bootcamp.desafio_spring.entity.Post;
import br.com.bootcamp.desafio_spring.form.PostForm;

import java.util.Date;
import java.util.Map;

public class PostHandler {

    public static Post create(PostForm postForm) {
        double discount = 0.0;
        boolean hasPromo = false;

        return new Post(
                postForm.getPostId(),
                postForm.getPrice(),
                postForm.getCategory(),
                ProductHandler.create(postForm.getDetail()),
                postForm.getUserId(),
                hasPromo,
                discount,
                new Date(),
                new Date()
        );
    }

    public Map<String, String> validate(PostForm postForm) {
        return null;
    }

    public static PostDTO convert(Post post) {
        return new PostDTO(
                post.getID(),
                post.getCreatedAt(),
                ProductHandler.convert(post.getProduct()),
                post.getCategory(),
                post.getPrice()
        );
    }

}
