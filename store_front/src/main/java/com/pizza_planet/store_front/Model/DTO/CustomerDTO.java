package com.pizza_planet.store_front.Model.DTO;

public class CustomerDTO {
    //name username and password can travel but not the whole customer object
    private String name,username,password;
    private String email;
    
    private Long customerID;
    public CustomerDTO() {}
   
    public CustomerDTO(String name, String username, String password,String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email=email;
    }

    public CustomerDTO(Long customerID,String name, String username, String password) {
        this.customerID = customerID;
        this.name = name;
        this.username = username;
        this.password = password;  
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
    public Long getCustomerID() {
        return customerID;
    }
    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    
}
