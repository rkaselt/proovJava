package com.example.proovjava.controller;

import com.example.proovjava.entity.Car;
import com.example.proovjava.entity.User;
import com.example.proovjava.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getUsers(@RequestParam(required = false) String find,
                               @RequestParam(required = false) String sort) {
        return userService.searchUsers(find, sort);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{id}/cars")
    public List<Car> getUserCars(@PathVariable Long id) {
        return userService.getUserById(id).getCars();
    }
}
