package com.hari.ezhuthagam.ui.login;


import com.hari.ezhuthagam.dto.User;
import com.hari.ezhuthagam.BaseView;
import com.hari.ezhuthagam.ui.home.HomeView;

import java.util.Scanner;

public class LoginView extends BaseView{
    private LoginViewModel viewModel;

    public LoginView() {
        viewModel = new LoginViewModel(this);
    }

    public void onCreate() {
        System.out.println("Welcome to the Text Editor Application");
        System.out.println("--------------Login-------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the UserName: ");
        String userName = sc.next();
        System.out.println("Enter the password: ");
        String password = sc.next();
        System.out.println("--------------------------------");
        viewModel.validateUser(userName, password);
    }

    public void navigateToHome(User loggedUser) {
        System.out.println("Welcome " + loggedUser.getUsername());
        HomeView homeScreen = new HomeView();
        homeScreen.onCreate();
    }

    public void showErrorMsg(String message) {
        System.out.println(message);
    }
}
