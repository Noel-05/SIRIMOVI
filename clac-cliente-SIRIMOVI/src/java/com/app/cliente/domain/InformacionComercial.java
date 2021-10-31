
package com.app.cliente.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="commercialinformation")
public class InformacionComercial {
    
    int idInformacionComercial;
    int idInformacionOrganizacional;
    String departamentosDeComercioInterior;
    String paisesDeComercioExterior;
    String empresasSocias;

    public int getIdInformacionComercial() {
        return idInformacionComercial;
    }

    public void setIdInformacionComercial(int idInformacionComercial) {
        this.idInformacionComercial = idInformacionComercial;
    }

    public int getIdInformacionOrganizacional() {
        return idInformacionOrganizacional;
    }

    public void setIdInformacionOrganizacional(int idInformacionOrganizacional) {
        this.idInformacionOrganizacional = idInformacionOrganizacional;
    }

    public String getDepartamentosDeComercioInterior() {
        return departamentosDeComercioInterior;
    }

    public void setDepartamentosDeComercioInterior(String departamentosDeComercioInterior) {
        this.departamentosDeComercioInterior = departamentosDeComercioInterior;
    }

    public String getPaisesDeComercioExterior() {
        return paisesDeComercioExterior;
    }

    public void setPaisesDeComercioExterior(String paisesDeComercioExterior) {
        this.paisesDeComercioExterior = paisesDeComercioExterior;
    }

    public String getEmpresasSocias() {
        return empresasSocias;
    }

    public void setEmpresasSocias(String empresasSocias) {
        this.empresasSocias = empresasSocias;
    }
    
    @Override
    public String toString() {
        return "Informacion Comercial{" + "id Comercial=" + idInformacionComercial + ", id Organizacional=" + idInformacionOrganizacional + ", Departamento de Comercio Interior=" + departamentosDeComercioInterior + ", Paises de Comercio Exterior=" + paisesDeComercioExterior+ ", Empresa Socias=" +empresasSocias + '}';
    }
}
