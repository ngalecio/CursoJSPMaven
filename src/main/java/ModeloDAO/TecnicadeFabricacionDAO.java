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
public class TecnicadeFabricacionDAO {
    public static boolean Registrar(TecnicadeFabricacion tefa)
    {
        try {
            String SQL="INSERT INTO tecnicadefabricacion"
                    + "(NOMBRE,DESCRIPCION,TIEMPO,COSTO,FACTOR)"
                    + " VALUES(?,?,?,?,?)";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1,tefa.getNombre());
            st.setString(2,tefa.getDescripcion());
            st.setBigDecimal(3,tefa.getTiempo());
            st.setBigDecimal(4,tefa.getCosto());
            st.setBigDecimal(5,tefa.getFactor());
            
            
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
    
        public static boolean Actualizar(TecnicadeFabricacion tefa)
    {
        try {
            String SQL="UPDATE tecnicadefabricacion SET nombre=?"
                    + ",descripcion=?"
                    + ",tiempo=?"
                    + ",costo=?"
                    + ",factor=?"                    
                    + " WHERE codigo=?";
            
            //SQL = "UPDATE materiaprima SET  NOMBRE= ? WHERE CODIGO = ?;";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1,tefa.getNombre());
            st.setString(2,tefa.getDescripcion());
            st.setBigDecimal(3,tefa.getTiempo());
            st.setBigDecimal(4,tefa.getCosto());
            st.setBigDecimal(5,tefa.getFactor());
            
            st.setInt(6,tefa.getCodigo());
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
            public static TecnicadeFabricacion Consultar(Integer codigo)
        {
          try {
            String SQL="select * from tecnicadefabricacion "
                    + " where codigo =?"
                    + " order by codigo";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setInt(1,codigo);
            ResultSet rs = st.executeQuery();
            
            TecnicadeFabricacion tefa=null;
            while (rs.next())
                    {
                            tefa = null;
                        tefa = new TecnicadeFabricacion(
                                rs.getInt("codigo"),
                                rs.getString("nombre"),
                                rs.getString("descripcion"),
                                rs.getBigDecimal("tiempo"),
                                rs.getBigDecimal("costo"),
                                rs.getBigDecimal("factor")                                                                
                        );
                    }
            return tefa;
                                    
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TecnicadeFabricacionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        }    
        
        
        public static ArrayList<TecnicadeFabricacion> listar()
    {
        try {
            String SQL="select * from tecnicadefabricacion ";
                    
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();
            ArrayList<TecnicadeFabricacion> lista=new ArrayList<>();
            TecnicadeFabricacion tefa;
            while (rs.next())
                    {
                        tefa = null;
                        tefa = new TecnicadeFabricacion(
                                rs.getInt("codigo"),
                                rs.getString("nombre"),
                                rs.getString("descripcion"),
                                rs.getBigDecimal("tiempo"),
                                rs.getBigDecimal("costo"),
                                rs.getBigDecimal("factor")                                                                
                        );
                        
                        lista.add(tefa);
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
