package com.portfolio.backend.service;

import com.portfolio.backend.model.User;
import com.portfolio.backend.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements InterUser {

    @Autowired
    public UserRepository userRepo;

    @Override
    public List<User> verUser() {
        return userRepo.findAll();
    }

    @Override
    public void editarUser(User user) {
        userRepo.save(user);
    }

    @Override
    @Transactional
    public void borrarUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User buscarUser(Long id) {
        return userRepo.findById(id).orElse(null);
    }

}
