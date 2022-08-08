package com.portfolio.backend.controller;

import com.portfolio.backend.model.Experiencias;
import com.portfolio.backend.model.User;
import com.portfolio.backend.service.InterExperiencias;
import com.portfolio.backend.service.InterUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/exp")
@CrossOrigin(origins = "https://portfolio-ap-angular-c5546.web.app")
public class ControllerExperiencias {
    
    @Autowired
    private InterExperiencias expServ;
    
    @Autowired
    private InterUser userServ;
    
    @PostMapping("/new/{id}")
    @Transactional
    public ResponseEntity<User> agregarExp(@PathVariable Long id, @RequestBody Experiencias exp) {
        User currentUser = userServ.buscarUser(id);
        currentUser.getExp().add(exp);
        currentUser = userServ.buscarUser(id);
        return ResponseEntity.ok(currentUser);
    }
    
    @PutMapping("/edit/{id}")
    @Transactional
    public ResponseEntity<Experiencias> editarExp(@PathVariable Long id, @RequestBody Experiencias exp) {
        Experiencias currentExp = expServ.buscarExp(id);
        String expTitulo = exp.getTitulo();
        String expFechaInicio = exp.getFechaInicio();
        String expFechaFin = exp.getFechaFin();
        String expEmpresa = exp.getEmpresa();
        String expDescr = exp.getDescripcion();
        currentExp.setTitulo(expTitulo);
        currentExp.setFechaFin(expFechaFin);
        currentExp.setFechaInicio(expFechaInicio);
        currentExp.setEmpresa(expEmpresa);
        currentExp.setDescripcion(expDescr);

        return ResponseEntity.ok(currentExp);
    }
    
    @GetMapping("/all")
    @ResponseBody
    public List<Experiencias> verExp(){
        return expServ.verExp();
    }

@GetMapping("/{id}")
    public ResponseEntity<Experiencias> buscarEstudios(@PathVariable Long id) {
        Experiencias exp = expServ.buscarExp(id);
        return ResponseEntity.ok(exp);
    }
    
    @DeleteMapping("/delete/{id}/{user_id}")
    public ResponseEntity<User> borrarExp(@PathVariable Long id, @PathVariable Long user_id){
        expServ.borrarExp(id, user_id);
        User currentUser = userServ.buscarUser(user_id);
        return ResponseEntity.ok(currentUser);
    }
}
