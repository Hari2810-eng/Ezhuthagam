package com.hari.ezhuthagam.ui.open;

import com.hari.ezhuthagam.datalayer.EzhuthagamRepo;
import com.hari.ezhuthagam.dto.Document;

import java.util.List;
import java.util.stream.Collectors;

class OpenViewModel {
    private OpenView view;
    public OpenViewModel(OpenView view) {
        this.view = view;
    }

    public List<String> getDocumentNames() {
        List<Document> documents = EzhuthagamRepo.getInstance().getDocumentList();
        return documents.stream()
                .map(Document::getName)
                .collect(Collectors.toList());

    }
    public Document openDocument(String documentName) {
        List<Document> documents = EzhuthagamRepo.getInstance().getDocumentList();
        Document document = documents.stream()
                            .filter(doc -> doc.getName().equalsIgnoreCase(documentName))
                            .findFirst()
                            .orElse(null);
        return document;
    }

}
