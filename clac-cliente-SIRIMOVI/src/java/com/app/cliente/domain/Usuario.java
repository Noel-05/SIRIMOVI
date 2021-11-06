
package com.app.cliente.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
public class Usuario {
    int idUsuario;
    int idRol;
    String nombre;
    String apellido;
    String correo;
    String password;

    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int id) {
        this.idUsuario = id;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String ToString(){
    return "Persona{" + "id=" + idUsuario + "idRol=" + idRol + " Nombre" + nombre + " Apellido " + apellido + " Correo" + correo + " Contraseña" + password + '}';
    }
}
