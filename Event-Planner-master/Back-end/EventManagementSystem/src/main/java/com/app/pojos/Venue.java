package com.app.pojos;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "venue_details")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venue_id")
    private Integer venueId;

    @Column(name = "v_name", length = 50)
    @NotBlank(message = "Venue name cannot be blank")
    private String venueName;

    @Column(name = "venue_desc", length = 500)
    private String venueDescription;

    @Column(name = "v_capacity")
    @Min(value = 1, message = "Capacity must be at least 1")
    private int venueCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "venue_pkg")
    private VenuePackage venuePackage;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address venueAddress;

    @Column(name = "v_price")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private double venuePricePerDay;

    @ManyToOne
    @JoinColumn(name = "prop_id")
    private User venueProprietor;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "venue_event",
               joinColumns = @JoinColumn(name = "venue_id"),
               inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<Event> events = new ArrayList<>();

    @OneToMany(mappedBy = "mealVenue", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Meal> meals = new ArrayList<>();

    @OneToMany(mappedBy = "decorationVenue", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Decoration> decorations = new ArrayList<>();

    public Venue() {
        // Default constructor
    }

    public Venue(String venueName, String venueDescription, int venueCapacity, VenuePackage venuePackage, double venuePricePerDay) {
        this.venueName = venueName;
        this.venueDescription = venueDescription;
        this.venueCapacity = venueCapacity;
        this.venuePackage = venuePackage;
        this.venuePricePerDay = venuePricePerDay;
    }

    // Getters and setters
    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueDescription() {
        return venueDescription;
    }

    public void setVenueDescription(String venueDescription) {
        this.venueDescription = venueDescription;
    }

    public int getVenueCapacity() {
        return venueCapacity;
    }

    public void setVenueCapacity(int venueCapacity) {
        this.venueCapacity = venueCapacity;
    }

    public VenuePackage getVenuePackage() {
        return venuePackage;
    }

    public void setVenuePackage(VenuePackage venuePackage) {
        this.venuePackage = venuePackage;
    }

    public Address getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(Address venueAddress) {
        this.venueAddress = venueAddress;
    }

    public double getVenuePricePerDay() {
        return venuePricePerDay;
    }

    public void setVenuePricePerDay(double venuePricePerDay) {
        this.venuePricePerDay = venuePricePerDay;
    }

    public User getVenueProprietor() {
        return venueProprietor;
    }

    public void setVenueProprietor(User venueProprietor) {
        this.venueProprietor = venueProprietor;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Decoration> getDecorations() {
        return decorations;
    }

    public void setDecorations(List<Decoration> decorations) {
        this.decorations = decorations;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((venueId == null) ? 0 : venueId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Venue other = (Venue) obj;
        if (venueId == null) {
            if (other.venueId != null)
                return false;
        } else if (!venueId.equals(other.venueId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Venue [venueId=" + venueId + ", venueName=" + venueName + ", venueDescription=" + venueDescription
                + ", venueCapacity=" + venueCapacity + ", venuePackage=" + venuePackage + ", venuePricePerDay="
                + venuePricePerDay + "]";
    }
}
