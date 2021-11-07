
package com.app.servicio.adminGral.controller;

import com.app.servicio.adminGral.domain.RolList;
import com.app.servicio.adminGral.service.RolServicio;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RolController {
    // Declaramos que utilizaremos el servicio de Persona
    @Resource(name="rolServicio")
    private RolServicio rolServicio;
    
    
    // LISTAR
    // Metodo para recuperar todas las personas de la BD
    @RequestMapping(value="/roles", method=RequestMethod.GET, headers="Accept=application/json, application/xml")
    private @ResponseBody RolList getRubros(){
        
        RolList result = new RolList();
        
        result.setData(rolServicio.getAll());
        
        System.out.println(result);
        
        return result;
    }
}
