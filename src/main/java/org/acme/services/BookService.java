package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.Book;
import org.acme.repository.BookRepository;

import java.util.List;

@ApplicationScoped
public class BookService  {
    @Inject
    BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll().list();
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void addBook(Book book) {
        bookRepository.persist(book);
    }

    public void updateBook(long id, Book book) { bookRepository.update(""); }
}
