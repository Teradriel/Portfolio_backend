package com.portfolio.backend.controller;


import com.portfolio.backend.model.Cursos;
import com.portfolio.backend.service.InterCursos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCursos {
    
    @Autowired
    private InterCursos cursoServ;
    
    @PostMapping("/new/curso")
    public void agregarIntrod(@RequestBody Cursos curso){
        cursoServ.editarCursos(curso);
    }
    
    @GetMapping("/cursos")
    @ResponseBody
    public List<Cursos> verIntrod(){
        return cursoServ.verCursos();
    }
    
    @DeleteMapping("/delete/curso/{id}")
    public String borrarCursos(@PathVariable Long id){
        
        cursoServ.borrarCursos(id);
        
        return "El curso fue eliminado exitosamente.";
    }
    
    @PatchMapping("edit/cursoduccion/{id}")
    public String editarCursos(@PathVariable Long id, @RequestBody Cursos curso){
        cursoServ.editarCursos(curso);
        
        return "El curso ha sido actualizado exitosamente.";
    }
    
}
