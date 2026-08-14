package com.pizza_planet.store_front.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
@MappedSuperclass
public abstract class Account{
    // i as a user have a name email birthday password and address
     @Column(unique = true, nullable = false)
     String username;
     @Column(nullable = false)
     String password;



    LocalDate dob;
    
    Date enrollmentDate;
    @Column(unique = true, nullable = false)
    @Email
    String Email;
    @Column(nullable = false)
    String name;

    public void setDOB(String dob){
       DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       LocalDate parsedDob = LocalDate.parse(dob,format);
       this.dob = parsedDob;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public LocalDate getDob() {
        return dob;
    }
    public Date getEnrollmentDate() {
        return enrollmentDate;
    }
    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }

    

}
