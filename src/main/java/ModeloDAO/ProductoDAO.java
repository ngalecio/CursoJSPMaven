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
public class ProductoDAO {
    public static boolean Registrar(Producto mp)
    {
        try {
            String SQL="INSERT INTO producto"
                    + "(CODIGO,NOMBRE,DESCRIPCION,LOTE,CODIGO_CATEGORIA,CODIGO_PRESENTACION,FOTO_BASE64)"
                    + " VALUES(?,?,?,?,?,?,?)";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1,mp.getCodigo());
            st.setString(2,mp.getNombre());
            st.setString(3,mp.getDescripcion());
            st.setString(4,mp.getLote());
            st.setInt(5,mp.getCodigo_categoria());
            st.setInt(6,mp.getCodigo_presentacion());
            st.setString(7,mp.getFoto_base64());
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
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
        public static boolean Actualizar(Producto mp)
    {
        try {
            String SQL="UPDATE PRODUCTO SET nombre=?"
                    + ",descripcion=?"
                    + ",lote=?"
                    + ",codigo_categoria=?"
                    + ",codigo_presentacion=? "
                    + ",foto_base64=?"
                    + " WHERE codigo=?";
            
            //SQL = "UPDATE materiaprima SET  NOMBRE= ? WHERE CODIGO = ?;";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1,mp.getNombre());
            st.setString(2,mp.getDescripcion());
            st.setString(3,mp.getLote());
            st.setInt(4,mp.getCodigo_categoria());            
            st.setInt(5,mp.getCodigo_presentacion());                        
            st.setString(6,mp.getFoto_base64());
            st.setString(7,mp.getCodigo());
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
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        
        public static Producto Consultar(String codigo)
        {
          try {
            String SQL="select pro.*,pre.nombre as nombre_presentacion, "
                    + "cat.nombre as nombre_categoria "
                    + "from producto pro,presentacion pre,categorias cat "
                    + "where pro.codigo_presentacion = pre.codigo "
                    + "and pro.codigo_categoria = cat.codigo and pro.codigo = ?";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            st.setString(1,codigo);
            ResultSet rs = st.executeQuery();
            
            Producto mp=null;
            while (rs.next())
                    {
                        mp = null;
                        mp = new Producto(
                                rs.getString("codigo"),
                                rs.getString("nombre"),
                                rs.getString("descripcion"),
                                rs.getString("lote"),                                
                                rs.getInt("codigo_categoria"),
                                rs.getInt("codigo_presentacion")                                
                        );                        
                        mp.setNombre_categoria(rs.getString("nombre_categoria"));
                        mp.setNombre_presentacion(rs.getString("nombre_presentacion"));
                        mp.setFoto_base64(rs.getString("foto_base64"));
                    }
            return mp;
                                    
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        }
        public static ArrayList<Producto> listar()
    {
        try {
            String SQL="select pro.*,pre.nombre as nombre_presentacion, "
                    + "cat.nombre as nombre_categoria "
                    + "from producto pro,presentacion pre,categorias cat "
                    + "where pro.codigo_presentacion = pre.codigo "
                    + "and pro.codigo_categoria = cat.codigo";
            Connection cn=ConexionBD.Conexion();
            PreparedStatement st = cn.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();
            ArrayList<Producto> lista=new ArrayList<>();
            Producto mp;
            while (rs.next())
                    {
                        mp = null;
                        mp = new Producto(
                                rs.getString("codigo"),
                                rs.getString("nombre"),
                                rs.getString("descripcion"),
                                rs.getString("lote"),                                
                                rs.getInt("codigo_categoria"),
                                rs.getInt("codigo_presentacion")                                
                        );                        
                        mp.setNombre_categoria(rs.getString("nombre_categoria"));
                        mp.setNombre_presentacion(rs.getString("nombre_presentacion"));
                        mp.setFoto_base64(rs.getString("foto_base64"));
                        lista.add(mp);
                    }
            return lista;
                                    
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
