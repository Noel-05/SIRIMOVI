
package com.app.servicio.adminGral.controller;

import com.app.servicio.adminGral.domain.Persona;
import com.app.servicio.adminGral.domain.PersonaList;
import com.app.servicio.adminGral.domain.PruebaPersona;
import com.app.servicio.adminGral.domain.PruebaPersonaList;
import com.app.servicio.adminGral.service.PruebaPersonaServicio;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PruebaPersonaController {
    // Declaramos que utilizaremos el servicio de Persona
    @Resource(name="pruebaPersonaServicio")
    private PruebaPersonaServicio pruebaPersonaServicio;
    
    
    // LISTAR
    // Metodo para recuperar todas las personas de la BD
    @RequestMapping(value="/pruebaPersonas", method=RequestMethod.GET, headers="Accept=application/json, application/xml")
    private @ResponseBody PruebaPersonaList getPersonas(){
        
        PruebaPersonaList result = new PruebaPersonaList();
        
        result.setData(pruebaPersonaServicio.getAll());
        
        System.out.println(result);
        
        return result;
    }
    
    // CREAR
    // Metodo para agregar persona
    @RequestMapping(value="/pruebaPersonasAdd", method = RequestMethod.POST, headers="Accept=application/json, application/xml")
    public @ResponseBody PruebaPersona addPersona(@RequestBody PruebaPersona pruebaPersona){
    
        System.out.println("Se ha recibido la nueva persona por Request (PRUEBA)");
        
        return pruebaPersonaServicio.add(pruebaPersona);
    }
}
