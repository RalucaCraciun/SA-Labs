package org.example.structural;

import org.example.structural.entity.Book;
import org.example.structural.service.BestsellerBookDecorator;
import org.example.structural.service.FeaturedBookDecorator;
import org.example.structural.service.LibraryFacade;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookManagementApplication implements CommandLineRunner {

    private final LibraryFacade libraryFacade;

    public BookManagementApplication(LibraryFacade libraryFacade) {
        this.libraryFacade = libraryFacade;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book book = new Book("Design Patterns", "Erich Gamma", "Programming",25);
        libraryFacade.addBook(book);

        libraryFacade.getAllBooks().forEach(System.out::println);

        FeaturedBookDecorator featured = new FeaturedBookDecorator(book);
        BestsellerBookDecorator bestseller = new BestsellerBookDecorator(featured);
        System.out.println(bestseller.getFeatures());
    }
}