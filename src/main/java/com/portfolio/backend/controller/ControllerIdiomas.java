package com.portfolio.backend.controller;

import com.portfolio.backend.model.Idiomas;
import com.portfolio.backend.model.User;
import com.portfolio.backend.service.InterIdiomas;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/idioma")
@CrossOrigin
public class ControllerIdiomas {
    
    @Autowired
    private InterIdiomas idiomaServ;
    
    @Autowired
    private InterUser userServ;

    @PostMapping("/new/{id}")
    @Transactional
    public ResponseEntity<User> agregarIdioma(@PathVariable Long id, @RequestBody Idiomas idioma) {
        User currentUser = userServ.buscarUser(id);
        currentUser.getIdioma().add(idioma);
        return ResponseEntity.ok(currentUser);
    }
    
    @PutMapping("/edit/{id}")
    @Transactional
    public ResponseEntity<Idiomas> editarIdiomas(@PathVariable Long id, @RequestParam String idioma, @RequestParam String nivel) {
        Idiomas currentIdioma = idiomaServ.buscarIdiomas(id);
        String idiomaNombre = idioma;
        String idiomaNivel = nivel;
        currentIdioma.setIdioma(idiomaNombre);
        currentIdioma.setNivel(idiomaNivel);

        return ResponseEntity.ok(currentIdioma);
    }
    
    @GetMapping("/all")
    @ResponseBody
    public List<Idiomas> verIntrod(){
        return idiomaServ.verIdiomas();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Idiomas> buscarIdiomas(@PathVariable Long id) {
        Idiomas idioma = idiomaServ.buscarIdiomas(id);
        return ResponseEntity.ok(idioma);
    }
    
    @DeleteMapping("/delete/{id}/{user_id}")
    public ResponseEntity<User> borrarIdiomas(@PathVariable Long id, @PathVariable Long user_id){
        idiomaServ.borrarIdiomas(id, user_id);
        User currentUser = userServ.buscarUser(user_id);
        return ResponseEntity.ok(currentUser);
    }
    
}
