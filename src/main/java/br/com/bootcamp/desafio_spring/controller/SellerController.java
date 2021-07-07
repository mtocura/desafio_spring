package br.com.bootcamp.desafio_spring.controller;

import br.com.bootcamp.desafio_spring.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SellerController {

    private SellerService sellerService;

    public SellerController() {
    }

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

}
