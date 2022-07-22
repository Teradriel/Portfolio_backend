package com.portfolio.backend.controller;

import com.portfolio.backend.model.Intereses;
import com.portfolio.backend.model.User;
import com.portfolio.backend.service.InterIntereses;
import com.portfolio.backend.service.InterUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interes")
public class ControllerIntereses {
    
    @Autowired
    private InterIntereses interesServ;
    
    @Autowired
    private InterUser userServ;

    @PostMapping("/new/{id}")
    @Transactional
    public ResponseEntity<User> agregarInteres(@PathVariable Long id, @RequestBody Intereses interes) {
        User currentUser = userServ.buscarUser(id);
        currentUser.getInteres().add(interes);
        currentUser = userServ.buscarUser(id);
        return ResponseEntity.ok(currentUser);
    }
    
    @PutMapping("/edit/{id}")
    @Transactional
    public ResponseEntity<Intereses> editarInteres(@PathVariable Long id, @RequestBody Intereses interes) {
        Intereses currentInteres = interesServ.buscarIntereses(id);
        String inter = interes.getInteres();
        currentInteres.setInteres(inter);

        return ResponseEntity.ok(currentInteres);
    }
    
    @GetMapping("/all")
    @ResponseBody
    public List<Intereses> verIntereses(){
        return interesServ.verIntereses();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Intereses> buscarIntereses(@PathVariable Long id) {
        Intereses interes = interesServ.buscarIntereses(id);
        return ResponseEntity.ok(interes);
    }
    
    @DeleteMapping("/delete/{id}/{user_id}")
    public ResponseEntity<User> borrarIntereses(@PathVariable Long id, @PathVariable Long user_id){
        interesServ.borrarIntereses(id, user_id);
        User currentUser = userServ.buscarUser(user_id);
        return ResponseEntity.ok(currentUser);
    }
}
