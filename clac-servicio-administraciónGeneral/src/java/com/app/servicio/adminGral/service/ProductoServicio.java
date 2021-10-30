/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.connect.Conexion;
import com.app.servicio.adminGral.domain.Producto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("productoServicio")
public class ProductoServicio {
    
    // Conexión a la BD.
    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    
    // Variables a utilizar
    private List<Producto> productos = new ArrayList<Producto>();
    List datos;
       
    
    // LISTAR todas las personas
    public List<Producto> getAll(){
        System.out.println("Recuperando todos las servicios de la BD.");
        
        String sql = "SELECT * FROM registro.productos";
        
        productos = this.jdbcTemplate.query(sql, new ProductoRowMapper());
        
        System.out.println(productos);
        
        return productos;
    }
    
    
    // CREAR Producto
    public Producto add(Producto producto){
        System.out.println("Insertando nuevo Producto");
        
        try{
            String sql = "INSERT INTO registro.productos(idInformacionComercial, nombreProducto, precioVenta, precioFabricacion) VALUES(?, ?, ?, ?)";
            
            this.jdbcTemplate.update(sql, producto.getIdInformacionComercial(), producto.getNombre(), producto.getPrecioVenta(), producto.getPrecioFabricacion());
            
            System.out.println("Producto Insertado Correctamente. ");
            
            return producto;
            
        }catch(Exception e){
            System.out.println(e);
            
            return null;
        }
    }
    
    
    //CONSULTAR produto
    public Producto getByID(int id){
        System.out.println("Recuperando producto con ID: " + id);
        
        String sql = "SELECT * FROM registro.productos WHERE idProducto = ?";
        
        return this.jdbcTemplate.queryForObject(sql, new ProductoRowMapper(), id);
    }
    
    // EDITAR Producto
    public Boolean edit(Producto producto){
        System.out.println("Editando producto con ID: " + producto.getId());
        
        try{
            String sql = "UPDATE registro.productos SET idInformacionComercial=?, nombreProducto=?, precioVenta=?, precioFabricacion WHERE Id = ?";
            
            this.jdbcTemplate.update(sql, producto.getIdInformacionComercial(), producto.getNombre(), producto.getPrecioVenta(),producto.getPrecioFabricacion(), producto.getId());
            
            System.out.println("Producto Actualizado Correctamente.");
            
            return true;
            
        }catch(Exception e){
            System.out.println(e);
            
            return false;
        }
    }
      
}
