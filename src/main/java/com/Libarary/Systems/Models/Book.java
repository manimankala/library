package com.Libarary.Systems.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;


@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Book {
    @Id
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private Boolean bookStatus;//book available or not
    private String bookIssueDate;
    private String bookReturnDate;
}
