package org.example.factory;

import java.io.IOException;

public interface Document {
    void save(String content) throws IOException;
}
