package com.hari.ezhuthagam.ui.newdocument;

import com.hari.ezhuthagam.BaseView;
import com.hari.ezhuthagam.dto.Document;
import com.hari.ezhuthagam.ui.edit.EditView;
import com.hari.ezhuthagam.ui.home.HomeView;

import java.util.Scanner;

public class NewView extends BaseView {
    private NewViewModel viewModel;

    public NewView() {
        viewModel = new NewViewModel(this);
    }

    public void onCreate() {
        System.out.println("Creating a new document...");
        String documentName = getInput("Enter document name (or type 'back' to go to home):");
        if(documentName.equalsIgnoreCase("back")){
            navigateToHome();
            return;
        }
        viewModel.createDocument(documentName);
    }

    public void onDocumentCreated(Document document){
        System.out.println("Document '" + document.getName() +"' created successfully.");
        EditView editView = new EditView(document, this);
        editView.onCreate();
    }

    private void navigateToHome() {
        HomeView homeView = new HomeView();
        homeView.onCreate();
    }
}
