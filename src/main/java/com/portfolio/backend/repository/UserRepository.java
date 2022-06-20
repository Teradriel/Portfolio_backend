package com.portfolio.backend.repository;

import com.portfolio.backend.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    public Optional<User> findByUsername(String user);
    public Boolean existsByUsername(String user);
    public Boolean existsByEmail(String email);
        
}
