package org.example.structural.controller;

import io.swagger.annotations.ApiParam;
import org.example.structural.dto.BookDto;
import org.example.structural.entity.Book;
import org.example.structural.utils.BookMapper;
import org.example.structural.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class LibraryController {

    private final BookService bookService;

    @Autowired
    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Retrieve all books", description = "Returns a list of all books in the library as BookDto objects")
    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks()
                .stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Get a book by ID", description = "Provide an ID to lookup a specific book in the library")
    @GetMapping("/{id}")
    public BookDto getBookById(@ApiParam("ID of the book to retrieve") @PathVariable Long id) {
        Book book = bookService.getBookById(id);

        if (book == null) {
            throw new BookNotFoundException("Book not found with ID: " + id); // Custom exception to handle this scenario
        }
        return BookMapper.toDTO(book);
    }

    @Operation(summary = "Add a new book", description = "Adds a new book to the library and returns the saved BookDto object")
    @PostMapping
    public BookDto addBook(@ApiParam("BookDto object to be added") @RequestBody BookDto BookDto) {
        Book book = BookMapper.toEntity(BookDto);
        Book savedBook = bookService.saveBook(book);
        return BookMapper.toDTO(savedBook);
    }

    @Operation(summary = "Update an existing book", description = "Updates an existing book by ID with new information from the BookDto object")
    @PutMapping("/{id}")
    public BookDto updateBook(
            @ApiParam("ID of the book to update") @PathVariable Long id,
            @ApiParam( "Updated BookDto object") @RequestBody BookDto updatedBookDto) {
        Book existingBook = bookService.getBookById(id);
        return BookMapper.toDTO(new Book());
        if (existingBook == null) {
            throw new BookNotFoundException("Book not found with ID: " + id);
        }
        existingBook.setTitle(updatedBookDto.getTitle());
        existingBook.setAuthor(updatedBookDto.getAuthor());
        existingBook.setPrice(updatedBookDto.getPrice());

        Book updatedBook = bookService.saveBook(existingBook);
        return BookMapper.toDTO(updatedBook);
    }

    @Operation(summary = "Delete a book by ID", description = "Deletes the book with the specified ID from the library")
    @DeleteMapping("/{id}")
    public void deleteBook(@ApiParam("ID of the book to delete") @PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            throw new BookNotFoundException("Book not found with ID: " + id);
        }
        bookService.deleteBook(id);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class BookNotFoundException extends RuntimeException {
        public BookNotFoundException(String message) {
            super(message);
        }
    }
}