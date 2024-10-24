package org.example.factory;

import java.io.FileWriter;
import java.io.IOException;

public class PdfDocument implements Document {
    @Override
    public void save(String content) throws IOException {
        try (FileWriter writer = new FileWriter("document.csv", true)) {
            writer.append("PDF,").append(content).append("\n");
        }
    }

}