/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.damian.sapi.controladores;

import java.util.List;
import org.damian.sapi.entidades.Facultad;
import org.damian.sapi.servicios.FacultadServicio;
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
@RequestMapping("/facultad")
@CrossOrigin(origins = "*")
public class FacultadControlador {

    @Autowired
    FacultadServicio facSer;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/todas", method = RequestMethod.GET)
    public List<Facultad> obtenerTodasFacultad() {
        return facSer.consultar();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public ResponseEntity<Facultad> crearFacultad(@RequestBody Facultad miObjeto) {
        if (facSer.agregar(miObjeto)) {
            return ResponseEntity.ok(miObjeto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseStatus(code = HttpStatus.OK, reason = "Facultad Eliminada Correctamente")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public void borrarFacultad(@PathVariable Integer id) {
        facSer.eliminar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    public Facultad buscarFacultad(@PathVariable Integer id) {
        return facSer.buscar(id);
    }

    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Facultad Actualizada Correctamente")
    @RequestMapping(value = "/actualizar/{id}", method = RequestMethod.PUT)
    public Boolean actualizarFacultad(@RequestBody Facultad miObjeto) {
        return facSer.actualizar(miObjeto);
    }

}
