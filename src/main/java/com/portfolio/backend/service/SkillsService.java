package com.portfolio.backend.service;

import com.portfolio.backend.model.Skills;
import com.portfolio.backend.model.User;
import com.portfolio.backend.repository.SkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SkillsService implements InterSkills{
    @Autowired
    public SkillsRepository skillRepo;
        
    @Autowired
    private InterUser userServ;
    
    @Override
    public List<Skills> verSkills(){
        return skillRepo.findAll();
    }
        
    @Override
    @Transactional
    public void borrarSkills(Long id, Long user_id){
        User currentUser = userServ.buscarUser(user_id);
        Skills skill = skillRepo.getById(id);
        currentUser.getSkill().remove(skill);
    }
    
    @Override
    public Skills buscarSkills(Long id){
        return skillRepo.findById(id).orElse(null);
    }

}
