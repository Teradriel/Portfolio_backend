package com.portfolio.backend.controller;

import com.portfolio.backend.model.User;
import com.portfolio.backend.service.InterUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ControllerUsuarios {

    @Autowired
    private InterUser userServ;

    @GetMapping("/all")
    @ResponseBody
    public List<User> verUser() {
        return userServ.verUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User userData = this.userServ.buscarUser(id);
        return ResponseEntity.ok(userData);
    }

    @DeleteMapping("/delete/{id}")
    public String borrarUsuario(@PathVariable Long id) {
        String usrtemp = userServ.buscarUser(id).getUsername();

        userServ.borrarUser(id);

        return "El usuario " + usrtemp + " fue eliminado exitosamente.";
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> editarUser(@PathVariable Long id, @RequestBody User user) {
        User currentUser = userServ.buscarUser(id);
        if (currentUser.getId() == null) {
            System.out.println("El usuario con id " + id + " no se encuentra.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            userServ.editarUser(user);
            currentUser = userServ.buscarUser(id);
            return ResponseEntity.ok(currentUser);
        }

    }

    @PutMapping("/editpass/{id}")
    public String editarPassUsuario(@PathVariable Long id, @RequestParam String pass) {
        User usr = userServ.buscarUser(id);

        usr.setPassword(pass);

        userServ.editarUser(usr);

        return usr.getUsername() + ", has cambiado tu contraseña exitosamente.";
    }

}
