
package com.app.servicio.adminGral.controller;

import com.app.servicio.adminGral.domain.InformacionComercial;
import com.app.servicio.adminGral.domain.InformacionComercialList;
import com.app.servicio.adminGral.service.InformacionComercialServicio;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InformacionComercialController {
    
    @Resource(name="informacionComercialServicio")
    private InformacionComercialServicio informacionComercialServicio;
    
    // LISTAR
    // Metodo para recuperar todas las personas de la BD
    @RequestMapping(value="/informacionComercial", method=RequestMethod.GET, headers="Accept=application/json, application/xml")
    private @ResponseBody InformacionComercialList getInformacionComercial(){
        
        InformacionComercialList result = new InformacionComercialList();
        
        result.setData(informacionComercialServicio.getAll());
        
        System.out.println(result);
        
        return result;
    }
    
    
    // CONSULTAR
    // Metodo para recuperar una persona por su ID
    @RequestMapping(value="/informacionComercial/{id}", method = RequestMethod.GET, headers="Accept=application/json, application/xml")
    private @ResponseBody InformacionComercial getInformacionComercialById(@PathVariable("id") int id){
        
        return informacionComercialServicio.getByID(id);
    }
    
    
    // CREAR
    // Metodo para agregar persona
    @RequestMapping(value="/informacionComercialAdd", method = RequestMethod.POST, headers="Accept=application/json, application/xml")
    public @ResponseBody InformacionComercial addInformacionComercial(@RequestBody InformacionComercial informacionComercial){
    
        System.out.println("Se ha recibido la nueva Informacion Comercial por Request");
        
        return informacionComercialServicio.add(informacionComercial);
    }
    
    
    // EDITAR
    // Metodo para editar una persona
    @RequestMapping(value="/informacionComercialUp/{id}", method = RequestMethod.PUT, headers="Accept=application/json, application/xml")
    public @ResponseBody String updateInformacionComercial(@PathVariable("id") int id, @RequestBody InformacionComercial informacionComercial){
        
        informacionComercial.setIdInformacionComercial(id);
        
        return informacionComercialServicio.edit(informacionComercial).toString();
    }
}
