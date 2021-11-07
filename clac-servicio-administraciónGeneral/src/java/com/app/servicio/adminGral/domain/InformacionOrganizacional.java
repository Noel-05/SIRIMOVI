
package com.app.servicio.adminGral.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="informationorganizational")
public class InformacionOrganizacional {
    int idInfOrganizacional;
    int idRubro;
    String nombreRubro;
    String nombreNegocio;
    int cantEmpleados;
    String direccionNegocio;
    int cantSucursales;

    public int getIdInfOrganizacional() {
        return idInfOrganizacional;
    }

    public void setIdInfOrganizacional(int idInfOrganizacional) {
        this.idInfOrganizacional = idInfOrganizacional;
    }

    public int getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(int idRubro) {
        this.idRubro = idRubro;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public int getCantEmpleados() {
        return cantEmpleados;
    }

    public void setCantEmpleados(int cantEmpleados) {
        this.cantEmpleados = cantEmpleados;
    }

    public String getDireccionNegocio() {
        return direccionNegocio;
    }

    public void setDireccionNegocio(String direccionNegocio) {
        this.direccionNegocio = direccionNegocio;
    }

    public int getCantSucursales() {
        return cantSucursales;
    }

    public void setCantSucursales(int cantSucursales) {
        this.cantSucursales = cantSucursales;
    }

    public String getNombreRubro() {
        return nombreRubro;
    }

    public void setNombreRubro(String nombreRubro) {
        this.nombreRubro = nombreRubro;
    }
    
    @Override
    public String toString() {
        return "InformacionOrganizacional{" + "idInfOrganizacional=" + idInfOrganizacional + ", idRubro=" + idRubro + ", nombreNegocio=" + nombreNegocio + ", cantEmpleados=" + cantEmpleados + ", direccionNegocio=" + direccionNegocio + ", cantSucursales=" + cantSucursales + '}';
    }
    
}
