package com.finance_tracker.finance_tracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "savings")

public class Savings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne // Indicates a many-to-one relationship
    @JoinColumn(name = "user_id", nullable = false) // This means that in the database table corresponding to this entity,
    // there will be a column named user_id that will hold the identifier of the User instance associated with this entity.
    private User user;
    @Column(nullable = false)// This column can not be null
    private String goalName;
    @Column(nullable = false)// This column can not be null
    private double targetAmount;

    private double currentAmount;
    @Column(nullable = false)// This column can not be null
    private LocalDate dueDate;

    // Constructors


    public Savings() {
    }

    public Savings(long id, User user, String goalName, double targetAmount, double currentAmount, LocalDate dueDate) {
        this.id = id;
        this.user = user;
        this.goalName = goalName;
        this.targetAmount = targetAmount;
        this.currentAmount = 0;
        this.dueDate = dueDate;
    }
}
