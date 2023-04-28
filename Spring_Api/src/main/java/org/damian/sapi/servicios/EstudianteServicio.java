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
import org.damian.sapi.entidades.Estudiante;
import org.damian.sapi.interfaces.Operaciones;
import org.damian.sapi.repositorios.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Damian Martinez
 */
@Service
public class EstudianteServicio implements Operaciones<Estudiante> {

    @Autowired
    EstudianteRepositorio estRep;

    @Override
    public List<Estudiante> consultar() {
        return estRep.obtenerTodos();
    }

    @Override
    public Boolean agregar(Estudiante miObjeto) {
        Estudiante est = estRep.save(miObjeto);
        return est != null;
    }

    @Override
    public Integer catidadRegistros() {
        return 0;
    }

    @Override
    public Boolean eliminar(Integer id) {
        estRep.deleteById(id);
        return !estRep.existsById(id);
    }

    @Override
    public Boolean actualizar(Estudiante miObjeto) {
        Optional<Estudiante> objTemporal = estRep.findById(miObjeto.getId());
        if (objTemporal.isPresent()) {
            estRep.save(miObjeto);
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Implementado Incorrectamente");
        }
    }

    @Override
    public Estudiante buscar(Integer miLlavePrimaria) {
        return estRep.findById(miLlavePrimaria).get();
    }
    
    public List<Map<String, Object>> listadop() {
        List<Tuple> tuples = estRep.listadoProgramas();
        List<Map<String, Object>> result = new ArrayList<>();
        for (Tuple tuple : tuples) {
            Map<String, Object> map = new HashMap<>();
            map.put("Estudiante", tuple.get(0, String.class));
            map.put("Programa", tuple.get(1, String.class));
            result.add(map);
        }
        return result;
    }
    public List<Map<String, Object>> listadof() {
        List<Tuple> tuples = estRep.listadoFacultad();
        List<Map<String, Object>> result = new ArrayList<>();
        for (Tuple tuple : tuples) {
            Map<String, Object> map = new HashMap<>();
            map.put("Estudiante", tuple.get(0, String.class));
            map.put("Facultad", tuple.get(1, String.class));
            result.add(map);
        }
        return result;
    }

}
