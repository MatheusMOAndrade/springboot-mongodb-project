package com.matheusandrade.springboot_mongodb_project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusandrade.springboot_mongodb_project.domain.User;
import com.matheusandrade.springboot_mongodb_project.repository.UserRepository;

@Service
public class UserService {

    @Autowired //automatically instantiate
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
    
}
