package com.portfolio.backend.controller;

import com.portfolio.backend.model.Experiencias;
import com.portfolio.backend.model.User;
import com.portfolio.backend.service.InterExperiencias;
import com.portfolio.backend.service.InterUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/exp")
public class ControllerExperiencias {
    
    @Autowired
    private InterExperiencias expServ;
    
    @Autowired
    private InterUser userServ;
    
    @PostMapping("/new/{id}")
    @Transactional
    public String agregarExp(@PathVariable Long id, @RequestBody Experiencias exp) {
        User currentUser = userServ.buscarUser(id);
        currentUser.getExp().add(exp);
        return "La experiencia laboral ha sido agregada correctamente";
    }
    
    @PutMapping("/edit/{id}")
    @Transactional
    public String editarExp(@PathVariable Long id, @RequestBody Experiencias exp) {
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

        return "La experiencia laboral en " + expEmpresa + ", ha sido actualizado exitosamente.";
    }
    
    @GetMapping("/all")
    @ResponseBody
    public List<Experiencias> verExp(){
        return expServ.verExp();
    }
    
    @DeleteMapping("/delete/{id}")
    public String borrarExp(@PathVariable Long id){
        String exptemp = expServ.buscarExp(id).getEmpresa();
        
        expServ.borrarExp(id);
        
        return "La experiencia en " + exptemp + " fue eliminada exitosamente.";
    }
}
