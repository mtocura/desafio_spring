package br.com.bootcamp.desafio_spring.controller;

import br.com.bootcamp.desafio_spring.service.UserFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserFollowController {

    private UserFollowService userFollowService;

    public UserFollowController() {
    }

    @Autowired
    public UserFollowController(UserFollowService userFollowService) {
        this.userFollowService = userFollowService;
    }
}
