package br.com.bootcamp.desafio_spring.controller;

import br.com.bootcamp.desafio_spring.dto.SellerFollowersCountDTO;
import br.com.bootcamp.desafio_spring.dto.SellerPromoPostsDTO;
import br.com.bootcamp.desafio_spring.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<?> getFollowedList(@PathVariable int userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(sellerService.followerList(userId, order == null ? "" : order));
    }

    @GetMapping("/users/{userId}/followers/count")
    public SellerFollowersCountDTO followersCountDTO(@PathVariable int userId) {
        return this.sellerService.sellerFollowersCount(userId);
    }

    @GetMapping("/products/{userId}/list")
    public ResponseEntity<?> getProductPromoList (@PathVariable int userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(sellerService.productList(userId, order == null ? "" : order));
    }

    @GetMapping("/products/{userId}/countPromo")
    public ResponseEntity<?> promoPostsCount(@PathVariable int userId) {
        return ResponseEntity.ok(sellerService.sellerPromoPostsCount(userId));
    }
}
