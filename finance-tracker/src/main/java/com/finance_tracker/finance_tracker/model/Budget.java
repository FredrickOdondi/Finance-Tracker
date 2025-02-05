package com.finance_tracker.finance_tracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "budget")

public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne // Indicates a many-to-one relationship
    @JoinColumn(name = "user_id", nullable = false) // This means that in the database table corresponding to this entity,
    // there will be a column named user_id that will hold the identifier of the User instance associated with this entity.
    private User user;
    @Column(nullable = false)// This column can not be null
    private String category;
    @Column(nullable = false)// This column can not be null
    private double limit;
    @Column(nullable = false)// This column can not be null
    private LocalDate startDate;
    @Column(nullable = false)// This column can not be null
    private LocalDate endDate;

    // Constructors


    public Budget() {
    }

    public Budget(long id, User user, String category, double limit, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.limit = limit;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
