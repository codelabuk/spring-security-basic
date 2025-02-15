package com.labuk.spring_boot_security_basic.repository;

import com.labuk.spring_boot_security_basic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
