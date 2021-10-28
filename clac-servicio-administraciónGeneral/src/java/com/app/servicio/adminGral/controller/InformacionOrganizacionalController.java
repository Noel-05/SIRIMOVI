
package com.app.servicio.adminGral.controller;

/**
 *
 * @author cg11017
 */
import com.app.servicio.adminGral.domain.InformacionOrganizacional;
import com.app.servicio.adminGral.domain.InformacionOrganizacionalList;
import com.app.servicio.adminGral.service.InformacionOrganizacionalServicio;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class InformacionOrganizacionalController {
    
    // Declaramos que utilizaremos el servicio de Persona
    @Resource(name="informacionOrganizacionalServicio")
    private InformacionOrganizacionalServicio informacionOrganizacionalServicio;
    
    
    // CREAR
    // Metodo para agregar persona
    @RequestMapping(value="/informacionOrganizacionalAdd", method = RequestMethod.POST, headers="Accept=application/json, application/xml")
    public @ResponseBody InformacionOrganizacional addInformacionOrganizacional(@RequestBody InformacionOrganizacional persona){
    
        System.out.println("Se ha recibido la nueva persona por Request");
        
        return informacionOrganizacionalServicio.add(persona);
    }
    
    
    // EDITAR
    // Metodo para editar una persona
    @RequestMapping(value="/informacionOrganizacionalUp/{id}", method = RequestMethod.PUT, headers="Accept=application/json, application/xml")
    public @ResponseBody String updateInformacionOrganizacional(@PathVariable("idInformacionOrganizacional") int id, @RequestBody InformacionOrganizacional informacionOrganizacional){
        
        informacionOrganizacional.setIdInfOrganizacional(id);   
        
        return informacionOrganizacionalServicio.edit(informacionOrganizacional).toString();
    }
    
    
    
     // LISTAR
    // Metodo para recuperar todas las personas de la BD
    @RequestMapping(value="/informacionOrganizacional", method=RequestMethod.GET, headers="Accept=application/json, application/xml")
    private @ResponseBody InformacionOrganizacionalList getInformacionOrganizacional(){
        
        InformacionOrganizacionalList result = new InformacionOrganizacionalList();
        
        result.setData(informacionOrganizacionalServicio.getAll());
        
        System.out.println(result);
        
        return result;
    }
    
    
    
    
}
