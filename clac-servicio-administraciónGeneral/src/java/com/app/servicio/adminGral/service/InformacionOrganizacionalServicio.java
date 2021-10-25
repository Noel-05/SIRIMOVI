/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.servicio.adminGral.service;

import java.util.ArrayList;
import java.util.List;

import com.app.servicio.adminGral.connect.Conexion;
import com.app.servicio.adminGral.domain.InformacionOrganizacional;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Service;

/**
 *
 * @author cg11017
 */
@Service("InformacionOrganizacional")
public class InformacionOrganizacionalServicio {
    
     // Conexión a la BD.
    Conexion con = new Conexion();
    
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    
     // Variables a utilizar
    private List<InformacionOrganizacional> informacionOrganizacional = new ArrayList<InformacionOrganizacional>();
    List datos;
    
    
    
    
    // CREAR InformacionOrganizacional
    public InformacionOrganizacional add(InformacionOrganizacional informacionOrganizacional){
        System.out.println("Insertando nueva informacion organizacional.");
        
        try{
            String sql = "INSERT INTO registro.informacionorganizacional(idIformacionOrganizacional, idRubro, nombreNegocio,"
                    + " cantidadEmpleados, direccionNegocio, cantidadSucursales ) VALUES(?, ?, ?, ?, ?, ?)";
            
            this.jdbcTemplate.update(sql, informacionOrganizacional.getIdInfOrganizacional(), informacionOrganizacional.getIdRubro(),
                    informacionOrganizacional.getNombreNegocio(), informacionOrganizacional.getCantEmpleados(), 
                    informacionOrganizacional.getDireccionNegocio(), informacionOrganizacional.getCantSucursales());
            
            System.out.println("Información Organizacional Insertada Correctamente. ");
            
            return informacionOrganizacional;
            
        }catch(Exception e){
            System.out.println(e);
            
            return null;
        }
    }
    
 
      // EDITAR InformacionOrganizacional
    public Boolean edit(InformacionOrganizacional informacionOrganizacional){
        System.out.println("Editando información organizacional con ID: " + informacionOrganizacional.getIdInfOrganizacional());
        
        try{
            String sql = "UPDATE registro.informacionorganizacional SET idRubro=?, "
                    + "nombreNegocio=?, cantidadEmpleados=?, direccionNegocio=?, cantidadSucursales =?  WHERE idIformacionOrganizacional = ?";
            
            this.jdbcTemplate.update(sql, informacionOrganizacional.getIdInfOrganizacional(), informacionOrganizacional.getIdRubro(), 
                                          informacionOrganizacional.getNombreNegocio(), informacionOrganizacional.getCantEmpleados(),
                                          informacionOrganizacional.getDireccionNegocio(), informacionOrganizacional.getCantSucursales());
                               
            
            System.out.println("Informacion Organizacional Actualizada Correctamente.");
            
            return true;
            
        }catch(Exception e){
            System.out.println(e);
            
            return false;
        }
    }
    
   
    
    // LISTAR InformacionOrganizacional
    public List<InformacionOrganizacional> getAll(){
        System.out.println("Recuperando todos los datos de información organizacional de la BD.");
        
        String sql = "SELECT * FROM registro.informacionorganizacional";
        
      informacionOrganizacional = this.jdbcTemplate.query(sql, new InformacionOrganizacionalRowMapper());
        
        System.out.println(informacionOrganizacional);
        
        return informacionOrganizacional;
    }
    
    
  
    
    
    }
    
    
    
    

