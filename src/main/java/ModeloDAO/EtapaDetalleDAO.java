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
public class EtapaDetalleDAO {
    public static boolean Registrar(EtapaDetalle mp)
    {
        try {
            String SQL="INSERT INTO etapadetalle"
                    + "(codigo_producto,codigo_tecnicadefabricacion,tiempo)"
                    + " VALUES(?,?,?,?,?,?)";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1,mp.getCodigo_producto());
            st.setInt(2,mp.getCodigo_tecnicadefabricacion());
            st.setBigDecimal(3,mp.getTiempo());
            //st.setBigDecimal(5,mp.getFactor());
            //st.setInt(6,mp.getCodigo_unidaddemedida());
            
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
            Logger.getLogger(EtapaDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
        public static boolean Actualizar(EtapaDetalle mp)
    {
        try {
            String SQL="UPDATE etapadetalle SET tiempo=?"
                    + " WHERE codigo_producto=? and "
                    + "codigo_tecnicadefabricacion =? ";
            
            //SQL = "UPDATE materiaprima SET  NOMBRE= ? WHERE CODIGO = ?;";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(2,mp.getCodigo_producto());
            st.setInt(3,mp.getCodigo_tecnicadefabricacion());
            st.setBigDecimal(1,mp.getTiempo());
            
            if (st.executeUpdate() > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
                                    
        } catch (SQLException e) {
            Logger.getLogger(e.getMessage().toString());
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EtapaDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        
        
    public static EtapaDetalle Consultar(Integer codigo)
        {
          try {
            String SQL="select e.*,t.nombre as nombre_tecnicadefabricacion"
                    + "from etapadetalle e,tecnicadefabricacion t "
                    + "where e.codigo_tecnicadefabricacion = t.codigo "
                    + "codigo =?";
                    
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setInt(1,codigo);
            ResultSet rs = st.executeQuery();
            
            EtapaDetalle mp=null;
            while (rs.next())
                    {
                        mp = null;
                        mp = new EtapaDetalle(
                                rs.getString("codigo_producto"),
                                rs.getInt("codigo_tecnicadefabricacion"),
                                rs.getBigDecimal("tiempo"),
                                rs.getString("nombre_tecnicadefabricacion")
                        );
                        
                        
                    }
            return mp;
                                    
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EtapaDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        }    
        
        public static ArrayList<EtapaDetalle> listar(String codigo_producto)
    {
        try {
            String SQL="select e.*,t.nombre as nombre_tecnicadefabricacion"
                    + " from etapadetalle e,tecnicadefabricacion t "
                    + " where e.codigo_tecnicadefabricacion = t.codigo and "
                    + " e.codigo_producto =?";
            
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1,codigo_producto);
            ResultSet rs = st.executeQuery();
            ArrayList<EtapaDetalle> lista=new ArrayList<>();
            EtapaDetalle mp;
            while (rs.next())
                    {
                        mp = null;
                        mp = new EtapaDetalle(                                
                                rs.getString("codigo_producto"),
                                rs.getInt("codigo_tecnicadefabricacion"),
                                rs.getBigDecimal("tiempo"),
                                rs.getString("nombre_tecnicadefabricacion")                                                 
                        );
                        
                        
                        lista.add(mp);
                    }
            return lista;
                                    
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EtapaDetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
