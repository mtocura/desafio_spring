package br.com.bootcamp.desafio_spring.handler;

import br.com.bootcamp.desafio_spring.dto.PostPromoDTO;
import br.com.bootcamp.desafio_spring.dto.SellerPromoPostsDTO;
import br.com.bootcamp.desafio_spring.entity.Post;
import br.com.bootcamp.desafio_spring.form.PostPromoForm;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
                postPromoForm.getExpireDate(),
                postPromoForm.getDate()
        );
    }

    public static PostPromoDTO convert(Post post) {
        return new PostPromoDTO(
                post.getId(),
                post.getCreatedAt(),
                ProductHandler.convert(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount()
        );
    }

    public static SellerPromoPostsDTO convertSellerPromoPostsDTO(Integer userID, String userName, List<Post> postList) {
        List<PostPromoDTO> postPromoDTOS = new ArrayList<>();
        for (Post post: postList) {
            postPromoDTOS.add(PostPromoHandler.convert(post));
        }

        return new SellerPromoPostsDTO(userID, userName, postPromoDTOS);
    }
}
