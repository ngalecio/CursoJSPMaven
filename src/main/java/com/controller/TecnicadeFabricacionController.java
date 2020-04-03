/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import Modelo.MateriaPrima;
import Modelo.TecnicadeFabricacion;
import Modelo.TecnicadeFabricacion;
import ModeloDAO.MateriaPrimaDAO;
import ModeloDAO.TecnicadeFabricacionDAO;
import com.google.gson.Gson;
import com.modelos.RespuestaJson;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author certus3
 */
public class TecnicadeFabricacionController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Gson json=new Gson();
    private String jsonResponse;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action = request.getParameter("accion");
          
        Integer id_tecnicadefabricacion = Integer.parseInt(request.getParameter("id_tecnicadefabricacion").toString());
        String nombre_tecnicadefabricacion = "";
       String descripcion_tecnicadefabricacion =""; 
       
        BigDecimal tiempo_tecnicadefabricacion = new BigDecimal(0);
        BigDecimal costo_tecnicadefabricacion = new BigDecimal(0);
        BigDecimal factor_tecnicadefabricacion = new BigDecimal(0);
        
        
                       if (!(action.equals("consultarTecnicadeFabricacion")))
        {
        nombre_tecnicadefabricacion = request.getParameter("nombre_tecnicadefabricacion");
       descripcion_tecnicadefabricacion = request.getParameter("descripcion_tecnicadefabricacion");
       tiempo_tecnicadefabricacion = new BigDecimal(request.getParameter("tiempo_tecnicadefabricacion"));
        costo_tecnicadefabricacion = new BigDecimal(request.getParameter("costo_tecnicadefabricacion"));
        factor_tecnicadefabricacion = new BigDecimal(request.getParameter("factor_tecnicadefabricacion"));
        
        }
        
        
//        
//        
        
        RespuestaJson respuesta = new RespuestaJson();
                
     
        TecnicadeFabricacion tf = new TecnicadeFabricacion();
        
        switch (action) {
            case "addTecnicadeFabricacion":                
                tf.setCodigo(0);
                tf.setNombre(nombre_tecnicadefabricacion);
                tf.setDescripcion(descripcion_tecnicadefabricacion);
                tf.setTiempo(tiempo_tecnicadefabricacion);
                tf.setCosto(costo_tecnicadefabricacion);
                tf.setFactor(factor_tecnicadefabricacion);
                
                
                
                TecnicadeFabricacionDAO.Registrar(tf);
                respuesta.setEstado("ok");
                respuesta.setMensaje("Transaccion ok");                
                this.jsonResponse = this.json.toJson(respuesta);
                response.setContentType("application/json");
                response.getWriter().write(this.jsonResponse);   
                break;
            case "updateTecnicadeFabricacion":
                tf.setCodigo(id_tecnicadefabricacion);
                tf.setNombre(nombre_tecnicadefabricacion);
                tf.setDescripcion(descripcion_tecnicadefabricacion);
                tf.setTiempo(tiempo_tecnicadefabricacion);
                tf.setCosto(costo_tecnicadefabricacion);
                tf.setFactor(factor_tecnicadefabricacion);
                
                TecnicadeFabricacionDAO.Actualizar(tf);
                respuesta.setEstado("ok");
                respuesta.setMensaje("Transaccion ok");
                this.jsonResponse = this.json.toJson(respuesta);
                response.setContentType("application/json");
                response.getWriter().write(this.jsonResponse);
                break;
                case "consultarTecnicadeFabricacion":
                tf = TecnicadeFabricacionDAO.Consultar(id_tecnicadefabricacion);    
                if (tf!=null)
                {
                respuesta.setEstado("ok");
                respuesta.setMensaje("Transaccion ok");
                }
                else
                {
                tf=new TecnicadeFabricacion();
                respuesta.setEstado("error");
                respuesta.setMensaje("No existe Producto");
                }
                tf.setRespuestaJson(respuesta);
                this.jsonResponse = this.json.toJson(tf);
                response.setContentType("application/json");
                response.getWriter().write(this.jsonResponse);
                
                
                break;
            default:
                request.getRequestDispatcher("/jsp_app/mantenimiento/tecnicadefabricacion.jsp").forward(request, response);
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
