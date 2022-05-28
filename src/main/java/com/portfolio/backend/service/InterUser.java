package com.portfolio.backend.service;

import com.portfolio.backend.model.User;
import java.util.List;

public interface InterUser {
    
    public List<User> verUser();
    
    public void borrarUser(Long id);
    
    public void editarUser(User user);
    
    public User buscarUser(Long id);
    
}