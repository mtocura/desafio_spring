package br.com.bootcamp.desafio_spring.controller;

import br.com.bootcamp.desafio_spring.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {

    private SellerService sellerService;

    public SellerController() {
    }

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<?> getFollowedList(@PathVariable int userId) {
        return ResponseEntity.ok(sellerService.followerList(userId));
    }

}
