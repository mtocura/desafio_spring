package br.com.bootcamp.desafio_spring.controller;

import br.com.bootcamp.desafio_spring.form.UserForm;
import br.com.bootcamp.desafio_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserForm userForm) {
        return ResponseEntity.ok(userService.createUser(userForm));
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<?> getFollowedList(@PathVariable int userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(userService.followedList(userId, order == null ? "" : order));
    }
}
