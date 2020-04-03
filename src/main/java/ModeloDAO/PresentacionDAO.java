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
public class PresentacionDAO {
    public static boolean Registrar(Presentacion c)
    {
        try {
            String SQL="INSERT INTO presentacion(NOMBRE) VALUES(?)";
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
            Logger.getLogger(UnidaddeMedidaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
        public static boolean Actualizar(Presentacion c)
    {
        try {
            String SQL="UPDATE presentacion SET  NOMBRE= ? WHERE CODIGO = ?";
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
            Logger.getLogger(UnidaddeMedidaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        public static ArrayList<Presentacion> listar()
    {
        try {
            String SQL="select * from presentacion";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();
            ArrayList<Presentacion> lista=new ArrayList<>();
            Presentacion pre;
            while (rs.next())
                    {
                        pre = null;
                        pre = new Presentacion(rs.getInt("codigo"),rs.getString("nombre"));
                        lista.add(pre);
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
