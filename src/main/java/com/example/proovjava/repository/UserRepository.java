package com.example.proovjava.repository;

import com.example.proovjava.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameContainingIgnoreCase(String find, Sort by);
    List<User> findByNameContainingIgnoreCase(String find);
}

