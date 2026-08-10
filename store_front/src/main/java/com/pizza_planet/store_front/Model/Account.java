package com.pizza_planet.store_front.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class Account{
    // i as a user have a name email birthday password and address
    String name,username;
    String password;



    LocalDate dob;
    
    Date enrollmentDate;        
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
    

}
