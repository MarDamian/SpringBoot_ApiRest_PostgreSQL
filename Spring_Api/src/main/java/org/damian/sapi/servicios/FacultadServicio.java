/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.damian.sapi.servicios;

import java.util.List;
import java.util.Optional;
import org.damian.sapi.entidades.Facultad;
import org.damian.sapi.interfaces.Operaciones;
import org.damian.sapi.repositorios.FacultadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Damian Martinez
 */
@Service
public class FacultadServicio implements Operaciones<Facultad>{

    @Autowired
    FacultadRepositorio facRep;
    
    @Override
    public List<Facultad> consultar() {
        return facRep.obtenerTodas();
    }

    @Override
    public Boolean agregar(Facultad miObjeto) {
        Facultad faculob = facRep.save(miObjeto);
        return faculob != null;
    }

    @Override
    public Integer catidadRegistros() {
        return 0;
    }

    @Override
    public Boolean eliminar(Integer id) {
        facRep.deleteById(id);
        return !facRep.existsById(id);
    }

    @Override
    public Boolean actualizar(Facultad miObjeto) {
         Optional<Facultad> objTemporal = facRep.findById(miObjeto.getId());
        if (objTemporal.isPresent()) {
            facRep.save(miObjeto);
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Implementado Incorrectamente");
        }    
    }

    @Override
    public Facultad buscar(Integer miLlavePrimaria) {
        return facRep.findById(miLlavePrimaria).get(); 
    }
}
