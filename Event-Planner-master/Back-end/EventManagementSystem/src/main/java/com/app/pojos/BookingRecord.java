package com.app.pojos;

import java.time.LocalDate;

//import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="booking_record")
public class BookingRecord {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="booking_id")
    private Integer bookingId;

    @Column(name="s_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")  // Corrected date format
    private LocalDate startDate;

    @Column(name="e_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate endDate;

    @OneToOne
    @JoinColumn(name="cust_id")
    private User bookedBy;

    @OneToOne
    @JoinColumn(name="venue_id")
    private Venue bookedVenue;

    @OneToOne
    @JoinColumn(name="meal_id")
    private Meal chosenMeal;  // Corrected "choosen" to "chosen"

    @OneToOne
    @JoinColumn(name="deco_id")
    private Decoration chosenDecoration;  // Corrected "choosen" to "chosen"

    // Default Constructor
    public BookingRecord() {
        System.out.println("In BookingRecord default constructor");
    }

    // Parameterized Constructor
    public BookingRecord(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
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

    public User getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(User bookedBy) {
        this.bookedBy = bookedBy;
    }

    public Venue getBookedVenue() {
        return bookedVenue;
    }

    public void setBookedVenue(Venue bookedVenue) {
        this.bookedVenue = bookedVenue;
    }

    public Meal getChosenMeal() {
        return chosenMeal;
    }

    public void setChosenMeal(Meal chosenMeal) {
        this.chosenMeal = chosenMeal;
    }

    public Decoration getChosenDecoration() {
        return chosenDecoration;
    }

    public void setChosenDecoration(Decoration chosenDecoration) {
        this.chosenDecoration = chosenDecoration;
    }

    @Override
    public String toString() {
        return "BookingRecord [bookingId=" + bookingId + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }
}
