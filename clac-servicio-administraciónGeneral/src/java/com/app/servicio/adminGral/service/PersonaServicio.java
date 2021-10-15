
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.connect.Conexion;
import com.app.servicio.adminGral.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("personaServicio")
public class PersonaServicio {
    
    // Conexión a la BD.
    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    
    // Variables a utilizar
    private List<Persona> personas = new ArrayList<Persona>();
    List datos;
    
    
    // LISTAR todas las personas
    public List<Persona> getAll(){
        System.out.println("Recuperando todas las personas de la BD.");
        
        String sql = "SELECT * FROM registro.persona";
        
        personas = this.jdbcTemplate.query(sql, new PersonaRowMapper());
        
        System.out.println(personas);
        
        return personas;
    }
    
    
    // CONSULTAR persona por ID
    public Persona getByID(int id){
        System.out.println("Recuperando persona con ID: " + id);
        
        String sql = "SELECT * FROM registro.persona WHERE Id = ?";
        
        return this.jdbcTemplate.queryForObject(sql, new PersonaRowMapper(), id);
    }
    
    
    // CREAR persona
    public Persona add(Persona persona){
        System.out.println("Insertando nueva persona.");
        
        try{
            String sql = "INSERT INTO registro.persona(Nombres, Correo, Nacionalidad) VALUES(?, ?, ?)";
            
            this.jdbcTemplate.update(sql, persona.getNom(), persona.getCorreo(), persona.getNacio());
            
            System.out.println("Persona Insertada Correctamente. ");
            
            return persona;
            
        }catch(Exception e){
            System.out.println(e);
            
            return null;
        }
    }
    
    
    // EDITAR persona
    public Boolean edit(Persona persona){
        System.out.println("Editando persona con ID: " + persona.getId());
        
        try{
            String sql = "UPDATE registro.persona SET Nombres=?, Correo=?, Nacionalidad=? WHERE Id = ?";
            
            this.jdbcTemplate.update(sql, persona.getNom(), persona.getCorreo(), persona.getNacio(), persona.getId());
            
            System.out.println("Persona Actualizada Correctamente.");
            
            return true;
            
        }catch(Exception e){
            System.out.println(e);
            
            return false;
        }
    }
    
    
    // ELIMINAR persona
    public Boolean delete(int id){
        System.out.println("Eliminando persona con ID: " + id);
        
        try{
            String sql = "DELETE FROM registro.persona WHERE Id = " + id;
            
            this.jdbcTemplate.update(sql);
            
            System.out.println("Persona Eliminada Correctamente");
            
            return true;
            
        }catch(Exception e){
            System.out.println(e);
            
            return false;
        }
    }
    
}
