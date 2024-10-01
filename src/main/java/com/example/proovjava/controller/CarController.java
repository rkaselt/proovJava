package com.example.proovjava.controller;

import com.example.proovjava.entity.Car;
import com.example.proovjava.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/{id}")
    public Car getUserById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @GetMapping
    public List<Car> searchCars(
            @RequestParam(value = "find", required = false, defaultValue = "") String find,
            @RequestParam(value = "sort", required = false, defaultValue = "make:asc") String sort) {

        return carService.searchCars(find, sort);
    }
}
