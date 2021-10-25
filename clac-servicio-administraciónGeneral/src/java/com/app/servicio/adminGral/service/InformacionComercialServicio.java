/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.connect.Conexion;
import com.app.servicio.adminGral.domain.InformacionComercial;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafae
 */
@Service("informacionComercialServicio")
public class InformacionComercialServicio {
    
    // Conexión a la BD.
    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    
    // Variables a utilizar
    private List<InformacionComercial> informacionComercial = new ArrayList<InformacionComercial>();
    List datos;
    
    
    // LISTAR todas las personas
    public List<InformacionComercial> getAll(){
        System.out.println("Recuperando todas la Informacion Comercial de la BD.");
        
        String sql = "SELECT * FROM registro.informacioncomercial";
        
        informacionComercial = this.jdbcTemplate.query(sql, new  InformacionComercialRowMapper());
        
        System.out.println(informacionComercial);
        
        return informacionComercial;
    }
    
    
    // CONSULTAR persona por ID
    public InformacionComercial getByID(int id){
        System.out.println("Recuperando persona con ID: " + id);
        
        String sql = "SELECT * FROM registro.informacioncomercial WHERE Id = ?";
        
        return this.jdbcTemplate.queryForObject(sql, new  InformacionComercialRowMapper(), id);
    }
    
    
    // CREAR persona
    public InformacionComercial add(InformacionComercial informacionComercial){
        System.out.println("Insertando nueva Informacion Comercial.");
        
        try{
            String sql = "INSERT INTO registro.informacioncomercial(departamentosDeComercioInterior, paisesDeComercioExterior, empresasSocias) VALUES(?, ?, ?)";
            
            this.jdbcTemplate.update(sql, informacionComercial.getIdInformacionComercial(), informacionComercial.getPaisesDeComercioExterior(), informacionComercial.getEmpresasSocias());
            
            System.out.println("Informacion Comercial Insertada Correctamente. ");
            
            return informacionComercial;
            
        }catch(Exception e){
            System.out.println(e);
            
            return null;
        }
    }
    
    
    // EDITAR persona
    public Boolean edit(InformacionComercial informacionComercial){
        System.out.println("Editando Informacion Comercial con ID: " + informacionComercial.getIdInformacionComercial());
        
        try{
            String sql = "UPDATE registro.informacioncomercial SET departamentosDeComercioInterior=?, paisesDeComercioExterior=?, empresasSocias=? WHERE Id = ?";
            
            this.jdbcTemplate.update(sql, informacionComercial.getDepartamentosDeComercioInterior(), informacionComercial.getPaisesDeComercioExterior(), informacionComercial.getEmpresasSocias(), informacionComercial.getIdInformacionComercial());
            
            System.out.println("Persona Actualizada Correctamente.");
            
            return true;
            
        }catch(Exception e){
            System.out.println(e);
            
            return false;
        }
    }
}
