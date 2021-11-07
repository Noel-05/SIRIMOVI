
package com.app.cliente.controller;

import com.app.cliente.domain.Bienes;
import com.app.cliente.domain.BienesList;
import com.app.cliente.domain.InformacionComercial;
import com.app.cliente.domain.InformacionComercialList;
import com.app.cliente.domain.InformacionFinanciera;
import com.app.cliente.domain.InformacionFinancieraList;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BienController {
    
    private RestTemplate restTemplate = new RestTemplate();
    ModelAndView mav = new ModelAndView();
    
    // LISTAR
    // Mostrar TODAS las personas en el JSP
    @RequestMapping(value = "/getallBienes", method = RequestMethod.GET)
    public String getAllBienes(Model model){
        System.out.println("--> Recuperar Todos los Bienes de mi BD.");
        
        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);
        
        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Bienes> entity = new HttpEntity<Bienes>(headers);
        
        //Enviamos el request via GET
        try{
            ResponseEntity<BienesList> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/bienes", 
                    HttpMethod.GET, entity, BienesList.class);
            // Agregamos al Model
            model.addAttribute("bienesGetAll", result.getBody().getData());
        
        }catch(Exception e){
            System.out.println(e);
        }
        
        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "consultarBienes";
    }
    

    // CREAR
    // Mostrar el JSP para Agregar Bienes
    @RequestMapping(value = "/bienesAdd", method = RequestMethod.GET)
    public String getAddPageBienes(Model model) {
        System.out.println("--> Recibiendo el Request para mostrarlo en la página de agregar.");
        
        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<InformacionFinanciera> entity = new HttpEntity<InformacionFinanciera>(headers);
        
        //Enviamos el request via GET
        try{
            ResponseEntity<InformacionFinancieraList> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/financieralist", 
                    HttpMethod.GET, entity, InformacionFinancieraList.class);
            // Agregamos al Model
            model.addAttribute("informacionFinancieraList", result.getBody().getData());
            model.addAttribute("bienesAttribute", new Bienes());
        
        }catch(Exception e){
            System.out.println(e);
        }

        // Esto es para enviar al JSP de WEB-INF/jsp/agregarPersona.jsp
        return "agregarBienes";
    }
    
    // CREAR
    // Envíamos el registro y una solicitud de actualización por el metodo GET basados en la información que se envía en submit
    @RequestMapping(value = "/bienesAdd", method = RequestMethod.POST)
    public String addBienes(@ModelAttribute("bienesAttribute") Bienes bien, Model model) {
        System.out.println("--> Agregar una nueva bienes.");

        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<Bienes> entity = new HttpEntity<Bienes>(bien, headers);

        // Enviamos el Request via POST
        try {
            ResponseEntity<Bienes> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/bienesAdd", 
                    HttpMethod.POST, entity, Bienes.class);
            
        } catch (Exception e) {
            System.out.println(e);
        }

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "redirect:/getallBienes";
    }
    
}
