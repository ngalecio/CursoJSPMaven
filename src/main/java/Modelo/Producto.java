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
public class Producto implements Serializable{
    private String codigo;
    private String nombre;

    private String descripcion;
    private String lote;    
    private int codigo_categoria;
    private int codigo_presentacion;
    private String nombre_categoria;
    private String nombre_presentacion;
    private RespuestaJson respuestaJson;
    private String foto_base64;

    public String getFoto_base64() {
        return foto_base64;
    }

    public void setFoto_base64(String foto_base64) {
        this.foto_base64 = foto_base64;
    }
    public RespuestaJson getRespuestaJson() {
        return respuestaJson;
    }

    public void setRespuestaJson(RespuestaJson respuestaJson) {
        this.respuestaJson = respuestaJson;
    }
    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getNombre_presentacion() {
        return nombre_presentacion;
    }

    public void setNombre_presentacion(String nombre_presentacion) {
        this.nombre_presentacion = nombre_presentacion;
    }

    public Producto(String codigo, String nombre, String descripcion, String lote, int codigo_categoria, int codigo_presentacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lote = lote;
        this.codigo_categoria = codigo_categoria;
        this.codigo_presentacion = codigo_presentacion;
    }

    public Producto() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getCodigo_categoria() {
        return codigo_categoria;
    }

    public void setCodigo_categoria(int codigo_categoria) {
        this.codigo_categoria = codigo_categoria;
    }

    public int getCodigo_presentacion() {
        return codigo_presentacion;
    }

    public void setCodigo_presentacion(int codigo_presentacion) {
        this.codigo_presentacion = codigo_presentacion;
    }

  
}
