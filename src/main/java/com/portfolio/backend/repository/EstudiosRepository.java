package com.portfolio.backend.repository;

import com.portfolio.backend.model.Estudios;
//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiosRepository extends JpaRepository<Estudios, Long>{
    
//    public List<Estudios> findAllByUser(Long user_id);
    
}
