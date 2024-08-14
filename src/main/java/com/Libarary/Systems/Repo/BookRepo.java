package com.Libarary.Systems.Repo;

import com.Libarary.Systems.Models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepo extends MongoRepository<Book, Integer> {
    @Query("{ 'bookName': ?0 }")
    Optional<Book> findByBookName(String bookName);
    @Query("{'bookAuthor':?0}")
    Optional<Book> findByBookAuthor(String bookAuthor);

    @Query("{ 'bookStatus': true }")
    List<Book> findAvailableBooks();

}
