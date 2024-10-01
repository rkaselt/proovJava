package com.example.proovjava;

import com.example.proovjava.entity.Car;
import com.example.proovjava.repository.CarRepository;
import com.example.proovjava.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

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
    void testGetAllCars_HappyFlow() {
        Car car1 = new Car(1L, "Lada", "2101", "123ASD", null);
        Car car2 = new Car(2L, "Kia", "Sorento", "534TTT", null);
        when(carRepository.findAll()).thenReturn(Arrays.asList(car1, car2));

        var cars = carService.searchCars("", "make:asc");

        assertEquals(2, cars.size());
        verify(carRepository, times(1)).findAll();
    }

    @Test
    void testGetCarById_HappyFlow() {
        Car car = new Car(1L, "Lada", "2101", "123ASD", null);
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));

        var result = carService.getCarById(1L);

        assertNotNull(result);
        assertEquals("Lada", result.getMake());
        verify(carRepository, times(1)).findById(1L);
    }

    @Test
    void testGetCarById_NotFound() {
        when(carRepository.findById(1L)).thenReturn(Optional.empty());

        var result = carService.getCarById(1L);

        assertNull(result);
        verify(carRepository, times(1)).findById(1L);
    }
}
