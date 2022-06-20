package com.portfolio.backend.controller;

import com.portfolio.backend.model.Cursos;
import com.portfolio.backend.model.User;
import com.portfolio.backend.service.InterCursos;
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
@RequestMapping("/curso")
public class ControllerCursos {
    
    @Autowired
    private InterCursos cursoServ;
    
    @Autowired
    private InterUser userServ;
    
    @PostMapping("/new/{id}")
    @Transactional
    public String agregarCurso(@PathVariable Long id, @RequestBody Cursos curso) {
        User currentUser = userServ.buscarUser(id);
        currentUser.getCurso().add(curso);
        return "El curso ha sido agregado correctamente";
    }
    
    @PutMapping("/edit/{id}")
    @Transactional
    public String editarCursos(@PathVariable Long id, @RequestBody Cursos curso) {
        Cursos currentCurso = cursoServ.buscarCursos(id);
        String cursoTitulo = curso.getTitulo();
        String cursoFecha = curso.getFecha();
        String cursoLugar = curso.getLugar();
        String cursoDescripcion = curso.getDescripcion();
        currentCurso.setTitulo(cursoTitulo);
        currentCurso.setFecha(cursoFecha);
        currentCurso.setLugar(cursoLugar);
        currentCurso.setDescripcion(cursoDescripcion);

        return "El curso " + cursoTitulo + ", ha sido actualizado exitosamente.";
    }
    
    @GetMapping("/all")
    @ResponseBody
    public List<Cursos> verCursos() {
        return cursoServ.verCursos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cursos> buscarCursos(@PathVariable Long id) {
        Cursos curso = this.cursoServ.buscarCursos(id);
        return ResponseEntity.ok(curso);
    }

    @DeleteMapping("/delete/{id}")
    public String borrarCurso(@PathVariable Long id) {
        String cursoTemp = cursoServ.buscarCursos(id).getTitulo();

        cursoServ.borrarCursos(id);

        return "El curso " + cursoTemp + ", fue eliminado exitosamente.";
    }
}
