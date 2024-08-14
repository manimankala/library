package com.Libarary.Systems.Controller;


import com.Libarary.Systems.Models.Book;
import com.Libarary.Systems.Services.BookService;
import com.Libarary.Systems.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> findAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Optional<Book> findBookById(@PathVariable Integer bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/name")
    public Optional<Book> findBookByName(@RequestParam String bookName) {
        return bookService.getBookByName(bookName);
    }
    @GetMapping("/author")
    public Optional<Book> findBookByAuthor(@RequestParam String bookAuthor) {
        return bookService.getBookByAuthor(bookAuthor);
    }



    @PutMapping
    public Book changeBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{bookId}")
    public String removeBook(@PathVariable Integer bookId) {
        return bookService.deleteBook(bookId);
    }


    @GetMapping("/fee")
    public int calculateFee(@RequestParam String bookIssueDate, @RequestParam
                            String bookReturnDate, @RequestParam int numberOfBooksTaken) {
        return bookService.feeCalculation(bookIssueDate, bookReturnDate, numberOfBooksTaken);
    }

    @GetMapping("/available")
    public List<Book> availableBooks() {
        return bookService.getBooksByAvailability();
    }
}