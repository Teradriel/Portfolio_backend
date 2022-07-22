package com.portfolio.backend.service;

import com.portfolio.backend.model.Intereses;
import java.util.List;

public interface InterIntereses {
    
    public List<Intereses> verIntereses();
    
    public void borrarIntereses(Long id, Long user_id);
        
    public Intereses buscarIntereses(Long id);
    
}
