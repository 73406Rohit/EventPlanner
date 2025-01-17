package com.app.pojos;

import java.time.LocalDate;
//import java.util.*;
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "user_details")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "fname", length = 15)
    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @Column(name = "lname", length = 15)
    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Column(name = "user_email", length = 30, unique = true, nullable = false)
    @NotBlank(message = "Email is mandatory")
    private String userEmail;

    @Column(name = "user_password")
    @NotBlank(message = "Password is mandatory")
    private String password;

    @Transient
    private String confirmPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender")
    private Gender userGender;

    @Column(name = "user_dob")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate userDOB;

    @Column(name = "contact_no", length = 10)
    @Pattern(regexp = "\\d{10}", message = "Contact number should be 10 digits")
    private String contactNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "sec_que")
    private SecurityQuestion securityQuestion;

    @Column(name = "sec_ans", length = 15)
    private String securityAnswer;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private Role userRole;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address userAddress;

    // Constructor
    public User() {
        System.out.println("In User default constructor");
    }

    // Parameterized Constructor
    public User(String firstName, String lastName, String userEmail, String password, String confirmPassword,
                Gender userGender, LocalDate userDOB, String contactNo, SecurityQuestion securityQuestion,
                String securityAnswer, Role userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.userGender = userGender;
        this.userDOB = userDOB;
        this.contactNo = contactNo;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.userRole = userRole;
    }

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Gender getUserGender() {
        return userGender;
    }

    public void setUserGender(Gender userGender) {
        this.userGender = userGender;
    }

    public LocalDate getUserDOB() {
        return userDOB;
    }

    public void setUserDOB(LocalDate userDOB) {
        this.userDOB = userDOB;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public SecurityQuestion getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(SecurityQuestion securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

    // Uncomment and use if necessary
    /* 
    @OneToMany(mappedBy = "venueProprietor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Venue> venues = new ArrayList<>();
    
    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }
    */

    @Override
    public String toString() {
        return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userEmail="
                + userEmail + ", userGender=" + userGender + ", userDOB=" + userDOB + ", contactNo=" + contactNo
                + ", userRole=" + userRole + "]";
    }
}
