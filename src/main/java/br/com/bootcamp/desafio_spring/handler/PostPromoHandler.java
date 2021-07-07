package br.com.bootcamp.desafio_spring.handler;

import br.com.bootcamp.desafio_spring.dto.PostPromoDTO;
import br.com.bootcamp.desafio_spring.entity.Post;
import br.com.bootcamp.desafio_spring.form.PostPromoForm;

import java.util.Date;
import java.util.Map;

public class PostPromoHandler {

    public static Post create(PostPromoForm postPromoForm) {
        return new Post(
                postPromoForm.getPostId(),
                postPromoForm.getPrice(),
                postPromoForm.getCategory(),
                ProductHandler.create(postPromoForm.getDetail()),
                postPromoForm.getUserId(),
                postPromoForm.getHasPromo(),
                postPromoForm.getDiscount(),
                new Date(),
                postPromoForm.getDate()
        );
    }

    public Map<String, String> validate(PostPromoForm postPromoForm) {
        return null;
    }

    public static PostPromoDTO convert(Post post) {
        return new PostPromoDTO(
                post.getID(),
                post.getCreatedAt(),
                ProductHandler.convert(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount()
        );
    }
}
