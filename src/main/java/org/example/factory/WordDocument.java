package org.example.factory;

import java.io.FileWriter;
import java.io.IOException;

public class WordDocument implements Document {
    @Override
    public void save(String content) throws IOException {
        try (FileWriter writer = new FileWriter("document.csv", true)) {
            writer.append("Word,").append(content).append("\n");
        }
    }

}