package com.learning.aj.repo;

import com.learning.aj.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    public Optional<Users> findByUserName(String userName);
}
