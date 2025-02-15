package com.labuk.spring_boot_security_basic.service;

import com.labuk.spring_boot_security_basic.entity.User;
import com.labuk.spring_boot_security_basic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("Inside loadUserByUserName");
        User user = userRespository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        System.out.println("Inside load userName {} " + user);
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(), new ArrayList<>());
    }

}
