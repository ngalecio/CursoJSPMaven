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
public class RecetaDetalleDAO {
    public static boolean Registrar(RecetaDetalle mp)
    {
        try {
            String SQL="INSERT INTO recetadetalle"
                    + "(codigo_producto,codigo_materia_prima,cantidad)"
                    + " VALUES(?,?,?,?,?,?)";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1,mp.getCodigo_producto());
            st.setInt(2,mp.getCodigo_materiaprima());
            st.setBigDecimal(3,mp.getCantidad());
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
            Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
        public static boolean Actualizar(RecetaDetalle mp)
    {
        try {
            String SQL="UPDATE recetadetalle SET cantidad=?"
                    + " WHERE codigo_producto=? and codigo_materiapria =? ";
            
            //SQL = "UPDATE materiaprima SET  NOMBRE= ? WHERE CODIGO = ?;";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(2,mp.getCodigo_producto());
            st.setInt(3,mp.getCodigo_materiaprima());
            st.setBigDecimal(1,mp.getCantidad());
            
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
            Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        
        
    public static RecetaDetalle Consultar(Integer codigo)
        {
          try {
            String SQL="select m.*,u.nombre as nombre_unidaddemedida from materiaprima m,"
                    + "unidaddemedida u where m.codigo_unidaddemedida = u.codigo "
                    + " and m.codigo =?"
                    + " order by m.codigo";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setInt(1,codigo);
            ResultSet rs = st.executeQuery();
            
            RecetaDetalle mp=null;
            while (rs.next())
                    {
                        mp = null;
                        mp = new RecetaDetalle(
                                rs.getString("codigo_producto"),
                                rs.getInt("codigo_materiaprima"),
                                rs.getBigDecimal("cantidad"),
                                rs.getString("nombre_materiaprima")
                        );
                        
                        
                    }
            return mp;
                                    
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        }    
        
        public static ArrayList<RecetaDetalle> listar(String codigo_producto)
    {
        try {
            String SQL="SELECT r.*,mp.nombre as nombre_materiaprima " +
                " FROM recetadetalle r,materiaprima mp " +
                " where r.codigo_materiaprima = mp.codigo and r.codigo_producto =?";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1,codigo_producto);
            ResultSet rs = st.executeQuery();
            ArrayList<RecetaDetalle> lista=new ArrayList<>();
            RecetaDetalle mp;
            while (rs.next())
                    {
                        mp = null;
                        mp = new RecetaDetalle(                                
                                rs.getString("codigo_producto"),
                                rs.getInt("codigo_materiaprima"),
                                rs.getBigDecimal("cantidad"),
                                rs.getString("nombre_materiaprima")                                
                        );
                        
                        
                        lista.add(mp);
                    }
            return lista;
                                    
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
