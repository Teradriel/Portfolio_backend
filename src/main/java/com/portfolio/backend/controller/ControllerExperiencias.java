package com.portfolio.backend.controller;

import com.portfolio.backend.model.Experiencias;
import com.portfolio.backend.service.InterExperiencias;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @PostMapping("/new")
    public void agregarEstudio(@RequestBody Experiencias exp){
        expServ.editarExp(exp);
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
        
        return "La experiencia en "+ exptemp + " fue eliminada exitosamente.";
    }
    
    @PutMapping("/edit/{id}")
    public String editarExp(@PathVariable Long id, @RequestBody Experiencias exp){
        expServ.editarExp(exp);
        
        return "La experiencia en " + exp.getEmpresa()+ " ha sido actualizada exitosamente.";
    }
    
}
