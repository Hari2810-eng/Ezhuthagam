package com.hari.ezhuthagam.ui.signUp;

import java.util.Scanner;

import com.hari.ezhuthagam.datalayer.EzhuthagamRepo;
import com.hari.ezhuthagam.dto.User;

class SignUpViewModel {
    public String isCredentialValid(String username) {
        if(username == null || username.isEmpty())
            return "Username cannot be empty.";
        if(username.length() < 3)
            return "Username must be atleast 3 characters long.";
        if(EzhuthagamRepo.getInstance().isCredentialValid(username)){
            return "Username already exists. Please choose a diffrent username.";
        }
        return null;
    }

    public String isPasswordValid(String password){
        if(password == null || password.isEmpty())
            return "Password cannot be empty.";
        if (password.length() < 6) 
                return "Password must be at least 6 characters long.";
        if (!password.matches(".*\\d.*")) 
                return "Password must contain at least one digit.";
        if (!password.matches(".*[a-zA-Z].*")) 
                return "Password must contain at least one letter.";
        return null;
    }

    public String addNewUser(String username, String password) {
        return EzhuthagamRepo.getInstance().createAndAddNewUser(username, password);
    }
}
