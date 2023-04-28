/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.damian.sapi.repositorios;

import java.util.List;
import org.damian.sapi.entidades.Facultad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Damian Martinez
 */
@Repository
public interface FacultadRepositorio extends JpaRepository<Facultad, Integer>{
    @Query("SELECT E FROM Facultad E")
    public List<Facultad> obtenerTodas();
}
