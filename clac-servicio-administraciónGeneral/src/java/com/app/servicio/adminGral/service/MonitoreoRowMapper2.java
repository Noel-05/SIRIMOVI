
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.domain.Monitoreo;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class MonitoreoRowMapper2 implements RowMapper<Monitoreo>{
    @Override
    public Monitoreo mapRow(ResultSet rs, int i) throws SQLException {
        Monitoreo monitoreo = new Monitoreo();
        
        monitoreo.setIdMonitoreo(rs.getInt("idMonitoreo"));
        monitoreo.setIdInfo(rs.getInt("idInformacionOrganizacional"));
        monitoreo.setNombreNegocio(rs.getString("nombreNegocio"));
        monitoreo.setCantidadProduccion(rs.getInt("cantidadProduccion"));
        monitoreo.setCantidadPerdidas(rs.getInt("cantidadPerdidas"));
        monitoreo.setTotalVentas(rs.getInt("totalVentas"));
        monitoreo.setGanancia(rs.getInt("ganancia"));      
        return monitoreo;
    }
}
