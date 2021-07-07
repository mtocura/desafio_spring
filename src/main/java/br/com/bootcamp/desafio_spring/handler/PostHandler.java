package br.com.bootcamp.desafio_spring.handler;

import br.com.bootcamp.desafio_spring.entity.Post;
import br.com.bootcamp.desafio_spring.form.PostForm;

import java.util.Date;
import java.util.Map;

public class PostFormHandler {

    public static Post create(PostForm postForm) {
        return new Post(
                postForm.getPostId(),
                postForm.getPrice(),
                postForm.getCategory(),
                ProductFormHandler.create(postForm.getDetail()),
                postForm.getUserId(),
                false,
                0.0,
                new Date(),
                new Date()
        );
    }
    
    public Map<String, String> validate(PostForm postForm) {
        return null;
    }
}
