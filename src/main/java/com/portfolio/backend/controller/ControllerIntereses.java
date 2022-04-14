package com.portfolio.backend.controller;

import com.portfolio.backend.model.Intereses;
import com.portfolio.backend.service.InterIntereses;
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
public class ControllerIntereses {
    
    @Autowired
    private InterIntereses interesServ;
    
    @PostMapping("/new/interes")
    public void agregarIntrod(@RequestBody Intereses interes){
        interesServ.editarIntereses(interes);
    }
    
    @GetMapping("/intereses")
    @ResponseBody
    public List<Intereses> verIntereses(){
        return interesServ.verIntereses();
    }
    
    @DeleteMapping("/delete/interes/{id}")
    public String borrarIntereses(@PathVariable Long id){
        
        interesServ.borrarIntereses(id);
        
        return "El interes fue eliminado exitosamente.";
    }
    
    @PatchMapping("edit/interes/{id}")
    public String editarIntereses(@PathVariable Long id, @RequestBody Intereses interes){
        interesServ.editarIntereses(interes);
        
        return "El interes ha sido actualizado exitosamente.";
    }
    
}
