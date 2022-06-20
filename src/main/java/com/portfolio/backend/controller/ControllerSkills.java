package com.portfolio.backend.controller;

import com.portfolio.backend.model.Skills;
import com.portfolio.backend.model.User;
import com.portfolio.backend.service.InterSkills;
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
@RequestMapping("/skill")
public class ControllerSkills {
        
    @Autowired
    private InterSkills skillServ;
    
    @Autowired
    private InterUser userServ;

    @PostMapping("/new/{id}")
    @Transactional
    public String agregarSkill(@PathVariable Long id, @RequestBody Skills skill) {
        User currentUser = userServ.buscarUser(id);
        currentUser.getSkill().add(skill);
        return "El habilidad ha sido agregado correctamente";
    }
    
    @PutMapping("/edit/{id}")
    @Transactional
    public String editarSkills(@PathVariable Long id, @RequestBody Skills skill) {
        Skills currentSkill = skillServ.buscarSkills(id);
        String skillNombre = skill.getSkill();
        int skillNivel = skill.getNivel();
        currentSkill.setSkill(skillNombre);
        currentSkill.setNivel(skillNivel);

        return "El habilidad " + skillNombre + ", ha sido actualizado exitosamente.";
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
}
