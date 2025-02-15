package com.labuk.spring_boot_security_basic.config;

import com.labuk.spring_boot_security_basic.service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class LabukSecurityConfiguration {

    private final CustomUserDetailService customUserDetailService;

    public LabukSecurityConfiguration(CustomUserDetailService customUserDetailService) {
        this.customUserDetailService = customUserDetailService;
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
        httpSecurity.authorizeRequests().requestMatchers("/api/v0/labuk/**")
                .fullyAuthenticated().and().httpBasic();
        return httpSecurity.build();
    }

//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity.csrf().disable().userDetailsService(customUserDetailService)
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/login", "/css/**", "/js/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .build();
//    }

}
