package org.example.structural.service;

import org.example.structural.entity.Book;

public class FeaturedBookDecorator extends BookDecorator {

    public FeaturedBookDecorator(Book book) {
        super(book);
    }


    @Override
    public String getFeatures() {
        return "This is a featured book with extra content!";  // Customize the features
    }
}