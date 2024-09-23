package com.matheusandrade.springboot_mongodb_project.config;

import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.matheusandrade.springboot_mongodb_project.domain.Post;
import com.matheusandrade.springboot_mongodb_project.domain.User;
import com.matheusandrade.springboot_mongodb_project.repository.PostRepository;
import com.matheusandrade.springboot_mongodb_project.repository.UserRepository;

import java.text.SimpleDateFormat;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired 
    private UserRepository userReposiroty;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userReposiroty.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Aragorn, Strider", "strider@gmail.com");
        User u2 = new User(null, "Gandalf, The Withe", "alex@gmail.com");
        User u3 = new User(null, "Legolas", "legolas@gmail.com");
        User u4 = new User(null, "Gimli", "gimli@gmail.com");

        Post post1 = new Post(null, sdf.parse("09/03/2024"), "Look to my coming", "Look to my coming at first light on the fifth day. At dawn, look to the East.", u2);
        Post post2 = new Post(null, sdf.parse("09/03/2024"), "These are no soldiers", "Look at them. They're frightened. I can see it in their eyes.", u3);

        userReposiroty.saveAll(Arrays.asList(u1, u2, u3, u4));
        postRepository.saveAll(Arrays.asList(post1, post2));

    }

}
