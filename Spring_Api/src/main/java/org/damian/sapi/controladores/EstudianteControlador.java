/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.damian.sapi.controladores;

import java.util.List;
import java.util.Map;
import org.damian.sapi.entidades.Estudiante;
import org.damian.sapi.entidades.Estudiante;
import org.damian.sapi.servicios.EstudianteServicio;
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
@RequestMapping("/estudiante")
@CrossOrigin(origins = "*")
public class EstudianteControlador {
    @Autowired
    EstudianteServicio estSer;
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public List<Estudiante> obtenerTodasEstudiante(){
        return estSer.consultar();
    }
    
        @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante miObjeto) {
        if (estSer.agregar(miObjeto)) {
            return ResponseEntity.ok(miObjeto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseStatus(code = HttpStatus.OK, reason = "Estudiante Eliminado Correctamente")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public void borrarEstudiante(@PathVariable Integer id) {
        estSer.eliminar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    public Estudiante buscarEstudiante(@PathVariable Integer id) {
        return estSer.buscar(id);
    }

    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Estudiante Actualizado Correctamente")
    @RequestMapping(value = "/actualizar/{id}", method = RequestMethod.PUT)
    public Boolean actualizarEstudiante(@RequestBody Estudiante miObjeto) {
        return estSer.actualizar(miObjeto);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/programa", method = RequestMethod.GET)
    public List<Map<String, Object>> obtenerProgramaEstudiante() {
        return estSer.listadop();
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/facultad", method = RequestMethod.GET)
    public List<Map<String, Object>> obtenerFacultadEstudiante() {
        return estSer.listadof();
    }
}
