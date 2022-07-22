package com.portfolio.backend.service;

import com.portfolio.backend.model.Mensajes;
import com.portfolio.backend.model.User;
import com.portfolio.backend.repository.MensajesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MensajeService implements InterMensajes{
    
    @Autowired
    public MensajesRepository mensRepo;
    
    @Autowired
    private InterUser userServ;
    
    @Override
    public List<Mensajes> verMensajes(){
        return mensRepo.findAll();
    }
    
    @Override
    @Transactional
    public void borrarMensaje(Long id, Long user_id){
        User currentUser = userServ.buscarUser(user_id);
        Mensajes mens = mensRepo.getById(id);
        currentUser.getMens().remove(mens);
    }
    
    @Override
    public Mensajes buscarMensaje(Long id){
        return mensRepo.findById(id).orElse(null);
    }

    @Override
    public void agregarMensaje(Mensajes mens) {
        mensRepo.save(mens);
    }
    
}
