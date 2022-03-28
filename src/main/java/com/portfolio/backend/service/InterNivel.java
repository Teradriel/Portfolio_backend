package com.portfolio.backend.service;

import com.portfolio.backend.model.Nivel;
import java.util.List;

public interface InterNivel {
    
    public List<Nivel> verNivel();
    
    public void borrarNivel(Long id);
    
    public void editarNivel(Nivel niv);
    
    public Nivel buscarNivel(Long id);
    
}
