package br.com.bootcamp.desafio_spring.controller;

import br.com.bootcamp.desafio_spring.service.UserFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

public class UserUnfollowController {

    private UserFollowService userFollowService;

    public void UserFollowController() {
    }

    @Autowired
    public UserUnfollowController(UserFollowService userFollowService) {
        this.userFollowService = userFollowService;
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public void unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws IOException {
        this.userFollowService.unfollow(userId, userIdToUnfollow);
    }
}
