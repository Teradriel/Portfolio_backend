package com.portfolio.backend.controller;


import com.portfolio.backend.model.Cursos;
import com.portfolio.backend.service.InterCursos;
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
@RequestMapping("/curso")
public class ControllerCursos {
    
    @Autowired
    private InterCursos cursoServ;
    
    @PostMapping("/new")
    public void agregarIntrod(@RequestBody Cursos curso){
        cursoServ.editarCursos(curso);
    }
    
    @GetMapping("/all")
    @ResponseBody
    public List<Cursos> verIntrod(){
        return cursoServ.verCursos();
    }
    
    @DeleteMapping("/delete/{id}")
    public String borrarCursos(@PathVariable Long id){
        
        cursoServ.borrarCursos(id);
        
        return "El curso fue eliminado exitosamente.";
    }
    
    @PutMapping("/edit/{id}")
    public String editarCursos(@PathVariable Long id, @RequestBody Cursos curso){
        cursoServ.editarCursos(curso);
        
        return "El curso ha sido actualizado exitosamente.";
    }
    
}
