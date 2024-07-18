package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.exceptionhandler.GlobalExceptionHandler;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController extends GlobalExceptionHandler{

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }
    @PostMapping
    public User addUser(@Valid @RequestBody User user) {
        return userService.save(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid  @RequestBody User userDetails) {
        User existingUser = userService.findById(id);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the fields of the existing user with the new values only if they are not null
        if (userDetails.getName() != null) {
            existingUser.setName(userDetails.getName());
        }
        if (userDetails.getAge() != null) {
            existingUser.setAge(userDetails.getAge());
        }
        if (userDetails.getEmail() != null) {
            existingUser.setEmail(userDetails.getEmail());
        }

        // Save the updated user back to the database
        User updatedUser = userService.save(existingUser);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
