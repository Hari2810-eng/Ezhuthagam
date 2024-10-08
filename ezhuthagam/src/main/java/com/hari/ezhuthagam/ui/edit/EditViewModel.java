package com.hari.ezhuthagam.ui.edit;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import com.hari.ezhuthagam.datalayer.EzhuthagamRepo;
import com.hari.ezhuthagam.dto.Document;

class EditViewModel {
    private Document doc;

    EditViewModel(EditView view, Document doc) {
        this.doc = doc;
    }

    public boolean isDocEmpty(){
        return doc.getContent().isEmpty();
    }
    public void insert(String word, int lineIndex, int position) {
		lineIndex--;
		position--;
		if(doc.getContent().isEmpty()) {
			doc.getContent().add("");
		}
		if(lineIndex>=0 && lineIndex<doc.getContent().size()) {
			String line = doc.getContent().get(lineIndex);
			if(position>=0 && position<=line.length()) {
				String str = new StringBuilder(line).insert(position,  word).toString();
				doc.getContent().set(lineIndex, str);
			} else {
				System.out.println("Invalid position." + position);
			}
		} else {
			System.out.println("Invalid Line Index." + lineIndex);
		}
	}
	
	
	public void insert(String line, int lineIndex) {
		lineIndex--;
		if(lineIndex>=0 && lineIndex<doc.getContent().size()) {
			doc.getContent().add(lineIndex, line);
		} else {
			System.out.println("Invalid line Index.");
		}
	}
	
	
	public void insert(String line) {
		doc.getContent().add(line);
	}
	
	
	public void insert(List<String> para, int lineIndex) {
        
		if(lineIndex>=0 && lineIndex<=doc.getContent().size()) {
			doc.getContent().addAll(lineIndex, para);
		} else {
			System.out.println("Invalid line Index.");
		}
	}

    public String delete(int lineIndex, int fromIndex, int toIndex) {
        lineIndex--;
        fromIndex--;
        toIndex--;
		if(lineIndex >= 0 && lineIndex < doc.getContent().size()) {
			String line = doc.getContent().get(lineIndex);
			if(fromIndex >= 0 && toIndex <= line.length() && fromIndex <= toIndex) {
				String deleted = line.substring(fromIndex, toIndex);
				String newLine = line.substring(0, fromIndex) + line.substring(toIndex+1);
				doc.getContent().set(lineIndex, newLine);
				return deleted;
			} else {
				System.out.print("Invalid character indices.");
				return null;
			}
			
		} else {
			System.out.println("Invalid line Index.");
			return null;
		}
	}

    public String delete(int lineIndex) {
        lineIndex--;
		if(lineIndex>=0 && lineIndex<doc.getContent().size()) {
			String deleted = doc.getContent().get(lineIndex);
			doc.getContent().remove(lineIndex);
			return deleted;
		} else {
			System.out.println("Invalid line Index.");
			return null;
		}
	}

    public List<String> delete(int fromLineIndex, int toLineIndex ){
        fromLineIndex--;
        toLineIndex--;
		if(fromLineIndex >= 0 && toLineIndex < doc.getContent().size() && fromLineIndex <= toLineIndex) {
			List<String> deleted = new ArrayList<>(doc.getContent().subList(fromLineIndex, toLineIndex+1));
			doc.getContent().subList(fromLineIndex, toLineIndex + 1).clear();
			return deleted;
		} else {
			System.out.print("Invalid indices.");
			return null;
		}
	}
    public void displayPage() {
		if(doc.getContent().isEmpty())
			System.out.print("The Document is Empty");
		else {
			for(int i=0; i<doc.getContent().size(); i++) {
				System.out.println((i+1) + "\t" + doc.getContent().get(i));
			}
		}
	}
	public void saveDocument(){
		System.out.println(EzhuthagamRepo.getInstance().saveDocument(doc));
	}

}
