package com.portfolio.backend.service;

import com.portfolio.backend.model.User;
import com.portfolio.backend.model.Usuarios;
import java.util.List;

public interface InterUsuarios {
    
    public List<Usuarios> verUsuarios();
    
    public void borrarUsuario(Long id);
    
    public void editarUsuario(Long id, Usuarios usr);
    
    public void editarPassUsuario(Usuarios usr);
    
    public Usuarios buscarUsuario(Long id);
    
//    public Usuarios nuevoUsuario(Long id);
    
}
