package com.hari.ezhuthagam;

import com.hari.ezhuthagam.datalayer.EzhuthagamRepo;
import com.hari.ezhuthagam.ui.home.HomeView;
import com.hari.ezhuthagam.ui.login.LoginView;
import com.hari.ezhuthagam.ui.signUp.SignUpView;

public class Ezhuthagam {

    private static Ezhuthagam ezhuthagam;

    private Ezhuthagam() {}

    private String appName = "Text Editor Application";
    
    public String appVersion = "0.0.4";

    public static Ezhuthagam getInstance(){
        if(ezhuthagam == null)
            ezhuthagam = new Ezhuthagam();
        return ezhuthagam;
    }
    public static void main(String args[]){
        Ezhuthagam.getInstance().onCreate();
    }
    public void onCreate() {
        if(EzhuthagamRepo.getInstance().isLoggedIn()){
            HomeView homeView = new HomeView();
            homeView.onCreate();
        } else {
            System.out.println("1. Log In\n2. Sign Up");
            int choice = new java.util.Scanner(System.in).nextInt();
            if(choice == 1) {
                LoginView loginView = new LoginView();
                loginView.onCreate();
            } else if(choice == 2) {
                SignUpView signUpView = new SignUpView();
                signUpView.onCreate();
            }
            
        }
    }
    public boolean hasNetworkConnection() {
		return checkConnection();
    }

	private boolean checkConnection() {
		return true; 
    }
}
