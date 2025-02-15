package com.labuk.spring_boot_security_basic;

import com.labuk.spring_boot_security_basic.entity.User;
import com.labuk.spring_boot_security_basic.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableWebSecurity
public class SpringBootSecurityBasicApplication {

    @Autowired
    UserRepository userRespository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initUser() {
        List<User> users = Stream.of(
                new User(1, "labukAdmin", passwordEncoder.encode("admin1"), "labuk.admin@labuk.com"),
                new User(2, "userLabuk1", passwordEncoder.encode("user1"), "user.labuk1@labuk.com")
        ).collect(Collectors.toList());
        userRespository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityBasicApplication.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
