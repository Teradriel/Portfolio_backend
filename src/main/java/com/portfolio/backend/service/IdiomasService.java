package com.portfolio.backend.service;

import com.portfolio.backend.model.Idiomas;
import com.portfolio.backend.repository.IdiomasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdiomasService implements InterIdiomas{
    
    @Autowired
    public IdiomasRepository idiomaRepo;
    
    @Override
    public List<Idiomas> verIdiomas(){
        return idiomaRepo.findAll();
    }
    
    @Override
    public void editarIdiomas(Idiomas estud){
        idiomaRepo.save(estud);
    }
    
    @Override
    public void borrarIdiomas(Long id){
        idiomaRepo.deleteById(id);
    }
    
    @Override
    public Idiomas buscarIdiomas(Long id){
        return idiomaRepo.findById(id).orElse(null);
    }
    
}
