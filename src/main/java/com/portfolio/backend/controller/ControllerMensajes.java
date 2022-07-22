package com.portfolio.backend.controller;

import com.portfolio.backend.model.Mensajes;
import com.portfolio.backend.model.User;
import com.portfolio.backend.service.InterMensajes;
import com.portfolio.backend.service.InterUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<Mensajes> agregarMensaje(@RequestBody Mensajes mens){
        mensServ.agregarMensaje(mens);
        Mensajes currentMens = mens;
        return ResponseEntity.ok(currentMens);
    }
    
    @PostMapping ("/new/{id}")
    @Transactional
    public ResponseEntity<User> agregarMensajeUser(@PathVariable Long id, @RequestBody Mensajes mens){
        User currentUser = userServ.buscarUser(id);
        currentUser.getMens().add(mens);
        currentUser = userServ.buscarUser(id);
        return ResponseEntity.ok(currentUser);
    }
    
    @GetMapping ("/all")
    @ResponseBody
    public List<Mensajes> verMensajes(){
        return mensServ.verMensajes();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Mensajes> buscarEstudios(@PathVariable Long id) {
        Mensajes mens = mensServ.buscarMensaje(id);
        return ResponseEntity.ok(mens);
    }
    
    @DeleteMapping("/delete/{id}/{user_id}")
    public ResponseEntity<User> borrarMensaje(@PathVariable Long id, @PathVariable Long user_id){
        mensServ.borrarMensaje(id, user_id);
        User currentUser = userServ.buscarUser(user_id);
        return ResponseEntity.ok(currentUser);        
    }
    
}
