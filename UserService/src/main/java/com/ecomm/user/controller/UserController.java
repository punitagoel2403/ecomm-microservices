package com.ecomm.user.controller;

import com.ecomm.user.model.User;
import com.ecomm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return Optional.ofNullable(userService.getAll())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody User user) {
        userService.create(user);
        return ResponseEntity.ok("Success");
    }

}
