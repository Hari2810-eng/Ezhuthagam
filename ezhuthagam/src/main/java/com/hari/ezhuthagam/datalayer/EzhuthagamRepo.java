package com.hari.ezhuthagam.datalayer;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hari.ezhuthagam.dto.Document;
import com.hari.ezhuthagam.dto.User;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class EzhuthagamRepo {
    private User loggedUser;
    private static final String DOCUMENT_FILE_PATH = "resources/users.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /*
     * private static EzhuthagamRepo repo;
     * 
     * public Static EzhuthagamRepo getInstance() {
     *      repo = new EzhuthagamRepo();     
     * }
     */

    private EzhuthagamRepo() {
    }

    private static class SingletonHelper {
        private static final EzhuthagamRepo INSTANCE = new EzhuthagamRepo();
    }
    
    public static EzhuthagamRepo getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public User validate(String userName, String password) {
        File jsonFile = new File(DOCUMENT_FILE_PATH);
        try {
            List<User> users = objectMapper.readValue(jsonFile, new TypeReference<List<User>>() {});
            return users.stream()
                .filter(user -> userName.equals(user.getUsername()) && password.equals(user.getPassword()))
                .findFirst()
                .map(user -> { 
                    setLoggedUser(user); 
                    return user;
                })
                .orElse(null); 

        } catch (StreamReadException | DatabindException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return null;
    }

    public boolean isLoggedIn() {
        return false;
    }

    public List<Document> getDocumentList() {
        File jsonFile = new File(DOCUMENT_FILE_PATH);
        try {
            List<User> users = objectMapper.readValue(jsonFile, new TypeReference<List<User>>() {});

            return users.stream()
                .filter(user -> loggedUser.getUserId() == user.getUserId())
                .findFirst()
                .map(User::getDocuments) 
                .orElse(Collections.emptyList()); 

        } catch (StreamReadException | DatabindException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return Collections.emptyList();
    }

    public String saveDocument(Document document) {
        File jsonFile = new File(DOCUMENT_FILE_PATH);
        try {
            List<User> users = objectMapper.readValue(jsonFile, new TypeReference<List<User>>() {});

            users.stream()
                .filter(user -> loggedUser.getUserId() == user.getUserId())
                .findFirst()
                .ifPresent(user -> {
                    Optional<Document> existingDocument = user.getDocuments().stream()
                        .filter(doc -> doc.getId() == document.getId())
                        .findFirst();

                    if (existingDocument.isPresent()) {
                        existingDocument.get().setName(document.getName());
                        existingDocument.get().setContent(document.getContent());
                        
                    } else {
                        user.getDocuments().add(document);
                    }
                });

            objectMapper.writeValue(jsonFile, users);
            return "Document '" + document.getName() + "' is saved successfully.";

        } catch (IOException e) {
            return "Error writing document to file: " + e.getMessage();
        }
    }

    public boolean isCredentialValid(String username) {
        File jsonFile = new File(DOCUMENT_FILE_PATH);
        try{
            List<User> users = objectMapper.readValue(jsonFile, new TypeReference<List<User>>() {});
            return users.stream()
                .anyMatch(user -> user.getUsername().equalsIgnoreCase(username));
        } catch (StreamReadException | DatabindException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return false;
    }

    public String createAndAddNewUser(String username, String password) {
        File jsonFile = new File(DOCUMENT_FILE_PATH);
        List<User> users;
        try{
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setDocuments(new ArrayList<>());
            users = objectMapper.readValue(jsonFile, new TypeReference<List<User>>() {});
            
            users.add(newUser);
            
            objectMapper.writeValue(jsonFile, users);
            
            return "New account is created successfully.";

        } catch (IOException e) {
            return "Error in signing up: " + e.getMessage();
        }
    }
}
