package com.matheusandrade.springboot_mongodb_project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.matheusandrade.springboot_mongodb_project.domain.User;
import com.matheusandrade.springboot_mongodb_project.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired 
    private UserRepository userReposiroty;

    @Override
    public void run(String... args) throws Exception {

        userReposiroty.deleteAll();

        User u1 = new User(null, "Aragorn, Strider", "strider@gmail.com");
        User u2 = new User(null, "Gandalf, The Withe", "alex@gmail.com");
        User u3 = new User(null, "Legolas", "legolas@gmail.com");

        userReposiroty.saveAll(Arrays.asList(u1, u2, u3));

    }

}
