
package com.app.cliente.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FinancieraCotroller {
    
    private RestTemplate restTemplate = new RestTemplate();
    ModelAndView mav = new ModelAndView();
    
    // LISTAR
    // Mostrar TODAS las personas en el JSP
    @RequestMapping(value = "/getAllInformacionFinanciera", method = RequestMethod.GET)
    public String getAllInformacionFinanciera(Model model){
        System.out.println("--> Recuperar Toda la Informacion Financiera de mi BD.");
        
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
            model.addAttribute("infoGetAll", result.getBody().getData());
        
        }catch(Exception e){
            System.out.println(e);
        }
        
        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "consultarInformacionFinanciera";
    }
    
    
    // CREAR
    // Mostrar el JSP para Agregar Persona
    @RequestMapping(value = "/informacionFadd", method = RequestMethod.GET)
    public String getAddPageInformacionFinanciera(Model model) {
        System.out.println("--> Recibiendo el Request para mostrarlo en la página de agregar.");

        // Creamos una persona y la agregamos al modelo
        model.addAttribute("informaAttribute", new InformacionFinanciera());

        // Esto es para enviar al JSP de WEB-INF/jsp/agregarPersona.jsp
        return "agregarInformacionFinanciera";
    }
    
    //CREAR
    @RequestMapping(value = "/informacionFadd", method = RequestMethod.POST)
    public String addInfoFinanciera(@ModelAttribute("informaAttribute") InformacionFinanciera info, Model model) {
        System.out.println("--> Agregar una nueva Informacion Financiera.");

        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<InformacionFinanciera> entity = new HttpEntity<InformacionFinanciera>(info, headers);

        // Enviamos el Request via POST
        try {
            ResponseEntity<InformacionFinanciera> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/infoFinancieraAdd", 
                    HttpMethod.POST, entity, InformacionFinanciera.class);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "redirect:/getAllInformacionFinanciera";
    }
    
    
    // EDITAR
    // Mostrar y Recuperar los datos de la persona a editar en el JSP
    @RequestMapping(value = "/updateInformacionFinanciera", method = RequestMethod.GET)
    public String getUpdatePageInformacionFinanciera(@RequestParam(value="id", required=true) Integer id, Model model) {
    	   System.out.println("--> Recibiendo el Request para mostrarlo en la página de editar.");
    
    	//Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<InformacionFinanciera> entity = new HttpEntity<InformacionFinanciera>(headers);

        // Enviamos el Request via GET
        try {
            ResponseEntity<InformacionFinanciera> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/infoFinanciera/{id}", 
                    HttpMethod.GET, entity, InformacionFinanciera.class, id);
            // Agregamos al Model
            model.addAttribute("inforAttribute", result.getBody());

        } catch (Exception e) {
                System.out.println(e);
        }
    	
    	// Esto es para enviar al JSP de WEB-INF/jsp/actualizarPersona.jsp
    	return "actualizarInformacionFinanciera";
    }
    
    // EDITAR
    // Envíar una solicitud de actualización basados en la información enviada en el submit
    @RequestMapping(value = "/updateInformacionFinanciera", method = RequestMethod.POST)
    public String updateInfoFinanciera(@ModelAttribute("inforAttribute") InformacionFinanciera info,
            @RequestParam(value="id",  required=true) int id, Model model) {
        System.out.println("--> Actualizando la Informacion Financiera.");

        ///Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<InformacionFinanciera> entity = new HttpEntity<InformacionFinanciera>(info, headers);

        // Enviamos el Request via PUT
        ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/infoFinancieraUp/{id}", 
                HttpMethod.PUT, entity, String.class, id);

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "redirect:/getAllInformacionFinanciera";
    }
       
    
}
