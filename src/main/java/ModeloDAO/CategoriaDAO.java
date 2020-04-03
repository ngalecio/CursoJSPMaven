/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 *
 * @author certus3
 */
public class CategoriaDAO {
    public static boolean Registrar(Categoria c)
    {
        try {
            String SQL="INSERT INTO CATEGORIAS(NOMBRE) VALUES(?)";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1,c.getNombre());
            if (st.executeUpdate() > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
                                    
        } catch (SQLException e) {
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
        public static boolean Actualizar(Categoria c)
    {
        try {
            String SQL="UPDATE CATEGORIAS SET  NOMBRE= ? WHERE CODIGO = ?";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1,c.getNombre());
            st.setInt(2,c.getCodigo());
            if (st.executeUpdate() > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
                                    
        } catch (SQLException e) {
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        public static ArrayList<Categoria> listar()
    {
        try {
            String SQL="select * from categorias";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();
            ArrayList<Categoria> lista=new ArrayList<>();
            Categoria cat;
            while (rs.next())
                    {
                        cat = null;
                        cat = new Categoria(rs.getInt("codigo"),rs.getString("nombre"));
                        lista.add(cat);
                    }
            return lista;
                                    
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
