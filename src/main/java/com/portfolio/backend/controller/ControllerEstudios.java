package com.portfolio.backend.controller;

import com.portfolio.backend.model.Estudios;
import com.portfolio.backend.service.InterEstudios;
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
@RequestMapping("/estudio")
public class ControllerEstudios {
    
    @Autowired
    private InterEstudios estudioServ;
    
    @PostMapping("/new")
    public void agregarEstudio(@RequestBody Estudios estud){
        estudioServ.editarEstudios(estud);
    }
    
    @GetMapping("/all")
    @ResponseBody
    public List<Estudios> verEstudios(){
        return estudioServ.verEstudios();
    }
    
    @DeleteMapping("/delete/{id}")
    public String borrarEstudio(@PathVariable Long id){
        String estudtemp = estudioServ.buscarEstudios(id).getInstitucion();
        
        estudioServ.borrarEstudios(id);
        
        return "El estudio en "+ estudtemp + " fue eliminado exitosamente.";
    }
    
    @PutMapping("/edit/{id}")
    public String editarEstudios(@PathVariable Long id, @RequestBody Estudios estud){
        estudioServ.editarEstudios(estud);
        
        return "El estudio en " + estud.getInstitucion() + " ha sido actualizado exitosamente.";
    }
    
}
