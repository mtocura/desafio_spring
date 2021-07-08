package br.com.bootcamp.desafio_spring.controller;

import br.com.bootcamp.desafio_spring.dto.SellerPostsDTO;
import br.com.bootcamp.desafio_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {
    private UserService userService;

    @Autowired
    public ProductController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/products/followed/{userId}/list")
    public SellerPostsDTO followedPosts(@PathVariable int userId, @RequestParam(required = false) String order) {
         return this.userService.followedPosts(userId, order == null ? "" : order);
    }
}
