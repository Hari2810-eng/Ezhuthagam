package com.hari.ezhuthagam.ui.edit;

import com.hari.ezhuthagam.BaseView;
import com.hari.ezhuthagam.dto.Document;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class EditView extends BaseView{
    private EditViewModel viewModel;
	private BaseView previousView;

    public EditView(Document doc, BaseView previousView) {
        this.viewModel = new EditViewModel(this, doc);
		this.previousView = previousView;
    }

    public void onCreate() {
        while(true) {
			System.out.println("\n\n");
	        System.out.println("=================================");
	        System.out.println("          MANAGE DOCUMENT        ");
	        System.out.println("=================================");
	        System.out.println("           1. ADD TEXT           ");
	        System.out.println("           2. DELETE TEXT        ");
	        System.out.println("           3. DISPLAY PAGE       ");
			System.out.println("           4. SAVE               ");
	        System.out.println("           5. GO BACK            ");
	        System.out.println("=================================");
	        System.out.println("\n\n");
			
			int choice = getIntInput("Enter your choice: ");
 
			
			switch(choice) {
				case 1:
					handleAddText();
					break;
				case 2:
					handleDeleteText();
					break;
				case 3:
					viewModel.displayPage();
					break;
				case 4:
					viewModel.saveDocument();
					break;
				case 5:
					previousView.onCreate();
					return;
				default:
					System.out.println("Invalid choice. Please try again.");		
			}	
		}
    }

    public void handleAddText() {
        System.out.println("\n\n");
        System.out.println("=================================");
        System.out.println("         ADDING ELEMENTS         ");
        System.out.println("=================================");
        System.out.println("        1. ADD WORD              ");
        System.out.println("        2. ADD LINE AT END       ");
        System.out.println("        3. ADD LINE IN MIDDLE    ");
        System.out.println("        4. ADD PARAGRAPH         ");
        System.out.println("        5. GO BACK               ");
        System.out.println("=================================");
        System.out.println("\n\n");
		
		int choice = getIntInput("Enter your choice: ");
 
		
		int lineIndex = 0;
		String line;
		
		switch (choice) {
			case 1:
				lineIndex = viewModel.isDocEmpty() ? 0 : getIntInput("Enter line index: ");
				int position = getIntInput("Enter position in line: ");
                String word = getInput("Enter word: ");
                
                viewModel.insert(word, lineIndex, position);
                break;
			case 2:
				line = getInput("Enter line: ");
				viewModel.insert(line);
				break;
			case 3:
				lineIndex = viewModel.isDocEmpty() ? 0 : getIntInput("Enter line index: ");
				line = getInput("Enter line: ");
				viewModel.insert(line, lineIndex);
				break;
			case 4:
				List<String> para = new ArrayList<>();
				
				System.out.println("Enter the paragraph lines with empty line at end: ");
				
				while(true) {
					line = getInput("");
					if(line.isEmpty()) break;
					para.add(line);
				}
				
				lineIndex = viewModel.isDocEmpty() ? 0 : getIntInput("Enter line index: ");
                viewModel.insert(para, lineIndex);
                break;
			case 5:
				
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			
		}
    }

    public void handleDeleteText() {
        System.out.println("\n\n");
        System.out.println("=================================");
        System.out.println("        DELETING ELEMENTS        ");
        System.out.println("=================================");
        System.out.println("    1. DELETE PART OF SENTENCE   ");
        System.out.println("    2. DELETE LINE               ");
        System.out.println("    3. DELETE PARAGRAPH          ");
        System.out.println("    4. GO BACK                   ");
        System.out.println("=================================");
        System.out.println("\n\n");
		
        if(viewModel.isDocEmpty()){
            System.out.println("Document is empty.");
            return;
        }
		int choice = getIntInput("Enter your choice: ");

		switch (choice) {
			case 1:
				int lineIndex = getIntInput("Enter line index: ");
				int fromIndex = getIntInput("Enter from index: ");
				int toIndex = getIntInput("Enter to index: ");
				viewModel.delete(lineIndex, fromIndex, toIndex);
				break;
			case 2:
				lineIndex = getIntInput("Enter line index: ");
				viewModel.delete(lineIndex);
				break;
			case 3:
				fromIndex = getIntInput("Enter from index: ");
				toIndex = getIntInput("Enter to index: ");
				viewModel.delete(fromIndex, toIndex);
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			
		}
    }

}
