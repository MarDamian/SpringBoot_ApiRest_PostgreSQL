/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.damian.sapi.controladores;

import java.util.List;
import java.util.Map;
import org.damian.sapi.entidades.Programa;
import org.damian.sapi.servicios.ProgramaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Damian Martinez
 */
@RestController
@RequestMapping("/programa")
@CrossOrigin(origins = "*")
public class ProgramaControlador {
    
    @Autowired
    ProgramaServicio progSer;
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public List<Programa> obtenerTodosPrograma(){
        return progSer.consultar();
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public ResponseEntity<Programa> crearPrograma(@RequestBody Programa miObjeto) {
        if (progSer.agregar(miObjeto)) {
            return ResponseEntity.ok(miObjeto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseStatus(code = HttpStatus.OK, reason = "Programa Eliminado Correctamente")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public void borrarPrograma(@PathVariable Integer id) {
        progSer.eliminar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    public Programa buscarPrograma(@PathVariable Integer id) {
        return progSer.buscar(id);
    }

    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Programa Actualizado Correctamente")
    @RequestMapping(value = "/actualizar/{id}", method = RequestMethod.PUT)
    public Boolean actualizarPrograma(@RequestBody Programa miObjeto) {
        return progSer.actualizar(miObjeto);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/facultad", method = RequestMethod.GET)
    public List<Map<String, Object>> obtenerFacultadEstudiante() {
        return progSer.listado();
    }
}
