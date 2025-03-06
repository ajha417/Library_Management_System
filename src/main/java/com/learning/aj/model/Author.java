package com.learning.aj.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private int authorId;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "biography", columnDefinition = "text")
    private String biography;

    @OneToMany(mappedBy = "author")
    private Set<Book> books;
}
