/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Persona;
import java.util.List;

/**
 *
 * @author neygalecio
 */
public interface CRUD {
    public List listar();
    public Persona List(int id);
    public boolean Insertar(Persona p);
    public boolean Modificar(Persona p);
    public boolean Eliminar(int id);    
    
}
