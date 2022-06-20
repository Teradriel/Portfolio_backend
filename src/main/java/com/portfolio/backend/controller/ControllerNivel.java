//package com.portfolio.backend.controller;
//
//import com.portfolio.backend.model.Nivel;
//import com.portfolio.backend.service.InterNivel;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class ControllerNivel {
//    
//    @Autowired
//    private InterNivel nivelServ;
//        
//    @GetMapping("/niveles")
//    @ResponseBody
//    public List<Nivel> verNivel(){
//        return nivelServ.verNivel();
//    }
//    
//}
