package org.huy.test_maven.controller;

import org.huy.test_maven.entity.User;
import org.huy.test_maven.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getById(@PathVariable Integer userId) {

        User user = this.userRepository.findById(userId).orElse(null);

        user.getProfile();


        System.out.println("End debug");
        return ResponseEntity.ok("ok");
    }
}
