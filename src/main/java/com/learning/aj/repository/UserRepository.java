package com.learning.aj.repository;

import com.learning.aj.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {

    public Optional<Users> findByEmail(String userName);
}
