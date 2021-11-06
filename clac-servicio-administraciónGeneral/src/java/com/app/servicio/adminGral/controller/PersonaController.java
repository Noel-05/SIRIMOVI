
package com.app.servicio.adminGral.controller;


import com.app.servicio.adminGral.domain.Persona;
import com.app.servicio.adminGral.domain.PersonaList;
import com.app.servicio.adminGral.service.PersonaServicio;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonaController {
    
    // Declaramos que utilizaremos el servicio de Persona
    @Resource(name="personaServicio")
    private PersonaServicio personaServicio;
    
    
    // LISTAR
    // Metodo para recuperar todas las personas de la BD
    @RequestMapping(value="/personas", method=RequestMethod.GET, headers="Accept=application/json, application/xml")
    private @ResponseBody PersonaList getPersonas(){
        
        PersonaList result = new PersonaList();
        
        result.setData(personaServicio.getAll());
        
        System.out.println(result);
        
        return result;
    }
    
    
    // CONSULTAR
    // Metodo para recuperar una persona por su ID
    @RequestMapping(value="/personas/{id}", method = RequestMethod.GET, headers="Accept=application/json, application/xml")
    private @ResponseBody Persona getPersonaById(@PathVariable("id") int id){
        
        return personaServicio.getByID(id);
    }
    
    
    // CREAR
    // Metodo para agregar persona
    @RequestMapping(value="/personasAdd", method = RequestMethod.POST, headers="Accept=application/json, application/xml")
    public @ResponseBody Persona addPersona(@RequestBody Persona persona){
    
        System.out.println("Se ha recibido la nueva persona por Request");
        
        return personaServicio.add(persona);
    }
    
    
    // EDITAR
    // Metodo para editar una persona
    @RequestMapping(value="/personasUp/{id}", method = RequestMethod.PUT, headers="Accept=application/json, application/xml")
    public @ResponseBody String updatePersona(@PathVariable("id") int id, @RequestBody Persona persona){
        
        persona.setId(id);
        
        return personaServicio.edit(persona).toString();
    }
    
    
    // ELIMINAR
    // Metodo para eliminar una persona
    @RequestMapping(value="/personasDel/{id}", method = RequestMethod.DELETE, headers="Accept=application/json, application/xml")
    private @ResponseBody String deletPerson(@PathVariable("id") int id){
        System.out.println("Se ha eliminado el registro de ID: " + id);
        
        return personaServicio.delete(id).toString();
    }
    
}
