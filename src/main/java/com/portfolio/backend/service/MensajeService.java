package com.portfolio.backend.service;

import com.portfolio.backend.model.Mensajes;
import com.portfolio.backend.repository.MensajesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensajeService implements InterMensajes{
    
    @Autowired
    public MensajesRepository mensRepo;
    
    @Override
    public List<Mensajes> verMensajes(){
        return mensRepo.findAll();
    }
    
    @Override
    public void borrarMensaje(Long id){
        mensRepo.deleteById(id);
    }
    
    @Override
    public Mensajes buscarMensaje(Long id){
        return mensRepo.findById(id).orElse(null);
    }

    @Override
    public void editarMensaje(Mensajes mens) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
