/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.damian.sapi.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.Tuple;
import org.damian.sapi.entidades.Programa;
import org.damian.sapi.interfaces.Operaciones;
import org.damian.sapi.repositorios.ProgramaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Damian Martinez
 */
@Service
public class ProgramaServicio implements Operaciones<Programa> {

    @Autowired
    ProgramaRepositorio progRep;

    @Override
    public List<Programa> consultar() {
        return progRep.obtenerTodos();
    }

    @Override
    public Boolean agregar(Programa miObjeto) {
        Programa prog = progRep.save(miObjeto);
        return prog != null;
    }

    @Override
    public Integer catidadRegistros() {
        return 0;
    }

    @Override
    public Boolean eliminar(Integer id) {
        progRep.deleteById(id);
        return !progRep.existsById(id);
    }

    @Override
    public Boolean actualizar(Programa miObjeto) {
        Optional<Programa> objTemporal = progRep.findById(miObjeto.getId());
        if (objTemporal.isPresent()) {
            progRep.save(miObjeto);
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Implementado Incorrectamente");
        }

    }

    @Override
    public Programa buscar(Integer miLlavePrimaria) {
        return progRep.findById(miLlavePrimaria).get();
    }
    
    public List<Map<String, Object>> listado() {
        List<Tuple> tuples = progRep.listadoProgramas();
        List<Map<String, Object>> result = new ArrayList<>();
        for (Tuple tuple : tuples) {
            Map<String, Object> map = new HashMap<>();
            map.put("Programa", tuple.get(0, String.class));
            map.put("Facultad", tuple.get(1, String.class));
            result.add(map);
        }
        return result;
    }

}
