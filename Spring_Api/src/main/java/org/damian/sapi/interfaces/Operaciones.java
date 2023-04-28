/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.damian.sapi.interfaces;

import java.util.List;

/**
 *
 * @author Damian Martinez
 * @param <T>
 */
public interface Operaciones <T> {
    public List <T> consultar();
    public Boolean agregar (T miObjeto);
    public Integer catidadRegistros();
    public Boolean eliminar(Integer id);
    public Boolean actualizar (T miObjeto);
    public T buscar (Integer miLlavePrimaria);
}
