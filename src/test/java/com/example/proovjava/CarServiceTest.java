package com.example.proovjava;

import com.example.proovjava.entity.Car;
import com.example.proovjava.repository.CarRepository;
import com.example.proovjava.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSearchCars() {
        Car car1 = new Car(1L, "Lada", "2101", "123ASD", null);

        when(carRepository.findByMakeContainingIgnoreCaseOrModelContainingIgnoreCase("Lada", "Lada", Sort.by(Sort.Direction.ASC, "make")))
                .thenReturn(List.of(car1));

        List<Car> result = carService.searchCars("Lada", "make:asc");

        assertEquals(1, result.size());
        assertEquals("Lada", result.get(0).getMake());
        verify(carRepository, times(1))
                .findByMakeContainingIgnoreCaseOrModelContainingIgnoreCase("Lada", "Lada", Sort.by(Sort.Direction.ASC, "make"));
    }

    @Test
    void testSearchCars_NoResults() {
        when(carRepository.findByMakeContainingIgnoreCaseOrModelContainingIgnoreCase("NonExistent", "NonExistent"))
                .thenReturn(List.of());

        List<Car> result = carService.searchCars("NonExistent", "");

        assertEquals(0, result.size());
        verify(carRepository, times(1))
                .findByMakeContainingIgnoreCaseOrModelContainingIgnoreCase("NonExistent", "NonExistent");
    }
}
