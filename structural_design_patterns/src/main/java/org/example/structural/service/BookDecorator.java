package org.example.structural.service;


import org.example.structural.entity.Book;


public abstract class BookDecorator extends Book {
    protected Book book;

    public BookDecorator(Book book) {
        super(book.getTitle(), book.getAuthor(), book.getCategory(), book.getPrice());  // Pass parameters to Book constructor
        this.book = book;
    }

    public abstract String getFeatures();

    public abstract String getDescription();
}