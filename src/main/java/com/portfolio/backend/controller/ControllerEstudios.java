package com.portfolio.backend.controller;

import com.portfolio.backend.model.Estudios;
import com.portfolio.backend.model.User;
import com.portfolio.backend.service.InterEstudios;
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
@RequestMapping("/estudio")
public class ControllerEstudios {

    @Autowired
    private InterEstudios estudioServ;

    @Autowired
    private InterUser userServ;

    @PostMapping("/new/{id}")
    @Transactional
    public String agregarEstudio(@PathVariable Long id, @RequestBody Estudios estud) {
        User currentUser = userServ.buscarUser(id);
        currentUser.getEstudio().add(estud);
        return "El estudio ha sido agregado correctamente";
    }
    
    @PutMapping("/edit/{id}")
    @Transactional
    public String editarEstudios(@PathVariable Long id, @RequestBody Estudios estud) {
        Estudios currentEstudio = estudioServ.buscarEstudio(id);
        String estudTitulo = estud.getTitulo();
        String estudFechaInicio = estud.getFechaInicio();
        String estudFechaFin = estud.getFechaFin();
        String estudInstitucion = estud.getInstitucion();
        currentEstudio.setTitulo(estudTitulo);
        currentEstudio.setFechaFin(estudFechaFin);
        currentEstudio.setFechaInicio(estudFechaInicio);
        currentEstudio.setInstitucion(estudInstitucion);

        return "El estudio en " + estudInstitucion + ", ha sido actualizado exitosamente.";
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Estudios> verEstudios() {
        return estudioServ.verEstudios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudios> buscarEstudios(@PathVariable Long id) {
        Estudios estudio = this.estudioServ.buscarEstudio(id);
        return ResponseEntity.ok(estudio);
    }

    @DeleteMapping("/delete/{id}")
    public String borrarEstudio(@PathVariable Long id) {
        String estudTemp = estudioServ.buscarEstudio(id).getInstitucion();

        estudioServ.borrarEstudios(id);

        return "El estudio en " + estudTemp + " fue eliminado exitosamente.";
    }

    

}
