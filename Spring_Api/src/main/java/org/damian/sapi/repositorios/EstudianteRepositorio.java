/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.damian.sapi.repositorios;

import java.util.List;
import javax.persistence.Tuple;
import org.damian.sapi.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Damian Martinez
 */
@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer> {

    @Query("SELECT E FROM Estudiante E")
    public List<Estudiante> obtenerTodos();

    @Query("SELECT  e.nombre as Nombre, e.programaId.nombre as Programa FROM Estudiante e")
    List<Tuple> listadoProgramas();
    
    @Query("SELECT  e.nombre as Nombre, e.programaId.facultadId.nombre as Programa FROM Estudiante e")
    List<Tuple> listadoFacultad();
}
