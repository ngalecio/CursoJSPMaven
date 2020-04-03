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
public class TecnicadeFabricacion implements Serializable{
    private int codigo;
    private String nombre;

    private String descripcion;
    private BigDecimal tiempo;    
    private BigDecimal costo;
    private BigDecimal factor;
    private RespuestaJson respuestaJson;

    public RespuestaJson getRespuestaJson() {
        return respuestaJson;
    }

    public void setRespuestaJson(RespuestaJson respuestaJson) {
        this.respuestaJson = respuestaJson;
    }
      

    public TecnicadeFabricacion(int codigo, String nombre, String descripcion, BigDecimal tiempo, BigDecimal costo, BigDecimal factor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
        this.costo = costo;
        this.factor = factor;
    }

    public TecnicadeFabricacion() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getTiempo() {
        return tiempo;
    }

    public void setTiempo(BigDecimal tiempo) {
        this.tiempo = tiempo;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getFactor() {
        return factor;
    }

    public void setFactor(BigDecimal factor) {
        this.factor = factor;
    }
    

    
    
}
