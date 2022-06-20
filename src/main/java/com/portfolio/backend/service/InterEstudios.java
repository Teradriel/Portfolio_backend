package com.portfolio.backend.service;

import com.portfolio.backend.model.Estudios;
import java.util.List;

public interface InterEstudios {
    
    public List<Estudios> verEstudios();
    
    public void borrarEstudios(Long id);
    
    public Estudios buscarEstudio(Long id);
    
}
