/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Interfaces.CRUD;
import Modelo.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author neygalecio
 */
public class PersonaDAO implements CRUD{

    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    Persona p= new Persona();
    @Override
    public List listar() {
        ArrayList<Persona> lista = new ArrayList<>();
        String sql = "select * from usuarios";
        try {
            cn= ModeloDAO.ConexionBD.Conexion();
            ps=cn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next())
            {
             Persona per = new Persona()   ;
             per.setId(rs.getInt("id"));
             per.setDni(rs.getString("dni"));
             per.setNombres(rs.getString("nombres"));             
             lista.add(per);             
            }
            
        } catch (Exception e) {
            
        }
        return lista;
                
            
            
        
        
    }

    @Override
    public Persona List(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insertar(Persona p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Modificar(Persona p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
