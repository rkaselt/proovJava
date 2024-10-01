package com.example.proovjava.service;

import com.example.proovjava.entity.Car;
import com.example.proovjava.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> searchCars(String find, String sort) {
        if (find == null || find.isEmpty()) {
            if (sort != null && !sort.isEmpty()) {
                String[] sortParams = sort.split(":");
                String field = sortParams[0];
                Sort.Direction direction = Sort.Direction.fromString(sortParams[1]);

                return carRepository.findAll(Sort.by(direction, field));
            } else {
                return carRepository.findAll();
            }
        }

        if (sort != null && !sort.isEmpty()) {
            String[] sortParams = sort.split(":");
            String field = sortParams[0];
            Sort.Direction direction = Sort.Direction.fromString(sortParams[1]);

            return carRepository.findByMakeContainingIgnoreCaseOrModelContainingIgnoreCase(find, find, Sort.by(direction, field));
        } else {
            return carRepository.findByMakeContainingIgnoreCaseOrModelContainingIgnoreCase(find, find);
        }
    }
}
