/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import Modelo.MateriaPrima;
import Modelo.RecetaDetalle;
import ModeloDAO.MateriaPrimaDAO;
import ModeloDAO.RecetaDetalleDAO;
import com.google.gson.Gson;
import com.modelos.RespuestaJson;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author certus3
 */
public class RecetaDetalleController extends HttpServlet {

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
         
        
        int codigo_materiaprima =0;
       String codigo_producto = "";
        
        BigDecimal cantidad = new BigDecimal(0);
        //BigDecimal factor_materiaprima = new BigDecimal(0);
        codigo_producto = request.getParameter("codigo_producto");
                 if (!(action.equals("listarRecetaDetalle")))
        {
                    
        
        codigo_materiaprima = Integer.parseInt( request.getParameter("codigo_materiaprima"));
        cantidad = new BigDecimal(request.getParameter("cantidad"));
//          
        }
        
          
//        
        
        RespuestaJson respuesta = new RespuestaJson();
                
     
        RecetaDetalle mp = new RecetaDetalle();
        this.jsonResponse="";
        
        switch (action) {
            case "addRecetaDetalle":               
                mp.setCodigo_producto(codigo_producto);
                mp.setCodigo_materiaprima(codigo_materiaprima);
                mp.setCantidad(cantidad);
                
                
                RecetaDetalleDAO.Registrar(mp);
                respuesta.setEstado("ok");
                respuesta.setMensaje("Transaccion ok");                
                this.jsonResponse = this.json.toJson(respuesta);
                response.setContentType("application/json");
                response.getWriter().write(this.jsonResponse);   
                break;
            case "updateMateriaPrima":
                mp.setCodigo_producto(codigo_producto);
                mp.setCodigo_materiaprima(codigo_materiaprima);
                mp.setCantidad(cantidad);                                                
                RecetaDetalleDAO.Actualizar(mp);
                respuesta.setEstado("ok");
                respuesta.setMensaje("Transaccion ok");
                this.jsonResponse = this.json.toJson(respuesta);
                response.setContentType("application/json");
                response.getWriter().write(this.jsonResponse);
                break;
            case "consultarRecetaDetalle":
                mp = RecetaDetalleDAO.Consultar(codigo_materiaprima);    
                if (mp!=null)
                {
                respuesta.setEstado("ok");
                respuesta.setMensaje("Transaccion ok");
                }
                else
                {
                mp=new RecetaDetalle();
                respuesta.setEstado("error");
                respuesta.setMensaje("No existe Producto");
                }
                mp.setRespuestaJson(respuesta);
                this.jsonResponse = this.json.toJson(mp);
                response.setContentType("application/json");
                response.getWriter().write(this.jsonResponse);                                
                break;
            case "listarRecetaDetalle":
                List<RecetaDetalle> lista = new ArrayList<>();
                lista = RecetaDetalleDAO.listar(codigo_producto);    
//                if (lista!=null)
//                {
//                respuesta.setEstado("ok");
//                respuesta.setMensaje("Transaccion ok");
//                }
//                else
//                {
//                
//                respuesta.setEstado("error");
//                respuesta.setMensaje("No existe Producto");
//                }
//                
//                mp.setRespuestaJson(respuesta);
                this.jsonResponse="";
                this.jsonResponse = this.json.toJson(lista);
                response.setContentType("application/json");
                response.getWriter().write(this.jsonResponse);                                
                break;
            default:
                request.getRequestDispatcher("/jsp_app/mantenimiento/materiaprima.jsp").forward(request, response);
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
