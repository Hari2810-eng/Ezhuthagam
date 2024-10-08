package com.hari.ezhuthagam.dto;

import java.util.List;

public class User {
    private static int counter = 0;
    private int userId;        
    private String username;      
    private String password; 
    private List<Document> documents;
    public User() {
        this.userId = ++counter;
    }

    // public User(String userId, String username, String password, List<Document> documents) {
    //     this.userId = userId;
    //     this.username = username;
    //     this.password = password;
    //     this.documents = documents;
    // }

    public int getUserId() {
        return userId;
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

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
