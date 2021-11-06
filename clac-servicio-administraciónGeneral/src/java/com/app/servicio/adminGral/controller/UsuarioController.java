
package com.app.servicio.adminGral.controller;

import com.app.servicio.adminGral.domain.Usuario;
import com.app.servicio.adminGral.domain.UsuarioList;
import com.app.servicio.adminGral.service.UsuarioServicio;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsuarioController {
 
    // Declaramos que utilizaremos el servicio de Usuario
    @Resource(name="usuarioServicio")
    private UsuarioServicio usuarioServicio;
    
    
    // LISTAR
    // Metodo para recuperar todas los Usuario de la BD
    @RequestMapping(value="/usuarios", method=RequestMethod.GET, headers="Accept=application/json, application/xml")
    private @ResponseBody UsuarioList getUsuarios(){
        
        UsuarioList result = new UsuarioList();
        
        result.setData(usuarioServicio.getAll());
        
        System.out.println(result);
        
        return result;
    }
    
    
    // CONSULTAR
    // Metodo para recuperar un Usuario por su ID
    @RequestMapping(value="/usuarios/{idUsuario}", method = RequestMethod.GET, headers="Accept=application/json, application/xml")
    private @ResponseBody Usuario getUsuariosById(@PathVariable("idUsuario") int idUsuario){
        
        return usuarioServicio.getByID(idUsuario);
    }
    
    
    // CREAR
    // Metodo para agregar usuario
    @RequestMapping(value="/usuariosAdd", method = RequestMethod.POST, headers="Accept=application/json, application/xml")
    public @ResponseBody Usuario addUsuario(@RequestBody Usuario usuario){
    
        System.out.println("Se ha recibido el nuevo usuario por Request");
        
        return usuarioServicio.add(usuario);
    }
    
    
    // EDITAR
    // Metodo para editar un usuario
    @RequestMapping(value="/usuariosUp/{idUsuario}", method = RequestMethod.PUT, headers="Accept=application/json, application/xml")
    public @ResponseBody String updateUsuario(@PathVariable("idUsuario") int idUsuario, @RequestBody Usuario usuario){
        
        usuario.setIdUsuario(idUsuario);
        
        return usuarioServicio.edit(usuario).toString();
    }
    
    
    // ELIMINAR
    // Metodo para eliminar un usuario
    @RequestMapping(value="/usuariosDel/{idUsuario}", method = RequestMethod.DELETE, headers="Accept=application/json, application/xml")
    private @ResponseBody String deleteUser(@PathVariable("idUsuario") int idUsuario){
        System.out.println("Se ha eliminado el registro de ID: " + idUsuario);
        
        return usuarioServicio.delete(idUsuario).toString();
    }
    
}
