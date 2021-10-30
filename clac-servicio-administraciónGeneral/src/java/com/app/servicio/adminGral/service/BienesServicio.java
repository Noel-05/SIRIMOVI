
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
 
    
    // LISTAR todos los Bienes
    public List<Bienes> getAll(){
        System.out.println("Recuperando todos los bienes de la BD.");
        
        String sql = "SELECT * FROM registro.bienes";
        
        bienes = this.jdbcTemplate.query(sql, new BienesRowMapper());
        
        System.out.println(bienes);
        
        return bienes;
    }
    
    
    // CREAR Bien
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