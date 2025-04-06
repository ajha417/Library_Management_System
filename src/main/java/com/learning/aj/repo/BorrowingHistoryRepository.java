package com.learning.aj.repo;

import com.learning.aj.model.BorrowingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingHistoryRepository extends JpaRepository<BorrowingHistory, Integer> {
}
