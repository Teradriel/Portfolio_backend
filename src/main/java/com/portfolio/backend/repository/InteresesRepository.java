package com.portfolio.backend.repository;

import com.portfolio.backend.model.Intereses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresesRepository extends JpaRepository<Intereses, Long>{
    
}
