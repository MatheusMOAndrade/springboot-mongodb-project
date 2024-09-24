package com.matheusandrade.springboot_mongodb_project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusandrade.springboot_mongodb_project.domain.Post;
import com.matheusandrade.springboot_mongodb_project.repository.PostRepository;
import com.matheusandrade.springboot_mongodb_project.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired // automatically instantiate
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
