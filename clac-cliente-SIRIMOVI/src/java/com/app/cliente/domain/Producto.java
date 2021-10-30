/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.cliente.domain;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="product")
public class Producto {
    int id;
    int idInformacionComercial;
    String nombre;
    Float precioVenta;
    Float precioFabricacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInformacionComercial() {
        return idInformacionComercial;
    }

    public void setIdInformacionComercial(int idInformacionComercial) {
        this.idInformacionComercial = idInformacionComercial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Float getPrecioFabricacion() {
        return precioFabricacion;
    }

    public void setPrecioFabricacion(float precioFabricacion) {
        this.precioFabricacion = precioFabricacion;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", idInformacionComercial=" + idInformacionComercial + ", nombre=" + nombre + ", precioVenta=" + precioVenta + ", precioFabricacion=" + precioFabricacion + '}';
    }
       
    
}
