
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.domain.InformacionFinanciera;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class InformacionFinancieraRowMapper2 implements RowMapper<InformacionFinanciera>{
    
    @Override
    public InformacionFinanciera mapRow(ResultSet rs, int i) throws SQLException{
        InformacionFinanciera info = new InformacionFinanciera();
        
        info.setIdinformacionFinanciera(rs.getInt("idInformacionFinanciera"));
        info.setIdinformacionOrganizacional(rs.getInt("idInformacionOrganizacional"));
        info.setNombreNegocio(rs.getString("nombreNegocio"));
        info.setRangoSalariosEmpleados(rs.getString("rangoSalarioEmpleados"));
        info.setSaldoDeudasActual(rs.getFloat("saldoDeudasActual"));
        info.setSaldoLiquidez(rs.getFloat("saldoLiquidez"));
        
        return info;
    } 
}
