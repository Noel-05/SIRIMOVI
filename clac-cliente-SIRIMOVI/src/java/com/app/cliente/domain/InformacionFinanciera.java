
package com.app.cliente.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="inFinanciera")
public class InformacionFinanciera {
    int idinformacionFinanciera;
    int idinformacionOrganizacional;
    String rangoSalariosEmpleados;
    float saldoDeudasActual;
    float saldoLiquidez;

    public int getIdinformacionFinanciera() {
        return idinformacionFinanciera;
    }

    public void setIdinformacionFinanciera(int idinformacionFinanciera) {
        this.idinformacionFinanciera = idinformacionFinanciera;
    }

    public int getIdinformacionOrganizacional() {
        return idinformacionOrganizacional;
    }

    public void setIdinformacionOrganizacional(int idinformacionOrganizacional) {
        this.idinformacionOrganizacional = idinformacionOrganizacional;
    }

    public String getRangoSalariosEmpleados() {
        return rangoSalariosEmpleados;
    }

    public void setRangoSalariosEmpleados(String rangoSalariosEmpleados) {
        this.rangoSalariosEmpleados = rangoSalariosEmpleados;
    }

    public float getSaldoDeudasActual() {
        return saldoDeudasActual;
    }

    public void setSaldoDeudasActual(float saldoDeudasActual) {
        this.saldoDeudasActual = saldoDeudasActual;
    }

    public float getSaldoLiquidez() {
        return saldoLiquidez;
    }

    public void setSaldoLiquidez(float saldoLiquidez) {
        this.saldoLiquidez = saldoLiquidez;
    }
    
    @Override
    public String toString(){
        return "Persona{" + "id informacion financiera=" + idinformacionFinanciera + ", id informacion organizacional=" + idinformacionOrganizacional + 
                ", rango de salarios de los empleados=" + rangoSalariosEmpleados + ", saldo de liquidez=" + saldoLiquidez + ", saldo de deuda actual=" + saldoDeudasActual + '}';
    }

}
