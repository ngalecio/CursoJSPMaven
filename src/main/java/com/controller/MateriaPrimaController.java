/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import Modelo.MateriaPrima;
import Modelo.Producto;
import ModeloDAO.MateriaPrimaDAO;
import ModeloDAO.ProductoDAO;
import com.google.gson.Gson;
import com.modelos.RespuestaJson;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author certus3
 */
public class MateriaPrimaController extends HttpServlet {

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
        Integer id_materiaprima = Integer.parseInt(request.getParameter("id_materiaprima").toString());  
        
        String nombre_materiaprima ="";
       String descripcion_materiaprima = "";
        String lote_materiaprima = "";
        BigDecimal costo_materiaprima = new BigDecimal(0);
        BigDecimal factor_materiaprima = new BigDecimal(0);
        Integer codigo_unidaddemedida = 0;
                 if (!(action.equals("consultarMateriaPrima")))
        {
        nombre_materiaprima = request.getParameter("nombre_materiaprima");
        descripcion_materiaprima = request.getParameter("descripcion_materiaprima");
        lote_materiaprima = request.getParameter("lote_materiaprima");
        costo_materiaprima = new BigDecimal(request.getParameter("costo_materiaprima"));
        factor_materiaprima = new BigDecimal(request.getParameter("factor_materiaprima"));
        codigo_unidaddemedida = Integer.parseInt(request.getParameter("codigo_unidaddemedida").toString());
//          
        }
        
          
//        
        
        RespuestaJson respuesta = new RespuestaJson();
                
     
        MateriaPrima mp = new MateriaPrima();
        
        switch (action) {
            case "addMateriaPrima":                
                mp.setCodigo(0);
                mp.setNombre(nombre_materiaprima);
                mp.setDescripcion(descripcion_materiaprima);
                mp.setLote(lote_materiaprima);
                mp.setCosto(costo_materiaprima);
                mp.setFactor(factor_materiaprima);
                mp.setCodigo_unidaddemedida(codigo_unidaddemedida);
                
                
                MateriaPrimaDAO.Registrar(mp);
                respuesta.setEstado("ok");
                respuesta.setMensaje("Transaccion ok");                
                this.jsonResponse = this.json.toJson(respuesta);
                response.setContentType("application/json");
                response.getWriter().write(this.jsonResponse);   
                break;
            case "updateMateriaPrima":
                mp.setCodigo(id_materiaprima);
                mp.setNombre(nombre_materiaprima);
                mp.setDescripcion(descripcion_materiaprima);
                mp.setLote(lote_materiaprima);
                mp.setCosto(costo_materiaprima);
                mp.setFactor(factor_materiaprima);
                mp.setCodigo_unidaddemedida(codigo_unidaddemedida);                
                MateriaPrimaDAO.Actualizar(mp);
                respuesta.setEstado("ok");
                respuesta.setMensaje("Transaccion ok");
                this.jsonResponse = this.json.toJson(respuesta);
                response.setContentType("application/json");
                response.getWriter().write(this.jsonResponse);
                break;
            case "consultarMateriaPrima":
                mp = MateriaPrimaDAO.Consultar(id_materiaprima);    
                if (mp!=null)
                {
                respuesta.setEstado("ok");
                respuesta.setMensaje("Transaccion ok");
                }
                else
                {
                mp=new MateriaPrima();
                respuesta.setEstado("error");
                respuesta.setMensaje("No existe Producto");
                }
                mp.setRespuestaJson(respuesta);
                this.jsonResponse = this.json.toJson(mp);
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
