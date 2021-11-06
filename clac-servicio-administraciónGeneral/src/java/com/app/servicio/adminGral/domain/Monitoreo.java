
package com.app.servicio.adminGral.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="monitor")
public class Monitoreo {
    int idMonitoreo;
    int idInfo;
    int cantidadProduccion;
    int cantidadPerdidas;
    int totalVentas;
    int ganancia;

    public int getCantidadPerdidas() {
        return cantidadPerdidas;
    }

    public void setCantidadPerdidas(int cantidadPerdidas) {
        this.cantidadPerdidas = cantidadPerdidas;
    }

    public int getIdMonitoreo() {
        return idMonitoreo;
    }

    public void setIdMonitoreo(int idMonitoreo) {
        this.idMonitoreo = idMonitoreo;
    }

    public int getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(int idInfo) {
        this.idInfo = idInfo;
    }

    public int getCantidadProduccion() {
        return cantidadProduccion;
    }

    public void setCantidadProduccion(int cantidadProduccion) {
        this.cantidadProduccion = cantidadProduccion;
    }

    public int getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(int totalVentas) {
        this.totalVentas = totalVentas;
    }

    public int getGanancia() {
        return ganancia;
    }

    public void setGanancia(int ganancia) {
        this.ganancia = ganancia;
    }
    @Override
    public String toString() {
        return "Monitoreo:" + "\nid Monitoreo: " + idMonitoreo + "\nId Informacion: " + idInfo + "\nCantidad de Produccion: " + cantidadProduccion + "\nCantidad de perdidas:" + cantidadPerdidas + "\nTotal de ventas: "+totalVentas+"\nGanancias: "+ganancia+'}';
    }
}
