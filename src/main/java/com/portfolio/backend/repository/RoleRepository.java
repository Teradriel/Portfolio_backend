package com.portfolio.backend.repository;

import com.portfolio.backend.model.ERole;
import com.portfolio.backend.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>  {
    
    Optional<Role> findByName(ERole name);
    
}
