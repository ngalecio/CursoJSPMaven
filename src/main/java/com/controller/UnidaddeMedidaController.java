/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import Modelo.Categoria;
import Modelo.UnidaddeMedida;
import ModeloDAO.CategoriaDAO;
import ModeloDAO.UnidaddeMedidaDAO;
import com.google.gson.Gson;
import com.modelos.RespuestaJson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author certus3
 */
public class UnidaddeMedidaController extends HttpServlet {

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
        String nombre_unidaddemedida = request.getParameter("nombre_unidaddemedida");
        Integer id_unidaddemedida = Integer.parseInt(request.getParameter("id_unidaddemedida").toString());
        RespuestaJson respuesta = new RespuestaJson();
                
     
        UnidaddeMedida uni = new UnidaddeMedida();
        
        switch (action) {
            case "addUnidaddeMedida":                
                uni.setCodigo(0);
                uni.setNombre(nombre_unidaddemedida);
                UnidaddeMedidaDAO.Registrar(uni);
                respuesta.setEstado("ok");
                respuesta.setMensaje("Transaccion ok");                
                this.jsonResponse = this.json.toJson(respuesta);
                response.setContentType("application/json");
                response.getWriter().write(this.jsonResponse);   
                break;
            case "updateUnidaddeMedida":
                uni.setCodigo(id_unidaddemedida);
                uni.setNombre(nombre_unidaddemedida);
                UnidaddeMedidaDAO.Actualizar(uni);
                respuesta.setEstado("ok");
                respuesta.setMensaje("Transaccion ok");
                this.jsonResponse = this.json.toJson(respuesta);
                response.setContentType("application/json");
                response.getWriter().write(this.jsonResponse);
                break;
            default:
                request.getRequestDispatcher("/jsp_app/mantenimiento/unidaddemedida.jsp").forward(request, response);
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
