package com.blog.tutorial.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.tutorial.springboot.exception.ResourceNotFoundException;
import com.blog.tutorial.springboot.model.User;
import com.blog.tutorial.springboot.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

	/*
	 * Get all users
	 */
    @GetMapping
    public List <User> getAll() {
        return this.userRepository.findAll();
    }

	/*
	 * get user by id
	 */
    @GetMapping("/{id}")
    public User getById(@PathVariable(value = "id") long userId) {
        return this.userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
    }

	/*
	 * create user
	 */
    @PostMapping("/add")
    public User add(@RequestBody User user) {
        return this.userRepository.save(user);
    }

	/*
	 * update user
	 */
    @PutMapping("/update/{id}")
    public User update(@RequestBody User user, @PathVariable("id") long userId) {
        User existingUser = this.userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
        existingUser.setName(user.getName());
        existingUser.setCity(user.getCity());
        existingUser.setEmail(user.getEmail());
        return this.userRepository.save(existingUser);
    }

	/*
	 * delete user by id
	 */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity < User > delete(@PathVariable("id") long userId) {
        User existingUser = this.userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
        this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build();
    }
}