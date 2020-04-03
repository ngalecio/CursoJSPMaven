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
public class UnidaddeMedidaDAO {
    public static boolean Registrar(UnidaddeMedida c)
    {
        try {
            String SQL="INSERT INTO unidaddemedida(NOMBRE) VALUES(?)";
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
    
        public static boolean Actualizar(UnidaddeMedida c)
    {
        try {
            String SQL="UPDATE unidaddemedida SET  NOMBRE= ? WHERE CODIGO = ?";
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
        public static ArrayList<UnidaddeMedida> listar()
    {
        try {
            String SQL="select * from unidaddemedida";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();
            ArrayList<UnidaddeMedida> lista=new ArrayList<>();
            UnidaddeMedida uni;
            while (rs.next())
                    {
                        uni = null;
                        uni = new UnidaddeMedida(rs.getInt("codigo"),rs.getString("nombre"));
                        lista.add(uni);
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
