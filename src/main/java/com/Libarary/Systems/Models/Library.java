package com.Libarary.Systems.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component

public class  Library {

    @Id
    private int libId;
    private String libName;
    private String libAddress;
    private String libPhone;

    @Autowired
    @JsonIgnoreProperties({"bookName", "bookAuthor", "bookStatus", "bookIssueDate", "bookReturnDate"})
    private Book book;


}
