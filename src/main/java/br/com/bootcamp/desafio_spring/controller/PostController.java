package br.com.bootcamp.desafio_spring.controller;

import br.com.bootcamp.desafio_spring.form.PostForm;
import br.com.bootcamp.desafio_spring.form.PostPromoForm;
import br.com.bootcamp.desafio_spring.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping()
public class PostController {

    private SellerService sellerService;

    public PostController() {
    }

    @Autowired
    public PostController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("/products/newpost")
    public ResponseEntity<?> createPost(@RequestBody @Valid PostForm postForm) {
        sellerService.createPost(postForm);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/products/newpromopost")
    public ResponseEntity<?> createPromoPost(@RequestBody @Valid PostPromoForm postPromoForm) {
        sellerService.createPromoPost(postPromoForm);
        return ResponseEntity.ok().build();
    }
}
