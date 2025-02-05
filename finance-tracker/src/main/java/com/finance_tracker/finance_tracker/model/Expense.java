package com.finance_tracker.finance_tracker.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expense")

public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne // Indicates a many-to-one relationship
    @JoinColumn(name = "user_id", nullable = false) // This means that in the database table corresponding to this entity,
    // there will be a column named user_id that will hold the identifier of the User instance associated with this entity.
    private User user;
    @Column(nullable = false)// This column can not be null
    private BigDecimal amount;
    @Column(nullable = false)// This column can not be null
    private BigDecimal foreignAmount;
    @Column(nullable = false)// This column can not be null
    private String category;
    private  String description;
    @Column(nullable = false)// This column can not be null
    private LocalDate date;

    // Constructors

    public Expense(BigDecimal foreignAmount) {
        this.foreignAmount = foreignAmount;
    }

    public Expense(long id, User user, double amount, BigDecimal foreignAmount, String category, String description, LocalDate date) {
        this.id = id;
        this.user = user;
        this.amount = BigDecimal.valueOf(amount);
        this.foreignAmount = foreignAmount;
        this.category = category;
        this.description = description;
        this.date = date;
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

    public BigDecimal getAmount() {
        return amount;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getForeignAmount() {
        return foreignAmount;
    }

    public void setForeignAmount(BigDecimal foreignAmount) {
        this.foreignAmount = foreignAmount;
    }

    public void setAmount(BigDecimal convertedAmount) {
    }
}
