package com.portfolio.backend.controller;

import com.portfolio.backend.model.User;
import com.portfolio.backend.model.Usuarios;
import com.portfolio.backend.repository.UserRepository;
import com.portfolio.backend.service.InterUser;
import com.portfolio.backend.service.InterUsuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUsuarios {
    
    @Autowired
    private InterUsuarios usuarioServ;
    
    @Autowired
    private InterUser userServ;
    
    @Autowired
    private UserRepository usrRepo;
        
    @GetMapping("/users")
    @ResponseBody
    public List<Usuarios> verUsuarios(){
        return usuarioServ.verUsuarios();
    }
    
    @GetMapping("/user/info")
    public User getUserDetails(){
        String usuario = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return usrRepo.findByUsername(usuario).get();
    }
    
    @DeleteMapping("/delete/user/{id}")
    public String borrarUsuario(@PathVariable Long id){
        String usrtemp = userServ.buscarUser(id).getUsername();
        
        userServ.borrarUser(id);
        
        return "El usuario "+ usrtemp + " fue eliminado exitosamente.";
    }
    
    @PatchMapping("edit/user/{id}")
    public String editarUsuario(@PathVariable Long id, @RequestBody Usuarios usr){
        usuarioServ.editarUsuario(usr);
        
        return usr.getNombre()+ ", has actualizado tus datos exitosamente.";
    }
    
    @PutMapping("editpass/user/{id}")
    public String editarPassUsuario(@PathVariable Long id, @RequestParam String pass){
        User usr = userServ.buscarUser(id);
        
        usr.setPassword(pass);
        
        userServ.editarUser(usr);
        
        return usr.getUsername() + ", has cambiado tu contraseña exitosamente.";
    }
    
}
