package org.example;

import org.example.factory.Document;
import org.example.factory.DocumentFactory;

import java.io.IOException;
import java.util.Scanner;

public class DocumentEditor {
    private DocumentFactory documentFactory = new DocumentFactory();

    public void createAndHandleDocument(String type, String content) {
        try {
            Document document = documentFactory.createDocument(type);
            document.save(content);
            System.out.println(type + " document saved to CSV file.");
        } catch (IOException e) {
            System.out.println("Error saving document: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor();

        // Example usage: saves to document.csv
        editor.createAndHandleDocument("PDF", "PDF content ");
        editor.createAndHandleDocument("Word", "Word content");
        editor.createAndHandleDocument("HTML", "HTML content");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter document type (PDF, Word, HTML) or type 'exit' to quit:");
            String docType = scanner.nextLine();

            if (docType.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            System.out.println("Enter document content:");
            String content = scanner.nextLine();

            editor.createAndHandleDocument(docType, content);
        }

        scanner.close();
    }
}