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
public class MateriaPrima implements Serializable{
    private int codigo;
    private String nombre;

    private String descripcion;
    private String lote;
    private BigDecimal costo;
    private BigDecimal factor;
    private int codigo_unidaddemedida;
    private String descripcion_unidaddemedida;
    private RespuestaJson respuestaJson;

    public RespuestaJson getRespuestaJson() {
        return respuestaJson;
    }

    public void setRespuestaJson(RespuestaJson respuestaJson) {
        this.respuestaJson = respuestaJson;
    }

    public String getDescripcion_unidaddemedida() {
        return descripcion_unidaddemedida;
    }

    public void setDescripcion_unidaddemedida(String descripcion_unidaddemedida) {
        this.descripcion_unidaddemedida = descripcion_unidaddemedida;
    }
    
    
    
    public MateriaPrima() {
        this.codigo = 0;
        this.nombre = "";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
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

    public int getCodigo_unidaddemedida() {
        return codigo_unidaddemedida;
    }

    public void setCodigo_unidaddemedida(int codigo_unidaddemedida) {
        this.codigo_unidaddemedida = codigo_unidaddemedida;
    }

    public MateriaPrima(int codigo, String nombre, String descripcion, String lote, BigDecimal costo, BigDecimal factor, int codigo_unidaddemedida) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lote = lote;
        this.costo = costo;
        this.factor = factor;
        this.codigo_unidaddemedida = codigo_unidaddemedida;
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
    
}
