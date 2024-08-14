package com.Libarary.Systems.Services;

import com.Libarary.Systems.Models.Book;
import com.Libarary.Systems.Models.User;
import com.Libarary.Systems.Repo.BookRepo;
import com.Libarary.Systems.Repo.LibraryRepo;
import com.Libarary.Systems.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private LibraryRepo libraryRepo;


    //2 get methods 1 add method 1 update method 1 delete method


    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Optional<Book> getBookById(Integer bookId) {
        return bookRepo.findById(bookId);
    }

    public Optional<Book> getBookByName(String bookName) {
        return bookRepo.findByBookName(bookName);
    }

    public Optional<Book> getBookByAuthor(String bookAuthor) {
        return bookRepo.findByBookAuthor(bookAuthor);
    }


    public Book updateBook(Book updatedBook) {
        Book existingBook = bookRepo.findById(updatedBook.getBookId()).get();
        existingBook.setBookStatus(updatedBook.getBookStatus());
        return bookRepo.save(existingBook);
    }

    public String deleteBook(Integer bookId) {
        bookRepo.deleteById(bookId);
        return "Book Deleted Successfully";
    }


    public int feeCalculation(String bookIssueDate, String bookReturnDate,int numberOfBooksTaken) {

        if(numberOfBooksTaken>0){
              LocalDate issueDate = LocalDate.parse(bookIssueDate);
              LocalDate returnDate = LocalDate.parse(bookReturnDate);
            long daysBetween = DAYS.between(issueDate, returnDate);
            if (daysBetween > 7) {
                return (int) (daysBetween - 7) * 10;
            } else {
                return 0;
            }
        }
        else{
            return 0;
        }

    }
    public List<Book> getBooksByAvailability( ) {
        return bookRepo.findAvailableBooks();
    }

}