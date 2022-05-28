package com.portfolio.backend.controller;

import com.portfolio.backend.model.Idiomas;
import com.portfolio.backend.service.InterIdiomas;
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
@RequestMapping("/idioma")
public class ControllerIdiomas {
    
    @Autowired
    private InterIdiomas idiomaServ;
    
    @PostMapping("/new")
    public void agregarIdiomas(@RequestBody Idiomas idioma){
        idiomaServ.editarIdiomas(idioma);
    }
    
    @GetMapping("/all")
    @ResponseBody
    public List<Idiomas> verIntrod(){
        return idiomaServ.verIdiomas();
    }
    
    @DeleteMapping("/delete/{id}")
    public String borrarIdiomas(@PathVariable Long id){
        
        idiomaServ.borrarIdiomas(id);
        
        return "El idioma fue eliminado exitosamente.";
    }
    
    @PutMapping("/edit/{id}")
    public String editarIdiomas(@PathVariable Long id, @RequestBody Idiomas idioma){
        idiomaServ.editarIdiomas(idioma);
        
        return "El idioma ha sido actualizado exitosamente.";
    }
    
}
