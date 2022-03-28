package com.portfolio.backend.service;

import com.portfolio.backend.model.Mensajes;
import java.util.List;

public interface InterMensajes {
    
    public List<Mensajes> verMensajes();
    
    public void borrarMensaje(Long id);
    
    public void agregarMensaje(Mensajes mens);
    
    public Mensajes buscarMensaje(Long id);
    
}
