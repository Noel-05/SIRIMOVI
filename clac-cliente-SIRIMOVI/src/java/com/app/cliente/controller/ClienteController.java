
package com.app.cliente.controller;

import com.app.cliente.domain.InformacionComercial;
import com.app.cliente.domain.InformacionComercialList;
import com.app.cliente.domain.Persona;
import com.app.cliente.domain.PersonaList;
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
public class ClienteController {
    
    private RestTemplate restTemplate = new RestTemplate();
    ModelAndView mav = new ModelAndView();
    
    @RequestMapping("/")
    public ModelAndView Listar(){
        mav.setViewName("index");
        return mav;
    }
    
    
    // LISTAR
    // Mostrar TODAS las personas en el JSP
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public String getAll(Model model){
        System.out.println("--> Recuperar Todas las Personas de mi BD.");
        
        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);
        
        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Persona> entity = new HttpEntity<Persona>(headers);
        
        //Enviamos el request via GET
        try{
            ResponseEntity<PersonaList> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/personas", 
                    HttpMethod.GET, entity, PersonaList.class);
            // Agregamos al Model
            model.addAttribute("personasGetAll", result.getBody().getData());
        
        }catch(Exception e){
            System.out.println(e);
        }
        
        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "consultarPersonas";
    }
    
    
    // CONSULTAR
    // Mostrar los datos de una persona en el JSP por su ID
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getPersona(@RequestParam("id") int id, Model model) {
        System.out.println("--> Recuperando persona con ID: " + id);

        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Persona> entity = new HttpEntity<Persona>(headers);

        // Enviamos el Request via GET
        try {
            ResponseEntity<Persona> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/personas/{id}", 
                    HttpMethod.GET, entity, Persona.class, id);
            // Agregamos al Model
            model.addAttribute("personaGetId", result.getBody());

        } catch (Exception e) {
            System.out.println(e);
        }
        
        // Esto es para enviar al JSP de WEB-INF/jsp/obtenerPersona.jsp
        return "obtenerPersona";
    }
    
    
    // CREAR
    // Mostrar el JSP para Agregar Persona
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddPage(Model model) {
        System.out.println("--> Recibiendo el Request para mostrarlo en la página de agregar.");

        // Creamos una persona y la agregamos al modelo
        model.addAttribute("personaAttribute", new Persona());

        // Esto es para enviar al JSP de WEB-INF/jsp/agregarPersona.jsp
        return "agregarPersona";
    }
    
    // CREAR
    // Envíamos el registro y una solicitud de actualización por el metodo GET basados en la información que se envía en submit
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("personaAttribute") Persona persona, Model model) {
        System.out.println("--> Agregar una nueva persona.");

        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Persona> entity = new HttpEntity<Persona>(persona, headers);

        // Enviamos el Request via POST
        try {
            ResponseEntity<Persona> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/personasAdd", 
                    HttpMethod.POST, entity, Persona.class);
            
        } catch (Exception e) {
            System.out.println(e);
        }

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "redirect:/getall";
    }
    
    
    // EDITAR
    // Mostrar y Recuperar los datos de la persona a editar en el JSP
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String getUpdatePage(@RequestParam(value="id", required=true) Integer id, Model model) {
    	   System.out.println("--> Recibiendo el Request para mostrarlo en la página de editar.");
    
    	//Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Persona> entity = new HttpEntity<Persona>(headers);

        // Enviamos el Request via GET
        try {
            ResponseEntity<Persona> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/personas/{id}", 
                    HttpMethod.GET, entity, Persona.class, id);
            // Agregamos al Model
            model.addAttribute("personaAttribute", result.getBody());

        } catch (Exception e) {
                System.out.println(e);
        }
    	
    	// Esto es para enviar al JSP de WEB-INF/jsp/actualizarPersona.jsp
    	return "actualizarPersona";
    }
    
    // EDITAR
    // Envíar una solicitud de actualización basados en la información enviada en el submit
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePerson(@ModelAttribute("personaAttribute") Persona persona,
            @RequestParam(value="id",  required=true) int id, Model model) {
        System.out.println("--> Actualizando la persona.");

        ///Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Persona> entity = new HttpEntity<Persona>(persona, headers);

        // Enviamos el Request via PUT
        ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/personasUp/{id}", 
                HttpMethod.PUT, entity, String.class, id);

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "redirect:/getall";
    }
    
    
    // ELIMINAR
    // Envíamos una solicitud de eliminar
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deletePerson(@RequestParam("id") int id, Model model) {
       System.out.println("--> Eliminando a la persona.");

        ///Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        // Enviamos el Request via PUT
        ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/personasDel/{id}", 
                HttpMethod.DELETE, entity, String.class, id);

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "redirect:/getall";
    }
    
    
    
    // CREAR
    // Mostrar el JSP para Agregar Persona
    @RequestMapping(value = "/addInformacionCoomercial", method = RequestMethod.GET)
    public String getAddPageInformacionComercial(Model model) {
        System.out.println("--> Recibiendo el Request para mostrarlo en la página de agregar.");

        // Creamos una persona y la agregamos al modelo
        model.addAttribute("InformacionComercialAttribute", new InformacionComercial());

        // Esto es para enviar al JSP de WEB-INF/jsp/agregarPersona.jsp
        return "agregarInformacionComercial";
    }
    
    // CREAR
    // Envíamos el registro y una solicitud de actualización por el metodo GET basados en la información que se envía en submit
    @RequestMapping(value = "/addInformacionComercial", method = RequestMethod.POST)
    public String addInformacionComercial(@ModelAttribute("InformacionComercialAttribute") InformacionComercial informacionComercial, Model model) {
        System.out.println("--> Agregar una nueva informacion comercila.");

        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<InformacionComercial> entity = new HttpEntity<InformacionComercial>(informacionComercial, headers);

        // Enviamos el Request via POST
        try {
            ResponseEntity<InformacionComercial> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/informacionComercialAdd", 
                    HttpMethod.POST, entity, InformacionComercial.class);
            
        } catch (Exception e) {
            System.out.println(e);
        }

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "redirect:/getall";
    }
    
     
    // EDITAR
    // Mostrar y Recuperar los datos de la persona a editar en el JSP
    @RequestMapping(value = "/informacionComercialUp", method = RequestMethod.GET)
    public String getUpdatePageInformacionComercial(@RequestParam(value="id", required=true) Integer id, Model model) {
    	   System.out.println("--> Recibiendo el Request para mostrarlo en la página de editar.");
    
    	//Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<InformacionComercial> entity = new HttpEntity<InformacionComercial>(headers);

        // Enviamos el Request via GET
        try {
            ResponseEntity<InformacionComercial> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/informacionComercial/{id}", 
                    HttpMethod.GET, entity, InformacionComercial.class, id);
            // Agregamos al Model
            model.addAttribute("informacionComercialAttribute", result.getBody());

        } catch (Exception e) {
                System.out.println(e);
        }
    	
    	// Esto es para enviar al JSP de WEB-INF/jsp/actualizarPersona.jsp
    	return "actualizarInformacionComercial";
    }
    
    // EDITAR
    // Envíar una solicitud de actualización basados en la información enviada en el submit
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePersonInformacionComercial(@ModelAttribute("informacionComercialAttribute") InformacionComercial informacionComercial,
            @RequestParam(value="id",  required=true) int id, Model model) {
        System.out.println("--> Actualizando la informacion comercial.");

        ///Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<InformacionComercial> entity = new HttpEntity<InformacionComercial>(informacionComercial, headers);

        // Enviamos el Request via PUT
        ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/informacionComercialUp/{id}", 
                HttpMethod.PUT, entity, String.class, id);

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "redirect:/getall";
    }
    
     // LISTAR
    // Mostrar TODAS las monitoreos en el JSP
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public String getAllInformacionComercial(Model model){
        System.out.println("--> Recuperar Todas la informacion comercial de mi BD.");
        
        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);
        
        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<InformacionComercial> entity = new HttpEntity<InformacionComercial>(headers);
        
        //Enviamos el request via GET
        try{
            ResponseEntity<InformacionComercialList> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/informacionComercial", 
                    HttpMethod.GET, entity, InformacionComercialList.class);
            // Agregamos al Model
            model.addAttribute("informacionComercialGetAll", result.getBody().getData());
        
        }catch(Exception e){
            System.out.println(e);
        }
        
        // Esto es para enviar al JSP de WEB-INF/jsp/consultarMonitoreos.jsp
        return "consultarInformacionComercial";
    }
    
    
   
}
