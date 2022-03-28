package com.portfolio.backend.service;

import com.portfolio.backend.model.Introduccion;
import java.util.List;

public interface InterIntroduccion {
    
    public List<Introduccion> verIntrod();
    
    public void borrarIntrod(Long id);
    
    public void editarIntrod(Introduccion intro);
    
    public Introduccion buscarIntrod(Long id);
    
}
