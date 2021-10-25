
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.domain.InformacionOrganizacional;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;



/**
 *
 * @author cg11017
 */
public class InformacionOrganizacionalRowMapper implements RowMapper<InformacionOrganizacional> {
    
     @Override
        public InformacionOrganizacional mapRow(ResultSet rs, int i) throws SQLException {
            
        InformacionOrganizacional infoOrganizacional = new InformacionOrganizacional();
        
        infoOrganizacional.setIdInfOrganizacional(rs.getInt("idInformacionOrganizacional"));
        infoOrganizacional.setIdRubro(rs.getInt("idRubro"));
        infoOrganizacional.setNombreNegocio(rs.getString("nombreNegocio"));
        infoOrganizacional.setCantEmpleados(rs.getInt("cantidadEmpleados"));
        infoOrganizacional.setDireccionNegocio(rs.getString("direccionNegocio"));
        infoOrganizacional.setCantSucursales(rs.getInt("cantidadSucursales"));
        
     
        return infoOrganizacional;
    }
    
}
