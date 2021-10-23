
package com.app.servicio.adminGral.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pruebaperson")
public class PruebaPersona {
    int id;
    String nombreMascota;
    String cantidadMascota;
    int persona;
    
    //Persona persona;
    
    /*int persona;
    String nombres;
    String correos;
    String nacionalidad;*/

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
    
    

    /*public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }*/
    
    

    /*public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreos() {
        return correos;
    }

    public void setCorreos(String correos) {
        this.correos = correos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }*/
    
    

    @Override
    public String toString() {
        return "PruebaPersona{" + "id=" + id + ", nombreMascota=" + nombreMascota + ", cantidadMascota=" + cantidadMascota + ", persona=" + persona + '}';
    }
    
}
