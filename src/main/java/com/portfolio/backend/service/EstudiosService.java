package com.portfolio.backend.service;

import com.portfolio.backend.model.Estudios;
import com.portfolio.backend.repository.EstudiosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudiosService implements InterEstudios{
    
    @Autowired
    public EstudiosRepository estudioRepo;
    
    @Override
    public List<Estudios> verEstudios(){
        return estudioRepo.findAll();
    }
    
    @Override
    public void editarEstudios(Estudios estud){
        estudioRepo.save(estud);
    }
    
    @Override
    public void borrarEstudios(Long id){
        estudioRepo.deleteById(id);
    }
    
    @Override
    public Estudios buscarEstudios(Long id){
        return estudioRepo.findById(id).orElse(null);
    }
    
}
