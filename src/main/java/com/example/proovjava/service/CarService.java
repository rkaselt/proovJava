package com.example.proovjava.service;

import com.example.proovjava.entity.Car;
import com.example.proovjava.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> searchCars(String find, String sort) {
        List<Car> cars = carRepository.findAll();

        List<Car> filteredCars = cars.stream()
                .filter(car -> car.getMake().toLowerCase().contains(find.toLowerCase()) ||
                        car.getModel().toLowerCase().contains(find.toLowerCase()))
                .collect(Collectors.toList());

        String[] sortParams = sort.split(":");
        String sortField = sortParams[0];
        boolean ascending = "asc".equalsIgnoreCase(sortParams[1]);

        filteredCars.sort((car1, car2) -> {
            int comparison;
            if ("make".equals(sortField)) {
                comparison = car1.getMake().compareTo(car2.getMake());
            } else if ("model".equals(sortField)) {
                comparison = car1.getModel().compareTo(car2.getModel());
            } else {
                return 0;
            }
            return ascending ? comparison : -comparison;
        });

        return filteredCars;
    }
}
