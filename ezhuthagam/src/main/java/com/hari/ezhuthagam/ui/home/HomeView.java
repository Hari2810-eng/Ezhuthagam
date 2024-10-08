package com.hari.ezhuthagam.ui.home;

import java.util.Scanner;

import com.hari.ezhuthagam.dto.User;
import com.hari.ezhuthagam.BaseView;
import com.hari.ezhuthagam.Ezhuthagam;
import com.hari.ezhuthagam.ui.login.LoginView;
import com.hari.ezhuthagam.ui.newdocument.NewView;
import com.hari.ezhuthagam.ui.open.OpenView;

public class HomeView extends BaseView{
    private HomeViewModel viewModel;

    public HomeView(){
        viewModel = new HomeViewModel(this);
    }

    public void onCreate() {
            System.out.println("Welcome to the Home Screen!");

            User currentUser = viewModel.getCurrentUser();
            if (currentUser != null) {
                System.out.println("Hello, " + currentUser.getUsername() + "!");
            } else {
                System.out.println("Hello, Guest!");
            }

            System.out.println("Please choose an option:");
            System.out.println("1. Create New Document");
            System.out.println("2. Open Existing Document");
            System.out.println("3. View Recent Documents");
            System.out.println("4. Logout");

            
            int choice = getIntInput("Enter your choice:");

            switch (choice) {
                case 1:
                    navigateToCreateDocument();
                    break;
                case 2:
                    navigateToOpenDocument();
                    break;
                case 3:
                    viewModel.logout();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    onCreate(); 
                    break;
            }
    }

    public void navigateToCreateDocument() {
        System.out.println("Navigating to create new document...");
        NewView newView = new NewView();
        newView.onCreate();
    }

    private void navigateToOpenDocument() {
        System.out.println("Navigating to open existing document...");
        OpenView openView = new OpenView();
        openView.onCreate();
    }

    public void navigateToLoginOrSignUpScreen() {
        Ezhuthagam.getInstance().onCreate();
    }
}
