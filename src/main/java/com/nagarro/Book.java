package com.nagarro;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
public class Book {

    private static final long serialVersionUID = 1L;

    @Id
    private Long bookCode;

    private String bookName;
    private String author;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateAdded;


    public Book(Long bookCode, String bookName, String author, Date dateAdded) {
        this.author = author;
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.dateAdded = dateAdded;
    }
}
