
package com.app.servicio.adminGral.controller;

import com.app.servicio.adminGral.domain.Bienes;
import com.app.servicio.adminGral.domain.BienesList;
import com.app.servicio.adminGral.service.BienesServicio;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BienesController {
    
    // Declaramos que utilizaremos el servicio de Bienes
    @Resource(name="bienesServicio")
    private BienesServicio personaServicio;
    
    // LISTAR
    // Metodo para recuperar todas las personas de la BD
    @RequestMapping(value="/bienes", method=RequestMethod.GET, headers="Accept=application/json, application/xml")
    private @ResponseBody BienesList getBienes(){
        
        BienesList result = new BienesList();
        
        result.setData(personaServicio.getAll());
        
        System.out.println(result);
        
        return result;
    }
    
    // CREAR
    // Metodo para agregar persona
    @RequestMapping(value="/bienesAdd", method = RequestMethod.POST, headers="Accept=application/json, application/xml")
    public @ResponseBody Bienes adBienes(@RequestBody Bienes bien){
    
        System.out.println("Se ha recibido el nuevo bien por Request");
        
        return personaServicio.add(bien);
    }
    
  
}