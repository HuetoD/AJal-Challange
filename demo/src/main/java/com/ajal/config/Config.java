package com.ajal.config;

import com.ajal.entity.User;
import com.ajal.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config implements CommandLineRunner {

    private final UserRepository userRepository;

    public Config(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public void run(String... args) throws Exception { resetUsers(); }

    private void resetUsers() {
        User user = new User();
        user.setEmail("user@ajal.com");
        user.setPassword("ajal");
        userRepository.deleteAll();
        userRepository.save(user);
    }


}
