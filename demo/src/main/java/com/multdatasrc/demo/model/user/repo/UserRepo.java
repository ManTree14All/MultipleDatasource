package com.multdatasrc.demo.model.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multdatasrc.demo.model.user.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
