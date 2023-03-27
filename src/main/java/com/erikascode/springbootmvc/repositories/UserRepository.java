package com.erikascode.springbootmvc.repositories;

import com.erikascode.springbootmvc.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
