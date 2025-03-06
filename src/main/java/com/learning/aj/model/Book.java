package com.learning.aj.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "no_of_pages1")
    private int noOfPages;
    private String isbn;
    @Column(name = "is_available")
    private boolean availability;
    private String publisher;
    @Column(name = "publication_date")
    private Date publicationDate;

    private double price;
    private String edition;
    private String genre;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
