package com.hari.ezhuthagam.ui.open;

import com.hari.ezhuthagam.BaseView;
import com.hari.ezhuthagam.dto.Document;
import com.hari.ezhuthagam.ui.edit.EditView;
import com.hari.ezhuthagam.ui.home.HomeView;

import java.util.List;

public class OpenView extends BaseView {
    private OpenViewModel viewModel;

    public OpenView() {
        viewModel = new OpenViewModel(this);
    }

    public void onCreate() {
        showDocumentList();
        
    }

    public void showDocumentList() {
        System.out.println("Listing all existing document...");

        List<String> docNames = viewModel.getDocumentNames();
        
        if(docNames == null || docNames.isEmpty()){
            System.out.println("No existing document.");
            navigateToHome();
        }
            
        else{
            for(int i=0; i<docNames.size() ; i++){
                System.out.println((i+1) + ". " + docNames.get(i));
            }
            System.out.println((docNames.size() +1)+". Go Back to Home");
            selectDocument(docNames.size() +1);
        }
            
    }

    public void selectDocument(int backOption) {
        Document document = null;
        do {
            int choice = getIntInput("Enter document number or " + backOption + " to go back: ");
            if (choice == backOption ){
                navigateToHome();
                return;
            }

            if (choice < 1 || choice > backOption - 1) {
                System.out.println("Invalid choice, please try again.");
                continue;
            }

            String documentName = viewModel.getDocumentNames().get(choice - 1);
            document = viewModel.openDocument(documentName); 

            if (document == null) {
                System.out.println("Document not found, please try again.");
            }
        } while (document == null);

        EditView editView = new EditView(document, this);
        editView.onCreate();
    }
    private void navigateToHome() {
        HomeView homeView = new HomeView();
        homeView.onCreate();
    }
}
