package com.portfolio.backend.service;

import com.portfolio.backend.model.Cursos;
import java.util.List;

public interface InterCursos {
    
    public List<Cursos> verCursos();
    
    public void borrarCursos(Long id);
    
    public void editarCursos(Cursos estud);
    
    public Cursos buscarCursos(Long id);
    
}
