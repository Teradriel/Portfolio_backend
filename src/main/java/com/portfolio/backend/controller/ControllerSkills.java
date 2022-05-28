package com.portfolio.backend.controller;

import com.portfolio.backend.model.Skills;
import com.portfolio.backend.service.InterSkills;
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
@RequestMapping("/skill")
public class ControllerSkills {
        
    @Autowired
    private InterSkills skillServ;
    
    @PostMapping("/new")
    public void agregarSkills(@RequestBody Skills skill){
        skillServ.editarSkills(skill);
    }
    
    @GetMapping("/all")
    @ResponseBody
    public List<Skills> verSkills(){
        return skillServ.verSkills();
    }
    
    @DeleteMapping("/delete/{id}")
    public String borrarSkills(@PathVariable Long id){
        String skilltemp = skillServ.buscarSkills(id).getSkill();
        
        skillServ.borrarSkills(id);
        
        return "La skill en "+ skilltemp + " fue eliminada exitosamente.";
    }
    
    @PutMapping("/edit/{id}")
    public String editarSkill(@PathVariable Long id, @RequestBody Skills skill){
        skillServ.editarSkills(skill);
        
        return "La habilidad " + skill.getSkill()+ " ha sido actualizada exitosamente.";
    }
    
}
