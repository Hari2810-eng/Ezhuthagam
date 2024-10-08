package com.hari.ezhuthagam;

import java.util.Scanner;

public abstract class BaseView {
    protected Scanner sc;
    public BaseView() {
        this.sc = new Scanner(System.in);
    } 
    public abstract void onCreate(); 
    protected void showAlertMessage(String message){
        System.out.println("Info: "+message);
    }
    protected String getInput(String input) {
        System.out.print(input);
        return sc.nextLine();
    }
    protected int getIntInput(String input) {
        System.out.println(input);
        while(!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.next();
        }
        int result = sc.nextInt();
        sc.nextLine();
        return result;
    }
}
