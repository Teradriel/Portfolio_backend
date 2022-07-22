package com.portfolio.backend.service;

import com.portfolio.backend.model.Experiencias;
import java.util.List;

public interface InterExperiencias {
    
    public List<Experiencias> verExp();
    
    public void borrarExp(Long id, Long user_id);
        
    public Experiencias buscarExp(Long id);
    
}
