
package com.app.servicio.adminGral.domain;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="product")
public class Producto {
    int id;
    int idInformacionComercial;
    String nombreNegocio;
    String nombre;
    float precioVenta;
    float precioFabricacion;
    
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

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getPrecioFabricacion() {
        return precioFabricacion;
    }

    public void setPrecioFabricacion(float precioFabricacion) {
        this.precioFabricacion = precioFabricacion;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", idInformacionComercial=" + idInformacionComercial + ", nombre=" + nombre + ", precioVenta=" + precioVenta + ", precioFabricacion=" + precioFabricacion + '}';
    }
       
    
}
