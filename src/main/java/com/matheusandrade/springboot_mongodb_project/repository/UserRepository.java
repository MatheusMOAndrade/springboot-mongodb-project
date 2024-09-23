package com.matheusandrade.springboot_mongodb_project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.matheusandrade.springboot_mongodb_project.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
