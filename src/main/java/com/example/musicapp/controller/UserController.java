package com.example.musicapp.controller;

import com.example.musicapp.entity.User;
import com.example.musicapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(userService.getUser(id));

    }

    @PostMapping("/register")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/register").toUriString());
        return ResponseEntity.created(uri).body(userService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editUser(@RequestBody User user, @PathVariable(name = "id") Integer id) {
        userService.updateUser(user, id);
        return ResponseEntity.noContent().build();
    }
}
