package org.example.factory;

public class DocumentFactory {
    public Document createDocument(String type) {
        switch (type) {
            case "PDF":
                return new PdfDocument();
            case "Word":
                return new WordDocument();
            case "HTML":
                return new HtmlDocument();
            default:
                throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }
}
