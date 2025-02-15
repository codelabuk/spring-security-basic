package com.labuk.spring_boot_security_basic.config;

import com.labuk.spring_boot_security_basic.service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
        httpSecurity.authorizeRequests().requestMatchers("/api/v0/labuk/authenticate").permitAll()
                .anyRequest().authenticated();
//        httpSecurity.authorizeRequests().requestMatchers("/api/v0/labuk/**")
//                .fullyAuthenticated().and().httpBasic();
        return httpSecurity.build();
    }

    @Bean
    AuthenticationManager getAuthentionManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(customUserDetailService);
        daoAuthenticationProvider.setPasswordEncoder(bcryptPasswordEncoder());
        return daoAuthenticationProvider;
    }

}
