
package com.app.servicio.adminGral.controller;

import com.app.servicio.adminGral.domain.RubroList;
import com.app.servicio.adminGral.service.RubroServicio;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RubroController {
    // Declaramos que utilizaremos el servicio de Persona
    @Resource(name="rubroServicio")
    private RubroServicio rubroServicio;
    
    
    // LISTAR
    // Metodo para recuperar todas las personas de la BD
    @RequestMapping(value="/rubros", method=RequestMethod.GET, headers="Accept=application/json, application/xml")
    private @ResponseBody RubroList getRubros(){
        
        RubroList result = new RubroList();
        
        result.setData(rubroServicio.getAll());
        
        System.out.println(result);
        
        return result;
    }
    
}
