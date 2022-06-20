package com.portfolio.backend.service;

import com.portfolio.backend.model.Cursos;
import com.portfolio.backend.repository.CursosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursosService implements InterCursos{
    
    @Autowired
    public CursosRepository cursoRepo;
    
    @Override
    public List<Cursos> verCursos(){
        return cursoRepo.findAll();
    }
    
    @Override
    public void editarCursos(Cursos curs){
        cursoRepo.save(curs);
    }
    
    @Override
    public void borrarCursos(Long id){
        cursoRepo.deleteById(id);
    }
    
    @Override
    public Cursos buscarCursos(Long id){
        return cursoRepo.findById(id).orElse(null);
    }    
}
