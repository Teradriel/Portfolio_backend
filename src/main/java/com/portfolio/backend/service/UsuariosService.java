package com.portfolio.backend.service;

import com.portfolio.backend.model.Usuarios;
import com.portfolio.backend.repository.UsuariosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService implements InterUsuarios{
    
    @Autowired
    public UsuariosRepository usrRepo;
    
    @Override
    public List<Usuarios> verUsuarios(){
        return usrRepo.findAll();
    }
    
    @Override
    public void editarUsuario(Usuarios usr){
        usrRepo.save(usr);
    }
    
    @Override
    public void editarPassUsuario(Usuarios usr){
        usrRepo.save(usr);
    }
    
    @Override
    public void borrarUsuario(Long id){
        usrRepo.deleteById(id);
    }
    
    @Override
    public Usuarios buscarUsuario(Long id){
        return usrRepo.findById(id).orElse(null);
    }
    
}
