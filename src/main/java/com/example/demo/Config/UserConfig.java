package com.example.demo.Config;

import java.util.List;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UserConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            User mark = new User(
                "mgati",
                "gatimark123@gmail.com",
                "kekw",
                "0745067229"
            );
            //userRepository.saveAll(List.of(mark));
        };
    }
}
