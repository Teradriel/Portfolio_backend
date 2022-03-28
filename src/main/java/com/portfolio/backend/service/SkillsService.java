package com.portfolio.backend.service;

import com.portfolio.backend.model.Skills;
import com.portfolio.backend.repository.SkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsService implements InterSkills{
    @Autowired
    public SkillsRepository skillRepo;
    
    @Override
    public List<Skills> verSkills(){
        return skillRepo.findAll();
    }
    
    @Override
    public void editarSkills(Skills skill){
        skillRepo.save(skill);
    }
    
    @Override
    public void borrarSkills(Long id){
        skillRepo.deleteById(id);
    }
    
    @Override
    public Skills buscarSkills(Long id){
        return skillRepo.findById(id).orElse(null);
    }

}
