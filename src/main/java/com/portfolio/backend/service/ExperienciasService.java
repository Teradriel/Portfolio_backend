package com.portfolio.backend.service;

import com.portfolio.backend.model.Experiencias;
import com.portfolio.backend.model.User;
import com.portfolio.backend.repository.ExperienciasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExperienciasService implements InterExperiencias{
    
    @Autowired
    public ExperienciasRepository expRepo;
    
    @Autowired
    private InterUser userServ;
    
    @Override
    public List<Experiencias> verExp(){
        return expRepo.findAll();
    }
    
    
    @Override
    @Transactional
    public void borrarExp(Long id, Long user_id){
        User currentUser = userServ.buscarUser(user_id);
        Experiencias exp = expRepo.getById(id);
        currentUser.getExp().remove(exp);
    }
    
    @Override
    public Experiencias buscarExp(Long id){
        return expRepo.findById(id).orElse(null);
    }
}
