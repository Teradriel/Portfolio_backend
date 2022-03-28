package com.portfolio.backend.repository;

import com.portfolio.backend.model.Introduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntroduccionRepository extends JpaRepository<Introduccion, Long>{
    
}
