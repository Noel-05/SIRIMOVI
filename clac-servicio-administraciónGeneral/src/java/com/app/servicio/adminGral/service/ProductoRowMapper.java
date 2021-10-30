/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.domain.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ProductoRowMapper implements RowMapper<Producto>{

    @Override
    public Producto mapRow(ResultSet rs, int i) throws SQLException {
        Producto produ = new Producto();
        
        produ.setId(rs.getInt("idProducto"));
        produ.setIdInformacionComercial(rs.getInt("idInformacionComercial"));
        produ.setNombre(rs.getString("nombreProducto"));
        produ.setPrecioVenta(rs.getFloat("precioVenta"));
        produ.setPrecioFabricacion(rs.getFloat("precioFabricacion"));
        
        return produ;
    }
    
}

