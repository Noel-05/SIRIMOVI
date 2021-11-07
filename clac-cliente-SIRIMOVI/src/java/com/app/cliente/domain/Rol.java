
package com.app.cliente.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rol")
public class Rol {
    int idRol;
    String nombreRol;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @Override
    public String toString() {
        return "Rol{" + "idRol=" + idRol + ", nombreRol=" + nombreRol + '}';
    }
}
