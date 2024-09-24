package com.matheusandrade.springboot_mongodb_project.config;

import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.matheusandrade.springboot_mongodb_project.domain.Post;
import com.matheusandrade.springboot_mongodb_project.domain.User;
import com.matheusandrade.springboot_mongodb_project.dto.AuthorDTO;
import com.matheusandrade.springboot_mongodb_project.dto.CommentDTO;
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

        userReposiroty.saveAll(Arrays.asList(u1, u2, u3, u4));

        Post post1 = new Post(null, sdf.parse("22/09/2024"), "Look to my coming", "Look to my coming at first light on the fifth day. At dawn, look to the East.", new AuthorDTO(u2));
        Post post2 = new Post(null, sdf.parse("23/09/2024"), "These are no soldiers", "Most have seen too many winters!",  new AuthorDTO(u4));
        Post post3 = new Post(null, sdf.parse("05/10/2024"), "Dwarves and elves", "Never thought I’d die fighting side by side with an elf.",  new AuthorDTO(u4));

        CommentDTO c1 = new CommentDTO("Aragorn nods", sdf.parse("22/09/2024"), new AuthorDTO(u1));
        CommentDTO c2 = new CommentDTO("Boe a hyn neled herain... dan caer menig!", sdf.parse("23/09/2024"), new AuthorDTO(u3));
        CommentDTO c3 = new CommentDTO("Si beriathar hyn ammaeg na ned Edoras.", sdf.parse("23/09/2024"), new AuthorDTO(u1));
        CommentDTO c4 = new CommentDTO("What about side by side with a friend?", sdf.parse("05/10/2024"), new AuthorDTO(u3));
        CommentDTO c5 = new CommentDTO("Aye, I could do that.", sdf.parse("05/10/2024"), new AuthorDTO(u4));

        post1.getComments().addAll(Arrays.asList(c1));
        post2.getComments().addAll(Arrays.asList(c2, c3));
        post3.getComments().addAll(Arrays.asList(c4, c5));

        postRepository.saveAll(Arrays.asList(post1, post2, post3));

        u2.getPosts().addAll(Arrays.asList(post1));
        u4.getPosts().addAll(Arrays.asList(post2, post3));

        userReposiroty.save(u2);
        userReposiroty.save(u4);

    }

}
