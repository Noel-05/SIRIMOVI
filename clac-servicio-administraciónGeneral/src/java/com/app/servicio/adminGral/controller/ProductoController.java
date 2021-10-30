/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.servicio.adminGral.controller;

import com.app.servicio.adminGral.domain.Producto;
import com.app.servicio.adminGral.domain.ProductoList;
import com.app.servicio.adminGral.service.ProductoServicio;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductoController {
    
    // Declaramos que utilizaremos el servicio de Producto
    @Resource(name="productoServicio")
    private ProductoServicio productoServicio;
    
    
    
    // LISTAR
    // Metodo para recuperar todas las personas de la BD
    @RequestMapping(value="/productos", method=RequestMethod.GET, headers="Accept=application/json, application/xml")
    private @ResponseBody ProductoList getProductos(){
        
        ProductoList result = new ProductoList();
        
        result.setData(productoServicio.getAll());
        
        System.out.println(result);
        
        return result;
    }
   
    
    
    // CREAR
    // Metodo para agregar Producto
    @RequestMapping(value="/addProducto", method = RequestMethod.POST, headers="Accept=application/json, application/xml")
    public @ResponseBody Producto addProducto(@RequestBody Producto producto){
    
        System.out.println("Se ha recibido el nuevo Producto por Request");
        
        return productoServicio.add(producto);
    }
    

    // CONSULTAR
    // Metodo para recuperar una persona por su ID
    @RequestMapping(value="/productos/{id}", method = RequestMethod.GET, headers="Accept=application/json, application/xml")
    private @ResponseBody Producto getProductoById(@PathVariable("id") int id){
        
        return productoServicio.getByID(id);
    }
    
    // EDITAR
    // Metodo para editar una persona
    @RequestMapping(value="/productosUp/{id}", method = RequestMethod.PUT, headers="Accept=application/json, application/xml")
    public @ResponseBody String updateProducto(@PathVariable("id") int id, @RequestBody Producto producto){
        
        producto.setId(id);
        
        return productoServicio.edit(producto).toString();
    }
    
}