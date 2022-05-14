package com.portfolio.backend.controller;

import com.portfolio.backend.model.User;
import com.portfolio.backend.model.Usuarios;
import com.portfolio.backend.service.InterCursos;
import com.portfolio.backend.service.InterEstudios;
import com.portfolio.backend.service.InterExperiencias;
import com.portfolio.backend.service.InterIdiomas;
import com.portfolio.backend.service.InterIntereses;
import com.portfolio.backend.service.InterMensajes;
import com.portfolio.backend.service.InterSkills;
import com.portfolio.backend.service.InterUser;
import com.portfolio.backend.service.InterUsuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
    private InterCursos cursoServ;
    
    @Autowired
    private InterEstudios estudioServ;
    
    @Autowired
    private InterExperiencias expServ;
    
    @Autowired
    private InterIdiomas idiomaServ;
    
    @Autowired
    private InterIntereses interesServ;
    
    @Autowired
    private InterMensajes mensServ;
    
    @Autowired
    private InterSkills skillServ;

    @GetMapping("/users")
    @ResponseBody
    public List<Usuarios> verUsuarios() {
        return usuarioServ.verUsuarios();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public Usuarios verUsuarioId(@PathVariable Long id) {
        return usuarioServ.buscarUsuario(id);
    }

    @DeleteMapping("/delete/user/{id}")
    public String borrarUsuario(@PathVariable Long id) {
        String usrtemp = userServ.buscarUser(id).getUsername();

        userServ.borrarUser(id);
        usuarioServ.borrarUsuario(id);
        cursoServ.borrarCursos(id);
        estudioServ.borrarEstudios(id);
        expServ.borrarExp(id);
        idiomaServ.borrarIdiomas(id);
        interesServ.borrarIntereses(id);
        mensServ.borrarMensaje(id);
        skillServ.borrarSkills(id);

        return "El usuario " + usrtemp + " fue eliminado exitosamente.";
    }

    @PutMapping("edit/user/{id}")
    public ResponseEntity<Usuarios> editarUsuario(@PathVariable Long id, @RequestBody Usuarios usuario) {
        Usuarios currentUser = usuarioServ.buscarUsuario(id);
        if (currentUser.getId() == null) {

            System.out.println("El usuario con id " + id + " no se encuentra.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {

            usuarioServ.editarUsuario(id, usuario);
            currentUser = usuarioServ.buscarUsuario(id);
            return new ResponseEntity<>(currentUser, HttpStatus.OK);
        }

//edicion de usuario sacado de 
//https://www.programcreek.com/java-api-examples/?CodeExample=update+user+user+controller
//Author: joedayz
    }

    @PutMapping("editpass/user/{id}")
    public String editarPassUsuario(@PathVariable Long id, @RequestParam String pass) {
        User usr = userServ.buscarUser(id);

        usr.setPassword(pass);

        userServ.editarUser(usr);

        return usr.getUsername() + ", has cambiado tu contraseña exitosamente.";
    }

}
