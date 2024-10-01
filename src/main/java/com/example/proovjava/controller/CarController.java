package com.example.proovjava.controller;

import com.example.proovjava.entity.Car;
import com.example.proovjava.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/{id}")
    public ResponseEntity<Car> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @GetMapping
    public ResponseEntity<List<Car>> searchCars(
            @RequestParam(value = "find", required = false, defaultValue = "") String find,
            @RequestParam(value = "sort", required = false, defaultValue = "make:asc") String sort) {

        return ResponseEntity.ok(carService.searchCars(find, sort));
    }
}
