package com.learning.aj.model;

import com.learning.aj.enums.ERole;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String password;
    private ERole eRole;
    @OneToMany(mappedBy = "users")
    private List<BorrowingHistory> borrowingHistories;

    public Users() {
    }

    public Users(int id, String name, String phoneNumber, String email, String password, ERole role, List<BorrowingHistory> borrowingHistories) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.eRole = role;
        this.borrowingHistories = borrowingHistories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ERole getRole() {
        return eRole;
    }

    public void setRole(ERole role) {
        this.eRole = role;
    }

    public List<BorrowingHistory> getBorrowingHistories() {
        return borrowingHistories;
    }

    public void setBorrowingHistories(List<BorrowingHistory> borrowingHistories) {
        this.borrowingHistories = borrowingHistories;
    }
}