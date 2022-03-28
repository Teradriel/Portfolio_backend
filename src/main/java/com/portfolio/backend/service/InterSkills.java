package com.portfolio.backend.service;

import com.portfolio.backend.model.Skills;
import java.util.List;

public interface InterSkills {
    
    public List<Skills> verSkills();
    
    public void borrarSkills(Long id);
    
    public void editarSkills(Skills skill);
    
    public Skills buscarSkills(Long id);
    
}
