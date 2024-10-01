package com.example.proovjava.service;

import com.example.proovjava.entity.User;
import com.example.proovjava.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> searchUsers(String find, String sort) {
        if (find == null || find.isEmpty()) {
            if (sort != null && !sort.isEmpty()) {
                String[] sortParams = sort.split(":");
                String field = sortParams[0];
                Sort.Direction direction = Sort.Direction.fromString(sortParams[1]);

                return userRepository.findAll(Sort.by(direction, field));
            } else {
                return userRepository.findAll();
            }
        }

        if (sort != null && !sort.isEmpty()) {
            String[] sortParams = sort.split(":");
            String field = sortParams[0];
            Sort.Direction direction = Sort.Direction.fromString(sortParams[1]);

            return userRepository.findByNameContainingIgnoreCase(find, Sort.by(direction, field));
        } else {
            return userRepository.findByNameContainingIgnoreCase(find);
        }
    }
}
