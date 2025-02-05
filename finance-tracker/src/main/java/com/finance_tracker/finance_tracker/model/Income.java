package com.finance_tracker.finance_tracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "income")

public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne // Indicates a many-to-one relationship
    @JoinColumn(name = "user_id", nullable = false) // This means that in the database table corresponding to this entity,
    // there will be a column named user_id that will hold the identifier of the User instance associated with this entity.
    private User user;
    @Column(nullable = false)// This column can not be null
    private double amount;
    @Column(nullable = false)// This column can not be null
    private String source;
    @Column(nullable = false)// This column can not be null
    private LocalDate date;

    // Constructors

    public Income() {
    }

    public Income(long id, User user, double amount, String source, LocalDate date) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.source = source;
        this.date = date;
    }
    // Getters ans Setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
