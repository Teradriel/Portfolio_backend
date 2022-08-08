package com.portfolio.backend.controller;

import com.portfolio.backend.model.Skills;
import com.portfolio.backend.model.User;
import com.portfolio.backend.service.InterSkills;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "https://portfolio-ap-angular-c5546.web.app")
public class ControllerSkills {
        
    @Autowired
    private InterSkills skillServ;
    
    @Autowired
    private InterUser userServ;

    @PostMapping("/new/{id}")
    @Transactional
    public ResponseEntity<User> agregarSkill(@PathVariable Long id, @RequestBody Skills skill) {
        User currentUser = userServ.buscarUser(id);
        currentUser.getSkill().add(skill);
        currentUser = userServ.buscarUser(id);
        return ResponseEntity.ok(currentUser);
    }
    
    @PutMapping("/edit/{id}")
    @Transactional
    public ResponseEntity<Skills> editarSkills(@PathVariable Long id, @RequestBody Skills skill) {
        Skills currentSkill = skillServ.buscarSkills(id);
        String skillNombre = skill.getSkill();
        int skillNivel = skill.getNivel();
        currentSkill.setSkill(skillNombre);
        currentSkill.setNivel(skillNivel);

        return ResponseEntity.ok(currentSkill);
    }
    
    @GetMapping("/all")
    @ResponseBody
    public List<Skills> verSkills(){
        return skillServ.verSkills();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Skills> buscarEstudios(@PathVariable Long id) {
        Skills skill = skillServ.buscarSkills(id);
        return ResponseEntity.ok(skill);
    }
    
    @DeleteMapping("/delete/{id}/{user_id}")
    public ResponseEntity<User> borrarSkills(@PathVariable Long id, @PathVariable Long user_id){
        skillServ.borrarSkills(id, user_id);
        User currentUser = userServ.buscarUser(user_id);
        return ResponseEntity.ok(currentUser);
    }
}
