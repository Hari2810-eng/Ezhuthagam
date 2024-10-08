package com.hari.ezhuthagam.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Document {
    private static int counter=0;
    private int id;              
    private String name;            
    private List<String> content; 
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")   
    private String creationDate;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String lastModifiedDate;
    public Document() {
        this.id = ++counter;
        this.creationDate = LocalDateTime.now().format(formatter);
        this.lastModifiedDate = creationDate;
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
        updateLastModifiedDate();
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    private void updateLastModifiedDate() {
        this.lastModifiedDate = LocalDateTime.now().format(formatter);
    }
    

    @Override
    public String toString() {
        return "DocumentDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", content=" + content +
                ", creationDate=" + creationDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
