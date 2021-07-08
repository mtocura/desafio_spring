package br.com.bootcamp.desafio_spring.controller;

import br.com.bootcamp.desafio_spring.dto.SellerPostsDTO;
import br.com.bootcamp.desafio_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
    private UserService userService;

    @Autowired
    public ProductController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/products/followed/{userId}/list")
    public SellerPostsDTO followedPosts(@PathVariable int userId) {
         return this.userService.followedPosts(userId);
    }
}
