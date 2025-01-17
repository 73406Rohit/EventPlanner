package com.app.pojos;

//import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "meal_details")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private Integer mealId;

    @Column(name = "meal_name", length = 30)
    private String mealName;

    @Column(name = "meal_desc", length = 500)
    private String mealDescription;

    @Column(name = "meal_price")
    private double mealPricePerPerson;

    @ManyToOne
    @JoinColumn(name = "v_id")
    @JsonBackReference
    private Venue mealVenue;  // Reference to Venue, corrected for bidirectional relationship

    // Default constructor
    public Meal() {
        System.out.println("In Meal default constructor");
    }

    // Parameterized constructor
    public Meal(String mealName, String mealDescription, double mealPricePerPerson) {
        this.mealName = mealName;
        this.mealDescription = mealDescription;
        this.mealPricePerPerson = mealPricePerPerson;
    }

    // Getters and Setters
    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealDescription() {
        return mealDescription;
    }

    public void setMealDescription(String mealDescription) {
        this.mealDescription = mealDescription;
    }

    public double getMealPricePerPerson() {
        return mealPricePerPerson;
    }

    public void setMealPricePerPerson(double mealPricePerPerson) {
        this.mealPricePerPerson = mealPricePerPerson;
    }

    public Venue getMealVenue() {
        return mealVenue;
    }

    public void setMealVenue(Venue mealVenue) {
        this.mealVenue = mealVenue;
    }

    // toString method
    @Override
    public String toString() {
        return "Meal [mealId=" + mealId + ", mealName=" + mealName + ", mealDescription=" + mealDescription
                + ", mealPricePerPerson=" + mealPricePerPerson + "]";
    }
}
