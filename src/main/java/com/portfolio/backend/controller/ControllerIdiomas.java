package com.portfolio.backend.controller;

import com.portfolio.backend.model.Idiomas;
import com.portfolio.backend.model.User;
import com.portfolio.backend.service.InterIdiomas;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/idioma")
public class ControllerIdiomas {
    
    @Autowired
    private InterIdiomas idiomaServ;
    
    @Autowired
    private InterUser userServ;

    @PostMapping("/new/{id}")
    @Transactional
    public String agregarIdioma(@PathVariable Long id, @RequestBody Idiomas idioma) {
        User currentUser = userServ.buscarUser(id);
        currentUser.getIdioma().add(idioma);
        return "El idioma ha sido agregado correctamente";
    }
    
    @PutMapping("/edit/{id}")
    @Transactional
    public String editarIdiomas(@PathVariable Long id, @RequestParam String idioma, @RequestParam String nivel) {
        Idiomas currentIdioma = idiomaServ.buscarIdiomas(id);
        String idiomaNombre = idioma;
        String idiomaNivel = nivel;
        currentIdioma.setIdioma(idiomaNombre);
        currentIdioma.setNivel(idiomaNivel);

        return "El idioma " + idioma + ", ha sido actualizado exitosamente.";
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
    
}
