
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.domain.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PersonaRowMapper implements RowMapper<Persona>{

    @Override
    public Persona mapRow(ResultSet rs, int i) throws SQLException {
        Persona pers = new Persona();
        
        pers.setId(rs.getInt("Id"));
        pers.setNom(rs.getString("Nombres"));
        pers.setCorreo(rs.getString("Correo"));
        pers.setNacio(rs.getString("Nacionalidad"));
        
        return pers;
    }
    
}
