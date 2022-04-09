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
    
//    @Override
//    public String guardarUsuario(UsuarioDTO usuarioDTO){
//        Usuarios usuario = new Usuarios();
//        usuario.setId(usuarioDTO.getId());
//        usuario.setNombre(usuarioDTO.getNombre());
//        usuario.setApellido(usuarioDTO.getApellido());
//        usuario.setPass(usuarioDTO.getPass());
//        usuario.setTelefono(usuarioDTO.getTelefono());
//        usuario.setUsuario(usuarioDTO.getUsuario());
//        usuario.setMail(usuarioDTO.getMail());
//        usuario.setId_estudios(usuarioDTO.getId_estudios());
//        usuario.setId_experiencias(usuarioDTO.getId_experiencias());
//        usuario.setId_introduccion(usuarioDTO.getId_introduccion());
//        usuario.setId_mensaje(usuarioDTO.getId_mensaje());
//        usuario.setId_skills(usuarioDTO.getId_skills());
//        
//        usrRepo.save(usuario);
//        return "Usuario guardado";
//    }
    
}
