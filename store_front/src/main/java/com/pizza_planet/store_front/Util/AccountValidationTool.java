package com.pizza_planet.store_front.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountValidationTool {
    private static final Pattern EMAIL_ADDRESS_PATTERN =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    //check if email is valid using regex
    public boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        if (email.isEmpty()) {
            return false;
        }
        Matcher m = EMAIL_ADDRESS_PATTERN.matcher(email);
        return m.matches();
    }
    //check if password is valid
    //8 chars atleast at most 16 one number one special and one uppercase
    public boolean isValidPassword(String password) {
        //check length
        if (password.length() < 8 || password.length() > 16){
            return false;
        }
        //check for at least one number
        else if (!password.matches(".*\\d.*")) {
            return false;
        }
        //check for at least one special
        else if (!password.matches(".*\\W.*")) {
            return false;
        }
        //check for at least one uppercase
        else return password.matches(".*[A-Z].*");
    }
    //check if username is valid no repeating or successive characters
    public boolean isValidUsername(String username) {
        //check if valid length
        if (username.length() < 6 || username.length() > 16){
            return false;
        }
        //check for repeating characters
        else if (username.matches("(.)\\1+")){
            return false;
        }
        //check for successive characters
        else return !username.matches("(.)\\1\\1+");
    }
}
