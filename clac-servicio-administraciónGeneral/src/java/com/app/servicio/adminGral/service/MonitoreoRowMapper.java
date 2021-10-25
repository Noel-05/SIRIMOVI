
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.domain.Monitoreo;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class MonitoreoRowMapper implements RowMapper<Monitoreo>{
    @Override
    public Monitoreo mapRow(ResultSet rs, int i) throws SQLException {
        Monitoreo monitoreo = new Monitoreo();
        
        monitoreo.setIdMonitoreo(rs.getInt("Id"));
        monitoreo.setIdInfo(rs.getInt("id Informacion Organizacional"));
        monitoreo.setCantidadProduccion(rs.getInt("Cantidad Produccion"));
        monitoreo.setCantidadPerdidas(rs.getInt("Cantidad Perdidas"));
        monitoreo.setTotalVentas(rs.getInt("Total Ventas"));
        monitoreo.setGanancia(rs.getInt("Ganancias"));      
        return monitoreo;
    }
}
