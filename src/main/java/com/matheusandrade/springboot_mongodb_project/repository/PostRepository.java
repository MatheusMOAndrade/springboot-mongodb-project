package com.matheusandrade.springboot_mongodb_project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.matheusandrade.springboot_mongodb_project.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
