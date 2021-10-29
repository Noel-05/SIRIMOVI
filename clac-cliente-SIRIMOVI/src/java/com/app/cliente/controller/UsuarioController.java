
package com.app.cliente.controller;

import com.app.cliente.domain.Usuario;
import com.app.cliente.domain.UsuarioList;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
        
    private RestTemplate restTemplate = new RestTemplate();
    ModelAndView mav = new ModelAndView();
    
    // LISTAR
    // Mostrar TODAS los Usuarios en el JSP
    @RequestMapping(value = "/getallUsuarios", method = RequestMethod.GET)
    public String getAllUsuarios(Model model){
        System.out.println("--> Recuperar Todas los Usuarios de mi BD.");
        
        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);
        
        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Usuario> entity = new HttpEntity<Usuario>(headers);
        
        //Enviamos el request via GET
        try{
            ResponseEntity<UsuarioList> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/usuarios", 
                    HttpMethod.GET, entity, UsuarioList.class);
            // Agregamos al Model
            model.addAttribute("usuariosGetAll", result.getBody().getData());
        
        }catch(Exception e){
            System.out.println(e);
        }
        
        // Esto es para enviar al JSP de WEB-INF/jsp/consultarUsuarios.jsp
        return "consultarUsuarios";
    }
    
    
    // CONSULTAR
    // Mostrar los datos de un Usuario en el JSP por su ID
    @RequestMapping(value = "/getUsuarios", method = RequestMethod.GET)
    public String getUsuario(@RequestParam("idUsuario") int idUsuario, Model model) {
        System.out.println("--> Recuperando usuario con ID: " + idUsuario);

        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Usuario> entity = new HttpEntity<Usuario>(headers);

        // Enviamos el Request via GET
        try {
            ResponseEntity<Usuario> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/usuarios/{idUsuario}", 
                    HttpMethod.GET, entity, Usuario.class, idUsuario);
            // Agregamos al Model
            model.addAttribute("usuarioGetId", result.getBody());

        } catch (Exception e) {
            System.out.println(e);
        }
        
        // Esto es para enviar al JSP de WEB-INF/jsp/obtenerUsuario.jsp
        return "obtenerUsuario";
    }
    
    
    // CREAR
    // Mostrar el JSP para Agregar Usuario
    @RequestMapping(value = "/addUsuarios", method = RequestMethod.GET)
    public String getAddPageUsuarios(Model model) {
        System.out.println("--> Recibiendo el Request para mostrarlo en la página de agregar.");

        // Creamos una persona y la agregamos al modelo
        model.addAttribute("usuarioAttribute", new Usuario());

        // Esto es para enviar al JSP de WEB-INF/jsp/agregarUsuario.jsp
        return "agregarUsuario";
    }
    
    // CREAR
    // Envíamos el registro y una solicitud de actualización por el metodo GET basados en la información que se envía en submit
    @RequestMapping(value = "/addUsuarios", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("usuarioAttribute") Usuario usuario, Model model) {
        System.out.println("--> Agregar una nueva usuario.");

        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Usuario> entity = new HttpEntity<Usuario>(usuario, headers);

        // Enviamos el Request via POST
        try {
            ResponseEntity<Usuario> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/usuariosAdd", 
                    HttpMethod.POST, entity, Usuario.class);
            
        } catch (Exception e) {
            System.out.println(e);
        }

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarUsuarios.jsp
        return "redirect:/getallUsuarios";
    }
    
    
    // EDITAR
    // Mostrar y Recuperar los datos del usario a editar en el JSP
    @RequestMapping(value = "/updateUsuarios", method = RequestMethod.GET)
    public String getUpdatePageUsuarios(@RequestParam(value="idUsuario", required=true) Integer idUsuario, Model model) {
    	   System.out.println("--> Recibiendo el Request para mostrarlo en la página de editar.");
    
    	//Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Usuario> entity = new HttpEntity<Usuario>(headers);

        // Enviamos el Request via GET
        try {
            ResponseEntity<Usuario> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/usuarios/{idUsuario}", 
                    HttpMethod.GET, entity, Usuario.class, idUsuario);
            // Agregamos al Model
            model.addAttribute("usuarioAttribute", result.getBody());

        } catch (Exception e) {
                System.out.println(e);
        }
    	
    	// Esto es para enviar al JSP de WEB-INF/jsp/actualizarUsuario.jsp
    	return "actualizarUsuario";
    }
    
    // EDITAR
    // Envíar una solicitud de actualización basados en la información enviada en el submit
    @RequestMapping(value = "/updateUsuarios", method = RequestMethod.POST)
    public String updateUsuarios(@ModelAttribute("usuarioAttribute") Usuario usuario,
            @RequestParam(value="idUsuario",  required=true) int idUsuario, Model model) {
        System.out.println("--> Actualizando el usuario.");

        ///Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Usuario> entity = new HttpEntity<Usuario>(usuario, headers);

        // Enviamos el Request via PUT
        ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/usuariosUp/{idUsuario}", 
                HttpMethod.PUT, entity, String.class, idUsuario);

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarUsuarios.jsp
        return "redirect:/getallUsuarios";
    }
    
    
    // ELIMINAR
    // Envíamos una solicitud de eliminar
    @RequestMapping(value = "/deleteUsuarios", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("idUsuario") int idUsuario, Model model) {
       System.out.println("--> Eliminando a la persona.");

        ///Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        // Enviamos el Request via PUT
        ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/usuariosDel/{idUsuario}", 
                HttpMethod.DELETE, entity, String.class, idUsuario);

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarUsuarios.jsp
        return "redirect:/getallUsuarios";
    }
}
