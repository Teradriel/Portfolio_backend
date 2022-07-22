package com.portfolio.backend.service;

import com.portfolio.backend.model.Idiomas;
import com.portfolio.backend.model.User;
import com.portfolio.backend.repository.IdiomasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdiomasService implements InterIdiomas{
    
    @Autowired
    public IdiomasRepository idiomaRepo;
    
    @Autowired
    private InterUser userServ;
    
    @Override
    public List<Idiomas> verIdiomas(){
        return idiomaRepo.findAll();
    }
        
    @Override
    @Transactional
    public void borrarIdiomas(Long id, Long user_id){
        User currentUser = userServ.buscarUser(user_id);
        Idiomas idioma = idiomaRepo.getById(id);
        currentUser.getIdioma().remove(idioma);
    }
    
    @Override
    public Idiomas buscarIdiomas(Long id){
        return idiomaRepo.findById(id).orElse(null);
    }
}
