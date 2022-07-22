package com.portfolio.backend.service;

import com.portfolio.backend.model.Intereses;
import com.portfolio.backend.model.User;
import com.portfolio.backend.repository.InteresesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InteresesServices implements InterIntereses{
    
    @Autowired
    public InteresesRepository interesRepo;
    
    @Autowired
    private InterUser userServ;
    
    @Override
    public List<Intereses> verIntereses(){
        return interesRepo.findAll();
    }
        
    @Override
    @Transactional
    public void borrarIntereses(Long id, Long user_id){
        User currentUser = userServ.buscarUser(user_id);
        Intereses interes = interesRepo.getById(id);
        currentUser.getInteres().remove(interes);
    }
    
    @Override
    public Intereses buscarIntereses(Long id){
        return interesRepo.findById(id).orElse(null);
    }
    
}
