package com.learning.aj.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String role;
    @OneToMany
    private List<Book> borrowedBooks;
}