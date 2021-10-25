
package com.app.servicio.adminGral.controller;

import com.app.servicio.adminGral.domain.Monitoreo;
import com.app.servicio.adminGral.domain.MonitoreoList;
import com.app.servicio.adminGral.service.MonitoreoServicio;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MonitoreoController {
    // Declaramos que utilizaremos el servicio de Monitoreo
    @Resource(name="monitoreoServicio")
    private MonitoreoServicio monitoreoServicio;
    
    
    // LISTAR
    // Metodo para recuperar todas los monitoreos de la BD
    @RequestMapping(value="/getall", method=RequestMethod.GET, headers="Accept=application/json, application/xml")
    private @ResponseBody MonitoreoList getMonitoreo(){
        
        MonitoreoList result = new MonitoreoList();
        
        result.setData(monitoreoServicio.getAll());
        
        System.out.println(result);
        
        return result;
    }
    
    
    // CONSULTAR
    // Metodo para recuperar una monitoreo por su ID
    @RequestMapping(value="/monitoreos/{id}", method = RequestMethod.GET, headers="Accept=application/json, application/xml")
    private @ResponseBody Monitoreo getMonitoreoById(@PathVariable("id") int id){
        
        return monitoreoServicio.getByID(id);
    }
    
    
    // CREAR
    // Metodo para agregar monitoreo
    @RequestMapping(value="/monitoreosAdd", method = RequestMethod.POST, headers="Accept=application/json, application/xml")
    public @ResponseBody Monitoreo addMonitoreo(@RequestBody Monitoreo monitoreo){
    
        System.out.println("Se ha recibido el nuevo monitoreo por Request");
        
        return monitoreoServicio.add(monitoreo);
    }
    
    
    // EDITAR
    // Metodo para editar un monitoreo
    @RequestMapping(value="/monitoreosUp/{id}", method = RequestMethod.PUT, headers="Accept=application/json, application/xml")
    public @ResponseBody String updateMonitoreo(@PathVariable("id") int id, @RequestBody Monitoreo monitoreo){
        
        monitoreo.setIdMonitoreo(id);
        
        return monitoreoServicio.edit(monitoreo).toString();
    }
    
    
    // ELIMINAR
    // Metodo para eliminar una monitoreo
    @RequestMapping(value="/monitoreosDel/{id}", method = RequestMethod.DELETE, headers="Accept=application/json, application/xml")
    private @ResponseBody String deletMonitoreo(@PathVariable("id") int id){
        System.out.println("Se ha eliminado el registro de ID: " + id);
        
        return monitoreoServicio.delete(id).toString();
    }
}
