package com.hari.ezhuthagam.ui.login;

import com.hari.ezhuthagam.datalayer.EzhuthagamRepo;
import com.hari.ezhuthagam.dto.User;

class LoginViewModel {
    private LoginView view;

    public LoginViewModel(LoginView view){
        this.view = view;
    }

    public void validateUser(String userName, String password){
        User loggedUser = EzhuthagamRepo.getInstance().validate(userName, password);
        if (loggedUser != null) 
            view.navigateToHome(loggedUser);
        else    
            view.showErrorMsg("Invalid Username or Password.");
    }
    
}
