
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.domain.Bienes;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BienesRowMapper implements RowMapper<Bienes>{

    @Override
    public Bienes mapRow(ResultSet rs, int i) throws SQLException {
        Bienes bienes = new Bienes();
        
        bienes.setIdBien(rs.getInt("idBien"));
        bienes.setIdInformacionFinanciera(rs.getInt("idInformacionFinanciera"));
        bienes.setNombreBien(rs.getString("nombreBien"));
        bienes.setCantidadBien(rs.getInt("cantidadBien"));
        
        return bienes;
    }
    
}
