package org.example.factory;

import java.io.FileWriter;
import java.io.IOException;

public class HtmlDocument implements Document {
    @Override
    public void save(String content) throws IOException {
        try (FileWriter writer = new FileWriter("document.csv", true)) {
            writer.append("HTML,").append(content).append("\n");
        }
    }

}