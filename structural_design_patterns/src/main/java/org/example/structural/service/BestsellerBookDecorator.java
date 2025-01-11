package org.example.structural.service;

import org.example.structural.entity.Book;

public class BestsellerBookDecorator extends BookDecorator {

    public BestsellerBookDecorator(Book book) {
        super(book);
    }

    @Override
    public String getDescription() {
        return book.getDescription() + " - Bestseller";  // Customize the description
    }

    @Override
    public String getFeatures() {
        return book.getTitle() + " [Bestseller]";
    }
}
