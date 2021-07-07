package br.com.bootcamp.desafio_spring.controller;

import br.com.bootcamp.desafio_spring.service.UserUnfollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

public class UserUnfollowController {

    private UserUnfollowService userUnfollowService;

    public void UserUnfollowController() {
    }

    @Autowired
    public UserUnfollowController(UserUnfollowService userUnfollowService) {
        this.userUnfollowService = userUnfollowService;
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public void unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws IOException {
        this.userUnfollowService.unfollow(userId, userIdToUnfollow);
    }
}
