package com.portfolio.backend.controller;

import com.portfolio.backend.model.Intereses;
import com.portfolio.backend.model.User;
import com.portfolio.backend.service.InterIntereses;
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
@RequestMapping("/interes")
public class ControllerIntereses {
    
    @Autowired
    private InterIntereses interesServ;
    
    @Autowired
    private InterUser userServ;

    @PostMapping("/new/{id}")
    @Transactional
    public String agregarInteres(@PathVariable Long id, @RequestBody Intereses interes) {
        User currentUser = userServ.buscarUser(id);
        currentUser.getInteres().add(interes);
        return "El hobby ha sido agregado correctamente";
    }
    
    @PutMapping("/edit/{id}")
    @Transactional
    public String editarInteres(@PathVariable Long id, @RequestBody Intereses interes) {
        Intereses currentInteres = interesServ.buscarIntereses(id);
        String inter = interes.getInteres();
        currentInteres.setInteres(inter);

        return "El hobby " + inter + ", ha sido actualizado exitosamente.";
    }
    
    @GetMapping("/all")
    @ResponseBody
    public List<Intereses> verIntereses(){
        return interesServ.verIntereses();
    }
    
    @DeleteMapping("/delete/{id}")
    public String borrarIntereses(@PathVariable Long id){
        
        interesServ.borrarIntereses(id);
        
        return "El interes fue eliminado exitosamente.";
    }
}
