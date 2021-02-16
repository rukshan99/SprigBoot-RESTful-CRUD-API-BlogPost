package com.blog.tutorial.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.tutorial.springboot.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
