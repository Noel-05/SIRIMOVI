
package com.app.cliente.controller;

import com.app.cliente.domain.Monitoreo;
import com.app.cliente.domain.MonitoreoList;
import com.app.cliente.domain.Persona;
import com.app.cliente.domain.PersonaList;
import com.app.cliente.domain.Producto;
import com.app.cliente.domain.ProductoList;
import com.app.cliente.domain.PruebaPersona;
import com.app.cliente.domain.PruebaPersonaList;
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
    
    
    // LISTAR
    // PRUEBA DE PERSONAS CON FK
    @RequestMapping(value = "/getallPrueba", method = RequestMethod.GET)
    public String getAllPrueba(Model model){
        System.out.println("--> Recuperar Todas las Personas de mi BD (PRUEBA).");
        
        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);
        
        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<PruebaPersona> entity = new HttpEntity<PruebaPersona>(headers);
        
        //Enviamos el request via GET
        try{
            ResponseEntity<PruebaPersonaList> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/pruebaPersonas", 
                    HttpMethod.GET, entity, PruebaPersonaList.class);
            // Agregamos al Model
            model.addAttribute("pruebaPersonasGetAll", result.getBody().getData());
        
        }catch(Exception e){
            System.out.println(e);
        }
        
        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "consultarPruebaPersonas";
    }

    
    // CREAR
    // Mostrar el JSP para Agregar Persona
    @RequestMapping(value = "/addPrueba", method = RequestMethod.GET)
    public String getAddPagePrueba(Model model) {
        System.out.println("--> Recibiendo el Request para mostrarlo en la página de agregar (PRUEBA).");
        
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
            model.addAttribute("pruebaPersona", result.getBody().getData());
            model.addAttribute("pruebaPersonaAttribute", new PruebaPersona());
        
        }catch(Exception e){
            System.out.println(e);
        }
        
        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "agregarPruebaPersona";
        
        // Creamos una persona y la agregamos al modelo
        //model.addAttribute("pruebaPersonaAttribute", new PruebaPersona());

        // Esto es para enviar al JSP de WEB-INF/jsp/agregarPersona.jsp
        //return "agregarPruebaPersona";
    }
    
    // CREAR
    // Envíamos el registro y una solicitud de actualización por el metodo GET basados en la información que se envía en submit
    @RequestMapping(value = "/addPrueba", method = RequestMethod.POST)
    public String addPersonPrueba(@ModelAttribute("pruebaPersonaAttribute") PruebaPersona pruebaPersona, Model model) {
        System.out.println("--> Agregar una nueva persona (PRUEBA).");

        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<PruebaPersona> entity = new HttpEntity<PruebaPersona>(pruebaPersona, headers);

        // Enviamos el Request via POST
        try {
            ResponseEntity<PruebaPersona> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/pruebaPersonasAdd", 
                    HttpMethod.POST, entity, PruebaPersona.class);
            
        } catch (Exception e) {
            System.out.println(e);
        }

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "redirect:/getallPrueba";
    }
    
    
    // CREAR MONITOREO
    // Mostrar el JSP para Agregar Monitoreo
    @RequestMapping(value = "/monitoreosAdd", method = RequestMethod.GET)
    public String getAddPageMonitoreo(Model model) {
        System.out.println("--> Recibiendo el Request para mostrarlo en la página de agregar.");

        // Creamos un monitoreo y la agregamos al modelo
        model.addAttribute("monitoreoAttribute", new Monitoreo());

        // Esto es para enviar al JSP de WEB-INF/jsp/agregarMonitoreo.jsp
        return "agregarMonitoreo";
    }
    
    // CREAR
    // Envíamos el registro y una solicitud de actualización por el metodo GET basados en la información que se envía en submit
    @RequestMapping(value = "/monitoreosAdd", method = RequestMethod.POST)
    public String addPersonMonitoreo(@ModelAttribute("monitoreoAttribute") Monitoreo monitoreo, Model model) {
        System.out.println("--> Agregar un nuevo monitoreo.");

        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Monitoreo> entity = new HttpEntity<Monitoreo>(monitoreo, headers);

        // Enviamos el Request via POST
        try {
            ResponseEntity<Monitoreo> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/monitoreosAdd", 
                    HttpMethod.POST, entity, Monitoreo.class);
            
        } catch (Exception e) {
            System.out.println(e);
        }

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarMonitoreos.jsp
        return "redirect:/getallMonitoreos";
    }
    
    
    // EDITAR MONITOREO
    // Mostrar y Recuperar los datos de la monitoreo a editar en el JSP
    @RequestMapping(value = "/updateMonitoreo", method = RequestMethod.GET)
    public String getUpdatePageMonitoreo(@RequestParam(value="id", required=true) Integer id, Model model) {
    	   System.out.println("--> Recibiendo el Request para mostrarlo en la página de editar.");
    
    	//Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Monitoreo> entity = new HttpEntity<Monitoreo>(headers);

        // Enviamos el Request via GET
        try {
            ResponseEntity<Monitoreo> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/monitoreos/{id}", 
                    HttpMethod.GET, entity, Monitoreo.class, id);
            // Agregamos al Model
            model.addAttribute("monitoreoAttribute", result.getBody());

        } catch (Exception e) {
                System.out.println(e);
        }
    	
    	// Esto es para enviar al JSP de WEB-INF/jsp/actualizarMonitoreo.jsp
    	return "actualizarMonitoreo";
    }
    
    // EDITAR
    // Envíar una solicitud de actualización basados en la información enviada en el submit
    @RequestMapping(value = "/updateMonitoreo", method = RequestMethod.POST)
    public String updatePersonMonitoreo(@ModelAttribute("monitoreoAttribute") Monitoreo monitoreo,
            @RequestParam(value="id",  required=true) int id, Model model) {
        System.out.println("--> Actualizando la monitoreo.");

        ///Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Monitoreo> entity = new HttpEntity<Monitoreo>(monitoreo, headers);

        // Enviamos el Request via PUT
        ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/monitoreosUp/{id}", 
                HttpMethod.PUT, entity, String.class, id);

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarMonitoreos.jsp
        return "redirect:/getallMonitoreos";
    }
    
    
    // LISTAR
    // Mostrar TODOS las monitoreos en el JSP
    @RequestMapping(value = "/getallMonitoreos", method = RequestMethod.GET)
    public String getAllMonitoreo(Model model){
        System.out.println("--> Recuperar Todos las Monitoreos de mi BD.");
        
        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);
        
        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Monitoreo> entity = new HttpEntity<Monitoreo>(headers);
        
        //Enviamos el request via GET
        try{
            ResponseEntity<MonitoreoList> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/getallMonitoreos", 
                    HttpMethod.GET, entity, MonitoreoList.class);
            // Agregamos al Model
            model.addAttribute("monitoreosGetAll", result.getBody().getData());
        
        }catch(Exception e){
            System.out.println(e);
        }
        
        // Esto es para enviar al JSP de WEB-INF/jsp/consultarMonitoreos.jsp
        return "consultarMonitoreo";
    }
    
    
    // LISTAR
    // Mostrar TODAS las personas en el JSP
    @RequestMapping(value = "/getallProducto", method = RequestMethod.GET)
    public String getAllProductos(Model model){
        System.out.println("--> Recuperar Todas los productos de mi BD.");
        
        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);
        
        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Producto> entity = new HttpEntity<Producto>(headers);
        
        //Enviamos el request via GET
        try{
            ResponseEntity<ProductoList> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/productos", 
                    HttpMethod.GET, entity, ProductoList.class);
            // Agregamos al Model
            model.addAttribute("productosGetAll", result.getBody().getData());
        
        }catch(Exception e){
            System.out.println(e);
        }
        
        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "consultarProductos";
    }
    
    
    // CONSULTAR
    // Mostrar los datos de una persona en el JSP por su ID
    @RequestMapping(value = "/getProducto", method = RequestMethod.GET)
    public String getProducto(@RequestParam("id") int id, Model model) {
        System.out.println("--> Recuperando producto con ID: " + id);

        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Producto> entity = new HttpEntity<Producto>(headers);

        // Enviamos el Request via GET
        try {
            ResponseEntity<Producto> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/productos/{id}", 
                    HttpMethod.GET, entity, Producto.class, id);
            // Agregamos al Model
            model.addAttribute("productoGetId", result.getBody());

        } catch (Exception e) {
            System.out.println(e);
        }
        
        // Esto es para enviar al JSP de WEB-INF/jsp/obtenerPersona.jsp
        return "obtenerProducto";
    }
    
    
    // CREAR
    // Mostrar el JSP para Agregar Producto
    @RequestMapping(value = "/addProducto", method = RequestMethod.GET)
    public String getAddPageProducto(Model model) {
        System.out.println("--> Recibiendo el Request para mostrarlo en la página de agregar.");

        // Creamos un nuevo producto y lo agregamos al modelo
        model.addAttribute("productoAttribute", new Producto());

        // Esto es para enviar al JSP de WEB-INF/jsp/agregarPersona.jsp
        return "agregarProducto";
    }
    
    // CREAR
    // Envíamos el registro y una solicitud de actualización por el metodo GET basados en la información que se envía en submit
    @RequestMapping(value = "/addProducto", method = RequestMethod.POST)
    public String addProducto(@ModelAttribute("productoAttribute") Producto producto, Model model) {
        System.out.println("--> Agregar un nuevo Producto.");

        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Producto> entity = new HttpEntity<Producto>(producto, headers);

        // Enviamos el Request via POST
        try {
            ResponseEntity<Producto> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/addProducto", 
                    HttpMethod.POST, entity, Producto.class);
            
        } catch (Exception e) {
            System.out.println(e);
        }

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "redirect:/getallProducto";
    }
    
    
    // EDITAR
    // Mostrar y Recuperar los datos del producto a editar en el JSP
    @RequestMapping(value = "/updateProducto", method = RequestMethod.GET)
    public String getUpdatePageProducto(@RequestParam(value="id", required=true) Integer id, Model model) {
    	   System.out.println("--> Recibiendo el Request para mostrarlo en la página de editar.");
    
    	//Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Producto> entity = new HttpEntity<Producto>(headers);

        // Enviamos el Request via GET
        try {
            ResponseEntity<Producto> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/productos/{id}", 
                    HttpMethod.GET, entity, Producto.class, id);
            // Agregamos al Model
            model.addAttribute("productoAttribute", result.getBody());

        } catch (Exception e) {
                System.out.println(e);
        }
    	
    	// Esto es para enviar al JSP de WEB-INF/jsp/actualizarPersona.jsp
    	return "actualizarProducto";
    }
    
    // EDITAR
    // Envíar una solicitud de actualización basados en la información enviada en el submit
    @RequestMapping(value = "/updateProducto", method = RequestMethod.POST)
    public String updateProducto(@ModelAttribute("productoAttribute") Producto producto,
            @RequestParam(value="id",  required=true) int id, Model model) {
        System.out.println("--> Actualizando el Producto.");

        ///Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Producto> entity = new HttpEntity<Producto>(producto, headers);

        // Enviamos el Request via PUT
        ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/productosUp/{id}", 
                HttpMethod.PUT, entity, String.class, id);

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "redirect:/getallProducto";
    }
}
