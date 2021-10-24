
package com.app.cliente.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pruebaperson")
public class PruebaPersona {
    int id;
    String nombreMascota;
    String cantidadMascota;
    int persona;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getCantidadMascota() {
        return cantidadMascota;
    }

    public void setCantidadMascota(String cantidadMascota) {
        this.cantidadMascota = cantidadMascota;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "PruebaPersona{" + "id=" + id + ", nombreMascota=" + nombreMascota + ", cantidadMascota=" + cantidadMascota + ", persona=" + persona + '}';
    }
    
}
