package org.example.structural.service;


import org.example.structural.entity.Book;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class LibraryFacade {
    private final BookService bookService;

    public LibraryFacade(BookService bookService) {
        this.bookService = bookService;
    }

    public Book addBook(Book book) {
        return bookService.saveBook(book);
    }

    public List<Book> findBooksByCategory(String category) {
        return bookService.findByCategory(category);
    }

    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}
