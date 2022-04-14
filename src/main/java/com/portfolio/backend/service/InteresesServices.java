package com.portfolio.backend.service;

import com.portfolio.backend.model.Intereses;
import com.portfolio.backend.repository.InteresesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteresesServices implements InterIntereses{
    
    @Autowired
    public InteresesRepository interesRepo;
    
    @Override
    public List<Intereses> verIntereses(){
        return interesRepo.findAll();
    }
    
    @Override
    public void editarIntereses(Intereses estud){
        interesRepo.save(estud);
    }
    
    @Override
    public void borrarIntereses(Long id){
        interesRepo.deleteById(id);
    }
    
    @Override
    public Intereses buscarIntereses(Long id){
        return interesRepo.findById(id).orElse(null);
    }
    
}
