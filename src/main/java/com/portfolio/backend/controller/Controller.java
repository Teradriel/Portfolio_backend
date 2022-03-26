package com.portfolio.backend.controller;

import com.portfolio.backend.model.Mensajes;
import com.portfolio.backend.model.Usuarios;
import com.portfolio.backend.service.InterMensajes;
import com.portfolio.backend.service.InterUsuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @Autowired
    private InterMensajes mensServ;
    
    @Autowired
    private InterUsuarios usuarioServ;
    
    @PostMapping ("/new/message")
    public void agregarMensaje(@RequestBody Mensajes mens){
        mensServ.editarMensaje(mens);
    }
    
    @GetMapping ("/messages")
    @ResponseBody
    public List<Mensajes> verMensajes(){
        return mensServ.verMensajes();
    }
    
    @DeleteMapping("/delete/message/{id}")
    public String borrarMensaje(@PathVariable Long id){
        mensServ.borrarMensaje(id);
        return "El mensaje de " + mensServ.buscarMensaje(id).getNombre() + " se ha eliminado.";
    }
    
    @PostMapping("/new/usr")
    public void agregarUsuario(@RequestBody Usuarios usr){
        usuarioServ.editarUsuario(usr);
    }
    
    @GetMapping("/users")
    @ResponseBody
    public List<Usuarios> verUsuarios(){
        return usuarioServ.verUsuarios();
    }
    
    @DeleteMapping("/delete/usr/{id}")
    public String borrarUsuario(@PathVariable Long id){
        usuarioServ.borrarUsuario(id);
        return "El usuario "+usuarioServ.buscarUsuario(id).getUsuario() + " fue eliminado exitosamente.";
    }
    
    @PutMapping("edit/usr/{id}")
    public String editarUsuario(@PathVariable Long id, @RequestParam String pass){
        Usuarios usr = usuarioServ.buscarUsuario(id);
        
        usr.setPass(pass);
        
        usuarioServ.editarUsuario(usr);
        
        return usr.getUsuario() + ", has cambiado su contraseña exitosamente.";
    }
            
}
