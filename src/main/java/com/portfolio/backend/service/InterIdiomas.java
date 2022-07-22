package com.portfolio.backend.service;

import com.portfolio.backend.model.Idiomas;
import java.util.List;

public interface InterIdiomas {
    
    public List<Idiomas> verIdiomas();
    
    public void borrarIdiomas(Long id, Long user_id);
        
    public Idiomas buscarIdiomas(Long id);
    
}
