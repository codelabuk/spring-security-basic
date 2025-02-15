package com.labuk.spring_boot_security_basic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Lambok plugin doesn't seems to work
 * TODO  fix it
 */
@Data
@Getter
@Setter
@Entity
@Table(name = "USER_TBL")
public class User {
    @Id
    private Integer id;
    private String userName;
    private String password;
    private String emailId;

    public User(){}

    public User(Integer id, String userName, String password, String emailId) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
