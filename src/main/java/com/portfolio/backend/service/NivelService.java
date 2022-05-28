package com.portfolio.backend.service;

import com.portfolio.backend.model.Nivel;
import com.portfolio.backend.repository.NivelRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NivelService implements InterNivel{
    
    @Autowired
    public NivelRepository nivelRepo;
    
    @Override
    public List<Nivel> verNivel(){
        return nivelRepo.findAll();
    }
        
    @Override
    public Nivel buscarNivel(Long id){
        return nivelRepo.findById(id).orElse(null);
    }
    
}
