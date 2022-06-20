package com.portfolio.backend.controller;

import com.portfolio.backend.model.Mensajes;
import com.portfolio.backend.model.User;
import com.portfolio.backend.service.InterMensajes;
import com.portfolio.backend.service.InterUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensaje")
public class ControllerMensajes {
    
    @Autowired
    private InterMensajes mensServ;
    
    @Autowired
    private InterUser userServ;
    
    @PostMapping ("/new")
    public String agregarMensaje(@RequestBody Mensajes mens){
        mensServ.agregarMensaje(mens);
        return "El estudio ha sido agregado correctamente";
    }
    
    @PostMapping ("/new/{id}")
    public String agregarMensajeUser(@RequestParam Long id, @RequestBody Mensajes mens){
        User currentUser = userServ.buscarUser(id);
        currentUser.getMens().add(mens);
        return "El estudio ha sido agregado correctamente";
    }
    
    @GetMapping ("/all")
    @ResponseBody
    public List<Mensajes> verMensajes(){
        return mensServ.verMensajes();
    }
    
    @DeleteMapping("/delete/{id}")
    public String borrarMensaje(@PathVariable Long id){
        String nombretemp = mensServ.buscarMensaje(id).getNombre();
        
        mensServ.borrarMensaje(id);
        
        return "El mensaje de " + nombretemp + " se ha eliminado.";
    }
    
}
