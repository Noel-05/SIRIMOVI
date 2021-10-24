
package com.app.cliente.controller;

import com.app.cliente.domain.Producto;
import com.app.cliente.domain.ProductoList;
import com.app.cliente.domain.Producto;
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
    @RequestMapping(value = "/getallProducto", method = RequestMethod.GET)
    public String getAll(Model model){
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
    public String getPersona(@RequestParam("id") int id, Model model) {
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
    public String getAddPage(Model model) {
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
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String getUpdatePage(@RequestParam(value="id", required=true) Integer id, Model model) {
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
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePerson(@ModelAttribute("productoAttribute") Producto producto,
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
