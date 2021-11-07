
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.connect.Conexion;
import com.app.servicio.adminGral.domain.Rol;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("rolServicio")
public class RolServicio {
    // Conexión a la BD.
    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    
    // Variables a utilizar
    private List<Rol> roles = new ArrayList<Rol>();
    List datos;
    
    
   // LISTAR todas las personas
    public List<Rol> getAll(){
        System.out.println("Recuperando todos los roles de la BD.");
        
        String sql = "SELECT * FROM registro.rol;";
        
        roles = this.jdbcTemplate.query(sql, new RolRowMapper());
        
        System.out.println(roles);
        
        return roles;
    }
    
}
