
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.connect.Conexion;
import com.app.servicio.adminGral.domain.Persona;
import com.app.servicio.adminGral.domain.PruebaPersona;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service("pruebaPersonaServicio")
public class PruebaPersonaServicio {
    
    // Conexión a la BD.
    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    
    // Variables a utilizar
    private List<PruebaPersona> personas = new ArrayList<PruebaPersona>();
    List datos;
    
    
   // LISTAR todas las personas
    public List<PruebaPersona> getAll(){
        System.out.println("Recuperando todas las personas de la BD.");
        
        String sql = "SELECT * FROM registro.persona AS P INNER JOIN registro.pruebapersona AS PP ON P.id = PP.idPersona;";
        
        personas = this.jdbcTemplate.query(sql, new PruebaPersonaRowMapper());
        
        System.out.println(personas);
        
        return personas;
    }
    
    // CREAR persona
    public PruebaPersona add(PruebaPersona pruebaPersona){
        System.out.println("Insertando nueva persona (PRUEBA).");
        
        try{
            String sql = "INSERT INTO registro.pruebapersona(nombreMascota, cantMascota, idPersona) VALUES(?, ?, ?)";
            
            this.jdbcTemplate.update(sql, pruebaPersona.getNombreMascota(), pruebaPersona.getCantidadMascota(), pruebaPersona.getPersona());
            
            System.out.println("Persona (PRUEBA) Insertada Correctamente. ");
            
            return pruebaPersona;
            
        }catch(Exception e){
            System.out.println(e);
            
            return null;
        }
    }
    
}
