package br.com.bootcamp.desafio_spring.controller;

import br.com.bootcamp.desafio_spring.dto.SellerFollowersCountDTO;
import br.com.bootcamp.desafio_spring.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SellerController {

    private SellerService sellerService;

    public SellerController() {
    }

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/users/{userId}/followers/count")
    public SellerFollowersCountDTO followersCountDTO(@PathVariable int userId) {
        return this.sellerService.sellerFollowersCount(userId);
    }

    @GetMapping("/products/{userId}/countPromo/")
    public ResponseEntity<?> promoPostsCount(@PathVariable int userId) {
        return ResponseEntity.ok(sellerService.sellerPromoPostsCount(userId));
    }
}
