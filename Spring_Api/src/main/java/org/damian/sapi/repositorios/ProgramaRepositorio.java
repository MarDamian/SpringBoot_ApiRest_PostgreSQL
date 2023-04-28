/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.damian.sapi.repositorios;

import java.util.List;
import javax.persistence.Tuple;
import org.damian.sapi.entidades.Programa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Damian Martinez
 */
@Repository
public interface ProgramaRepositorio extends JpaRepository<Programa,Integer>{
    @Query("SELECT E FROM Programa E")
    public List<Programa> obtenerTodos();
    
    @Query("SELECT  p.nombre as Nombre, p.facultadId.nombre as Facultad FROM Programa p")
    List<Tuple> listadoProgramas();
}
