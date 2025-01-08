package com.agiles.flatelse.config.excel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class ExcelUser {

    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @NotEmpty
    private String password;

    // Default constructor
    public ExcelUser() {
    }

    // Parameterized constructor
    public ExcelUser(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

