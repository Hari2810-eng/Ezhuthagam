package com.hari.ezhuthagam.ui.newdocument;

import com.hari.ezhuthagam.datalayer.EzhuthagamRepo;
import com.hari.ezhuthagam.dto.Document;


import java.util.ArrayList;
import java.time.LocalDateTime;

class NewViewModel {
    private NewView view;

    public NewViewModel(NewView view) {
        this.view = view;
    }

    public void createDocument(String documentName) {
        Document newDocument = new Document();
        newDocument.setName(documentName);
        newDocument.setContent(new ArrayList<>());
        view.onDocumentCreated(newDocument);
    }
}
