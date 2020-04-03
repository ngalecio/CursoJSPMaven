/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author neygalecio
 */
public class ConexionBD {
    
    
    public static Connection Conexion() throws ClassNotFoundException
    {
        
        
        try {
             Connection cn;
        String user="root";
        String url="jdbc:mysql://localhost:3306/test";
        String password="root1234";
        String Driver="com.mysql.jdbc.Driver";
        
        Class.forName(Driver);
        
            cn= DriverManager.getConnection(url, user, password);
            return cn;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
