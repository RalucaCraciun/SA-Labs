package org.example.structural.utils;


import org.example.structural.dto.BookDto;
import org.example.structural.entity.Book;
import org.example.structural.service.BookDecorator;

public class BookMapper {

    // Convert Book entity to BookDto
    public static BookDto toDTO(BookDecorator book) {
        BookDto dto = new BookDto();
        dto.setTitle(book.getDescription());  // Use decorated description instead of just title
        dto.setAuthor(book.getAuthor());  // Assuming author is not affected by decorators
        dto.setPrice(book.getPrice());
        return dto;
    }

    // Convert BookDto to Book entity (without decoration)
    public static Book toEntity(BookDto dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());  // This will be the base title
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        return book;
    }
}

