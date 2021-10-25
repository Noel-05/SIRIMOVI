/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.domain.InformacionComercial;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author rafae
 */
public class InformacionComercialRowMapper implements RowMapper<InformacionComercial>{
 
    @Override
    public InformacionComercial mapRow(ResultSet rs, int i) throws SQLException {
        InformacionComercial infCom = new InformacionComercial();
        
        infCom.setIdInformacionComercial(rs.getInt("idInformacionComercial"));
        infCom.setIdInformacionOrganizacional(rs.getInt("idInformacionOrganizacional"));
        infCom.setDepartamentosDeComercioInterior(rs.getString("departamentosDeComercioInterior"));
        infCom.setPaisesDeComercioExterior(rs.getString("paisesDeComercioExterior"));
        infCom.setEmpresasSocias(rs.getString("empresasSocias"));
        
        return infCom;
    }
}
