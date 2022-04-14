package com.portfolio.backend.repository;

import com.portfolio.backend.model.Idiomas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdiomasRepository extends JpaRepository<Idiomas, Long>{
    
}
