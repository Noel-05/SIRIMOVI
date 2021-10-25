
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.connect.Conexion;
import com.app.servicio.adminGral.domain.Bienes;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("bienesServicio")
public class BienesServicio {
    
    // Conexión a la BD.
    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    
    // Variables a utilizar
    private List<Bienes> bienes = new ArrayList<Bienes>();
    List datos;
 
  
    
    // CREAR persona
    public Bienes add(Bienes bienes){
        System.out.println("Insertando nuevo bien.");
        
        try{
            String sql = "INSERT INTO registro.bienes(idInformacionFinanciera, nombreBien, cantidadBien) VALUES(?, ?, ?)";
            
            this.jdbcTemplate.update(sql, bienes.getIdInformacionFinanciera(), bienes.getNombreBien(), bienes.getCantidadBien());
            
            System.out.println("Bien Insertado Correctamente. ");
            
            return bienes;
            
        }catch(Exception e){
            System.out.println(e);
            
            return null;
        }
    }
   
}
