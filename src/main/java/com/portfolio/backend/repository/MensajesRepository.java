package com.portfolio.backend.repository;

import com.portfolio.backend.model.Mensajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajesRepository extends JpaRepository<Mensajes, Long>{
    
}
