package org.acme.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.Book;
import org.acme.services.BookService;

import java.util.ArrayList;
import java.util.List;

@Path("/books")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController {

    @Inject
    BookService bookService;

    @GET
    public List<Book> findAllBooks() {

        List<Book> books = new ArrayList<>();
        try {
            books = bookService.findAllBooks();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao executar a operação: " + e.getMessage());
        }
        return books;
    }

    @POST
    public Response addBook(Book book) {
        try {
            bookService.addBook(book);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateBook(@PathParam("id") Long id, Book book) {
        Book bookToUpdate = bookService.findBookById(id);
        if(id == null || bookToUpdate == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Id não pode ser nulo").build();
        }
        try {
            bookService.updateBook(id, book);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
 }
