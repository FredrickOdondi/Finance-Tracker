package com.finance_tracker.finance_tracker.model;

import jakarta.persistence.*;

// The User entity will store user details such as username, password, and email.
@Entity
@Table(name = "users")

public class User {
    @Id //Tells spring that this is the Primary Key in this table
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Auto-generates the user id for us
    private long id;
    @Column(nullable = false ,unique = true)// This column can not be null and must be unique
    private String username;
    @Column(nullable = false)// This column can not be null
    private String password;
    @Column(nullable = false, unique = true)// This column can not be null
    private String email;

    // Constructors

    public User() {
    }

    public User(long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = this.username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = this.password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
