/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Modelo.Categoria;
import Modelo.Editorial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author certus3
 */
public class EditorialDAO {
        public static boolean Registrar(Editorial e)
    {
        try {
            
    
            String SQL="INSERT INTO EDITORIALES(nit,nombre,telefono,direccion,email,sitioweb) VALUES(?,?,?,?,?,?)";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1,e.getNit());
            st.setString(2,e.getNombre());
            st.setString(3,e.getTelefono());
            st.setString(4,e.getDireccion());
            st.setString(5,e.getEmail());
            st.setString(6,e.getSitioweb());
            if (st.executeUpdate() > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
                                    
        } catch (SQLException ex2) {
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UnidaddeMedidaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        public static ArrayList<Editorial> listar()
    {
        try {
            String SQL="select * from editoriales";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();
            ArrayList<Editorial> lista=new ArrayList<>();
            Editorial edi;
            while (rs.next())
                    {
                        edi = null;
                        edi = new Editorial();
                        edi.setNit(rs.getString("nit"));
                        edi.setNombre(rs.getString("nombre"));
                        edi.setDireccion(rs.getString("direccion"));
                        edi.setEmail(rs.getString("email"));
                        edi.setSitioweb(rs.getString("sitioweb"));
                        edi.setTelefono(rs.getString("telefono"));
                        lista.add(edi);
                    }
            return lista;
                                    
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UnidaddeMedidaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

