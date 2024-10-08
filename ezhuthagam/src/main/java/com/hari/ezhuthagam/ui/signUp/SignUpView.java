package com.hari.ezhuthagam.ui.signUp;

import com.hari.ezhuthagam.BaseView;
import com.hari.ezhuthagam.datalayer.EzhuthagamRepo;
import com.hari.ezhuthagam.ui.home.HomeView;

public class SignUpView extends BaseView {
    private SignUpViewModel viewModel = new SignUpViewModel();

    public void onCreate() {
        System.out.println("Welcome to Sign Up");

        String username, password ;
        String userNameError, passwordError;

        do{
            username = getInput("Enter username: ");
            userNameError = viewModel.isCredentialValid(username);
            if(userNameError != null)
                showAlertMessage(userNameError);
            
        } while(userNameError != null);
        do {
            password = getInput("Enter password: ");
            passwordError = viewModel.isPasswordValid(password);
            if (passwordError != null) 
                showAlertMessage(passwordError);
            
        } while (passwordError != null);

        String result = viewModel.addNewUser(username, password);
        showAlertMessage(result);
        if(result.equals("New account is created successfully.")){
            HomeView homeView = new HomeView();
            homeView.onCreate();
        } else {
            showAlertMessage("Please try signing up again.");
            this.onCreate();
        }
    }
   
}
