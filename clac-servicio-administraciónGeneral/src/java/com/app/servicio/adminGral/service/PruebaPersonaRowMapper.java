
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.domain.Persona;
import com.app.servicio.adminGral.domain.PruebaPersona;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PruebaPersonaRowMapper implements RowMapper<PruebaPersona>{
    public PruebaPersona mapRow(ResultSet rs, int i) throws SQLException {
        PruebaPersona pers = new PruebaPersona();
        pers.setId(rs.getInt("idPruebaPersona"));
        pers.setNombreMascota(rs.getString("nombreMascota"));
        pers.setCantidadMascota(rs.getString("cantMascota"));
        pers.setPersona(rs.getInt("idPersona"));
        
        //pers.setPersona(rs.getObject("idPersona", Persona.class));
        
        /*pers.setPersona(rs.getInt("idPersona"));
        pers.setNombres(rs.getString("Nombres"));
        pers.setCorreos(rs.getString("Correo"));
        pers.setNacionalidad(rs.getString("Nacionalidad"));*/
        
        return pers;
    }
}
