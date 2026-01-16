package com.booking_API.demo.repository;

import com.booking_API.demo.dto.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByusername(String username);
}
