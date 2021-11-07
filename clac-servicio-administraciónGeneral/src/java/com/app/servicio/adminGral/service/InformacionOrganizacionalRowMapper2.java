
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.domain.InformacionOrganizacional;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class InformacionOrganizacionalRowMapper2 implements RowMapper<InformacionOrganizacional> {
    
    @Override
    public InformacionOrganizacional mapRow(ResultSet rs, int i) throws SQLException {
            
        InformacionOrganizacional infOrg = new InformacionOrganizacional();
        
        infOrg.setIdInfOrganizacional(rs.getInt("idInformacionOrganizacional"));
        infOrg.setIdRubro(rs.getInt("idRubro"));
        infOrg.setNombreRubro(rs.getString("nombreRubro"));
        infOrg.setNombreNegocio(rs.getString("nombreNegocio"));
        infOrg.setCantEmpleados(rs.getInt("cantidadEmpleados"));
        infOrg.setDireccionNegocio(rs.getString("direccionNegocio"));
        infOrg.setCantSucursales(rs.getInt("cantidadSucursales"));
     
        return infOrg;
    }
    
}
