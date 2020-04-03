/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.modelos.RespuestaJson;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author certus3
 */
public class RecetaDetalle implements Serializable{
    private String codigo_producto;

    public RecetaDetalle() {
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public int getCodigo_materiaprima() {
        return codigo_materiaprima;
    }

    public void setCodigo_materiaprima(int codigo_materiaprima) {
        this.codigo_materiaprima = codigo_materiaprima;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion_materiaprima() {
        return descripcion_materiaprima;
    }

    public void setDescripcion_materiaprima(String descripcion_materiaprima) {
        this.descripcion_materiaprima = descripcion_materiaprima;
    }

    public RecetaDetalle(String codigo_producto, int codigo_materiaprima, BigDecimal cantidad, String descripcion_materiaprima) {
        this.codigo_producto = codigo_producto;
        this.codigo_materiaprima = codigo_materiaprima;
        this.cantidad = cantidad;
        this.descripcion_materiaprima = descripcion_materiaprima;
    }

    private int codigo_materiaprima;    
    private BigDecimal cantidad;
    private String descripcion_materiaprima;
    private RespuestaJson respuestaJson;

    public RespuestaJson getRespuestaJson() {
        return respuestaJson;
    }

    public void setRespuestaJson(RespuestaJson respuestaJson) {
        this.respuestaJson = respuestaJson;
    }

   
    
}
