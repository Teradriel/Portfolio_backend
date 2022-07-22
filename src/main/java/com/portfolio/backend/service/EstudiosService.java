package com.portfolio.backend.service;

import com.portfolio.backend.model.Estudios;
import com.portfolio.backend.model.User;
import com.portfolio.backend.repository.EstudiosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstudiosService implements InterEstudios{
    
    @Autowired
    public EstudiosRepository estudioRepo;
    
    @Autowired
    private InterUser userServ;
    
    @Override
    public List<Estudios> verEstudios(){
        return estudioRepo.findAll();
    }
    
    @Override
    @Transactional
    public void borrarEstudios(Long id, Long user_id){
        User currentUser = userServ.buscarUser(user_id);
        Estudios estud = estudioRepo.getById(id);
        currentUser.getEstudio().remove(estud);
    }
    
    @Override
    public Estudios buscarEstudio(Long id){
        return estudioRepo.findById(id).orElse(null);
    }
    
}
