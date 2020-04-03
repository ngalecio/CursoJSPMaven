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
public class EtapaDetalle implements Serializable{

    public EtapaDetalle() {
    }


    private String codigo_producto;
    private int codigo_tecnicadefabricacion;    
    private BigDecimal tiempo;
    private String descripcion_tecnicadefabricacion;
    private RespuestaJson respuestaJson;

    public EtapaDetalle(String codigo_producto, int codigo_tecnicadefabricacion, BigDecimal tiempo, String descripcion_tecnicadefabricacion) {
        this.codigo_producto = codigo_producto;
        this.codigo_tecnicadefabricacion = codigo_tecnicadefabricacion;
        this.tiempo = tiempo;
        this.descripcion_tecnicadefabricacion = descripcion_tecnicadefabricacion;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public int getCodigo_tecnicadefabricacion() {
        return codigo_tecnicadefabricacion;
    }

    public void setCodigo_tecnicadefabricacion(int codigo_tecnicadefabricacion) {
        this.codigo_tecnicadefabricacion = codigo_tecnicadefabricacion;
    }

    public BigDecimal getTiempo() {
        return tiempo;
    }

    public void setTiempo(BigDecimal tiempo) {
        this.tiempo = tiempo;
    }

    public String getDescripcion_tecnicadefabricacion() {
        return descripcion_tecnicadefabricacion;
    }

    public void setDescripcion_tecnicadefabricacion(String descripcion_tecnicadefabricacion) {
        this.descripcion_tecnicadefabricacion = descripcion_tecnicadefabricacion;
    }

    public RespuestaJson getRespuestaJson() {
        return respuestaJson;
    }

    public void setRespuestaJson(RespuestaJson respuestaJson) {
        this.respuestaJson = respuestaJson;
    }

}
