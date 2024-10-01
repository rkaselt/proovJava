package com.example.proovjava.controller;

import com.example.proovjava.entity.Car;
import com.example.proovjava.entity.User;
import com.example.proovjava.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(required = false) String find,
                                              @RequestParam(required = false) String sort) {
        return ResponseEntity.ok(userService.searchUsers(find, sort));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/{id}/cars")
    public ResponseEntity<List<Car>> getUserCars(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id).getCars());
    }
}
