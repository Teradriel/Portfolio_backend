package com.portfolio.backend.service;

import com.portfolio.backend.model.Introduccion;
import com.portfolio.backend.repository.IntroduccionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntroduccionService implements InterIntroduccion{
    @Autowired
    public IntroduccionRepository introRepo;
    
    @Override
    public List<Introduccion> verIntrod(){
        return introRepo.findAll();
    }
    
    @Override
    public void editarIntrod(Introduccion intro){
        introRepo.save(intro);
    }
    
    @Override
    public void borrarIntrod(Long id){
        introRepo.deleteById(id);
    }
    
    @Override
    public Introduccion buscarIntrod(Long id){
        return introRepo.findById(id).orElse(null);
    }
}
