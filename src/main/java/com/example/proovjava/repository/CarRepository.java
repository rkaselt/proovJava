package com.example.proovjava.repository;

import com.example.proovjava.entity.Car;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByMakeContainingIgnoreCaseOrModelContainingIgnoreCase(String make, String model);

    List<Car> findByMakeContainingIgnoreCaseOrModelContainingIgnoreCase(String make, String model, Sort sort);}
