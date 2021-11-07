
package com.app.cliente.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rubro")
public class Rubro {
    int idRubro;
    String nombreRubro;

    public int getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(int idRubro) {
        this.idRubro = idRubro;
    }

    public String getNombreRubro() {
        return nombreRubro;
    }

    public void setNombreRubro(String nombreRubro) {
        this.nombreRubro = nombreRubro;
    }

    @Override
    public String toString() {
        return "Rubro{" + "idRubro=" + idRubro + ", nombreRubro=" + nombreRubro + '}';
    }
}
