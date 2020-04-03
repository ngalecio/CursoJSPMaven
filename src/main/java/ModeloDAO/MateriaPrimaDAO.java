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
public class MateriaPrimaDAO {
    public static boolean Registrar(MateriaPrima mp)
    {
        try {
            String SQL="INSERT INTO materiaprima"
                    + "(NOMBRE,DESCRIPCION,LOTE,COSTO,FACTOR,CODIGO_UNIDADDEMEDIDA)"
                    + " VALUES(?,?,?,?,?,?)";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1,mp.getNombre());
            st.setString(2,mp.getDescripcion());
            st.setString(3,mp.getLote());
            st.setBigDecimal(4,mp.getCosto());
            st.setBigDecimal(5,mp.getFactor());
            st.setInt(6,mp.getCodigo_unidaddemedida());
            
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
    
        public static boolean Actualizar(MateriaPrima mp)
    {
        try {
            String SQL="UPDATE materiaprima SET nombre=?"
                    + ",descripcion=?"
                    + ",lote=?"
                    + ",costo=?"
                    + ",factor=?"
                    + ",codigo_unidaddemedida=? "
                    + " WHERE codigo=?";
            
            //SQL = "UPDATE materiaprima SET  NOMBRE= ? WHERE CODIGO = ?;";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1,mp.getNombre());
            st.setString(2,mp.getDescripcion());
            st.setString(3,mp.getLote());
            st.setBigDecimal(4,mp.getCosto());
            st.setBigDecimal(5,mp.getFactor());
            st.setInt(6,mp.getCodigo_unidaddemedida());            
            st.setInt(7,mp.getCodigo());
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
        
        
    public static MateriaPrima Consultar(Integer codigo)
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
            
            MateriaPrima mp=null;
            while (rs.next())
                    {
                        mp = null;
                        mp = new MateriaPrima(
                                rs.getInt("codigo"),
                                rs.getString("nombre"),
                                rs.getString("descripcion"),
                                rs.getString("lote"),
                                rs.getBigDecimal("costo"),
                                rs.getBigDecimal("factor"),
                                rs.getInt("codigo_unidaddemedida")                                
                                
                        );
                        mp.setDescripcion_unidaddemedida(rs.getString("nombre_unidaddemedida"));
                        
                    }
            return mp;
                                    
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        }    
        
        public static ArrayList<MateriaPrima> listar()
    {
        try {
            String SQL="select m.*,u.nombre as nombre_unidaddemedida from materiaprima m,"
                    + "unidaddemedida u where m.codigo_unidaddemedida = u.codigo order by m.codigo";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();
            ArrayList<MateriaPrima> lista=new ArrayList<>();
            MateriaPrima mp;
            while (rs.next())
                    {
                        mp = null;
                        mp = new MateriaPrima(
                                rs.getInt("codigo"),
                                rs.getString("nombre"),
                                rs.getString("descripcion"),
                                rs.getString("lote"),
                                rs.getBigDecimal("costo"),
                                rs.getBigDecimal("factor"),
                                rs.getInt("codigo_unidaddemedida")                                
                                
                        );
                        mp.setDescripcion_unidaddemedida(rs.getString("nombre_unidaddemedida"));
                        
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
