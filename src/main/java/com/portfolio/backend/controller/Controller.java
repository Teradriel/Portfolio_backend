package com.portfolio.backend.controller;

import com.portfolio.backend.model.Estudios;
import com.portfolio.backend.model.Experiencias;
import com.portfolio.backend.model.Introduccion;
import com.portfolio.backend.model.Mensajes;
import com.portfolio.backend.model.Nivel;
import com.portfolio.backend.model.Skills;
import com.portfolio.backend.model.Usuarios;
import com.portfolio.backend.service.InterEstudios;
import com.portfolio.backend.service.InterExperiencias;
import com.portfolio.backend.service.InterIntroduccion;
import com.portfolio.backend.service.InterMensajes;
import com.portfolio.backend.service.InterNivel;
import com.portfolio.backend.service.InterSkills;
import com.portfolio.backend.service.InterUsuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class Controller {
    
   // private final long USUARIO_ID = 1;
    
    @Autowired
    private InterMensajes mensServ;
    
    @Autowired
    private InterUsuarios usuarioServ;
    
    @Autowired
    private InterEstudios estudioServ;
    
    @Autowired
    private InterExperiencias expServ;
    
    @Autowired
    private InterIntroduccion introServ;
    
    @Autowired
    private InterNivel nivelServ;
    
    @Autowired
    private InterSkills skillServ;
    
    @PostMapping ("/new/message")
    public void agregarMensaje(@RequestBody Mensajes mens){
//        Usuarios usr = new Usuarios();
//        usr.setId(USUARIO_ID);
//        
//        mens.setUsuario(usr);
        mensServ.agregarMensaje(mens);
        
    }
    
    @GetMapping ("/messages")
    @ResponseBody
    public List<Mensajes> verMensajes(){
        return mensServ.verMensajes();
    }
    
    @DeleteMapping("/delete/message/{id}")
    public String borrarMensaje(@PathVariable Long id){
        String nombretemp = mensServ.buscarMensaje(id).getNombre();
        
        mensServ.borrarMensaje(id);
        
        return "El mensaje de " + nombretemp + " se ha eliminado.";
    }
    
    @PostMapping("/new/usr")
    public void editarUsuario(@RequestBody Usuarios usr){
        
        usuarioServ.editarUsuario(usr);
    }
    
    @GetMapping("/users")
    @ResponseBody
    public List<Usuarios> verUsuarios(){
        return usuarioServ.verUsuarios();
    }
    
    @DeleteMapping("/delete/usr/{id}")
    public String borrarUsuario(@PathVariable Long id){
        String usrtemp = usuarioServ.buscarUsuario(id).getUsuario();
        
        usuarioServ.borrarUsuario(id);
        
        return "El usuario "+ usrtemp + " fue eliminado exitosamente.";
    }
    
    @PatchMapping("edit/usr/{id}")
    public String editarUsuario(@PathVariable Long id, @RequestBody Usuarios usr){
        usuarioServ.editarUsuario(usr);
        
        return usr.getNombre()+ ", has actualizado tus datos exitosamente.";
    }
    
    @PutMapping("editpass/usr/{id}")
    public String editarPassUsuario(@PathVariable Long id, @RequestParam String pass){
        Usuarios usr = usuarioServ.buscarUsuario(id);
        
        usr.setPass(pass);
        
        usuarioServ.editarUsuario(usr);
        
        return usr.getUsuario() + ", has cambiado tu contraseña exitosamente.";
    }
    
    @PostMapping("/new/estudio")
    public void agregarEstudio(@RequestBody Estudios estud){
        estudioServ.editarEstudios(estud);
    }
    
    @GetMapping("/estudio")
    @ResponseBody
    public List<Estudios> verEstudios(){
        return estudioServ.verEstudios();
    }
    
    @DeleteMapping("/delete/estudio/{id}")
    public String borrarEstudio(@PathVariable Long id){
        String estudtemp = estudioServ.buscarEstudios(id).getInstitucion();
        
        estudioServ.borrarEstudios(id);
        
        return "El estudio en "+ estudtemp + " fue eliminado exitosamente.";
    }
    
    @PatchMapping("edit/estudio/{id}")
    public String editarEstudios(@PathVariable Long id, @RequestBody Estudios estud){
        estudioServ.editarEstudios(estud);
        
        return "El estudio en " + estud.getInstitucion() + " ha sido actualizado exitosamente.";
    }
    
    @PostMapping("/new/exp")
    public void agregarEstudio(@RequestBody Experiencias exp){
        expServ.editarExp(exp);
    }
    
    @GetMapping("/experiencias")
    @ResponseBody
    public List<Experiencias> verExp(){
        return expServ.verExp();
    }
    
    @DeleteMapping("/delete/exp/{id}")
    public String borrarExp(@PathVariable Long id){
        String exptemp = expServ.buscarExp(id).getEmpresa();
        
        expServ.borrarExp(id);
        
        return "La experiencia en "+ exptemp + " fue eliminada exitosamente.";
    }
    
    @PatchMapping("edit/experiencia/{id}")
    public String editarExp(@PathVariable Long id, @RequestBody Experiencias exp){
        expServ.editarExp(exp);
        
        return "La experiencia en " + exp.getEmpresa()+ " ha sido actualizada exitosamente.";
    }
    
    @PostMapping("/new/introduccion")
    public void agregarIntrod(@RequestBody Introduccion intro){
        introServ.editarIntrod(intro);
    }
    
    @GetMapping("/introduccion")
    @ResponseBody
    public List<Introduccion> verIntrod(){
        return introServ.verIntrod();
    }
    
    @DeleteMapping("/delete/introduccion/{id}")
    public String borrarIntrod(@PathVariable Long id){
        
        introServ.borrarIntrod(id);
        
        return "La introduccion fue eliminada exitosamente.";
    }
    
    @PatchMapping("edit/introduccion/{id}")
    public String editarIntrod(@PathVariable Long id, @RequestBody Introduccion intro){
        introServ.editarIntrod(intro);
        
        return "La introduccion ha sido actualizada exitosamente.";
    }
    
    @PostMapping("/new/nivel")
    public void agregarNivel(@RequestBody Nivel niv){
        nivelServ.editarNivel(niv);
    }
    
    @GetMapping("/niveles")
    @ResponseBody
    public List<Nivel> verNivel(){
        return nivelServ.verNivel();
    }
    
    @PostMapping("/new/skills")
    public void agregarSkills(@RequestBody Skills skill){
        skillServ.editarSkills(skill);
    }
    
    @GetMapping("/skills")
    @ResponseBody
    public List<Skills> verSkills(){
        return skillServ.verSkills();
    }
    
    @DeleteMapping("/delete/skills/{id}")
    public String borrarSkills(@PathVariable Long id){
        String skilltemp = skillServ.buscarSkills(id).getSkill();
        
        estudioServ.borrarEstudios(id);
        
        return "La skill en "+ skilltemp + " fue eliminada exitosamente.";
    }
    
    @PatchMapping("edit/skills/{id}")
    public String editarSkill(@PathVariable Long id, @RequestBody Skills skill){
        skillServ.editarSkills(skill);
        
        return "La habilidad " + skill.getSkill()+ " ha sido actualizada exitosamente.";
    }
    
}
