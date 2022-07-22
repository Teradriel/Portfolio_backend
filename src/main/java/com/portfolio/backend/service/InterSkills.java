package com.portfolio.backend.service;

import com.portfolio.backend.model.Skills;
import java.util.List;

public interface InterSkills {
    
    public List<Skills> verSkills();
    
    public void borrarSkills(Long id, Long user_id);
    
    public Skills buscarSkills(Long id);
    
}
