package com.learning.aj.model;

import com.learning.aj.enums.EStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "borrowing_history")
public class BorrowingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "borrowing_id")
    private int borrowingId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EStatus eStatus;

    @Column(name = "borrow_date")
    private Date borrowDate;

    @Column(name = "return_date")
    private Date returnDate;
}
