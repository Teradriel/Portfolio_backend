package com.portfolio.backend.service;

import com.portfolio.backend.model.Experiencias;
import com.portfolio.backend.repository.ExperienciasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciasService implements InterExperiencias{
    
    @Autowired
    public ExperienciasRepository expRepo;
    
    @Override
    public List<Experiencias> verExp(){
        return expRepo.findAll();
    }
    
    @Override
    public void editarExp(Experiencias exp){
        expRepo.save(exp);
    }
    
    @Override
    public void borrarExp(Long id){
        expRepo.deleteById(id);
    }
    
    @Override
    public Experiencias buscarExp(Long id){
        return expRepo.findById(id).orElse(null);
    }
    
    
}
