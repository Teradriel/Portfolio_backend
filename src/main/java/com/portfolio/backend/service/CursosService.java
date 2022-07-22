package com.portfolio.backend.service;

import com.portfolio.backend.model.Cursos;
import com.portfolio.backend.model.User;
import com.portfolio.backend.repository.CursosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursosService implements InterCursos{
    
    @Autowired
    public CursosRepository cursoRepo;
    
    @Autowired
    private InterUser userServ;
    
    @Override
    public List<Cursos> verCursos(){
        return cursoRepo.findAll();
    }
        
    @Override
    @Transactional
    public void borrarCursos(Long id, Long user_id){
        User currentUser = userServ.buscarUser(user_id);
        Cursos curso = cursoRepo.getById(id);
        currentUser.getCurso().remove(curso);
    }
    
    @Override
    public Cursos buscarCursos(Long id){
        return cursoRepo.findById(id).orElse(null);
    }    
}
