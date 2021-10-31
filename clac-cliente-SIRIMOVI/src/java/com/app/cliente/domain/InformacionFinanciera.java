
package com.app.cliente.domain;


/*import java.util.ArrayList;
import java.util.List;*/
import javax.xml.bind.annotation.XmlRootElement;
/*import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;*/

@XmlRootElement(name="inFinancieras")
public class InformacionFinanciera {
    //private RestTemplate restTemplate = new RestTemplate();
    
    int idinformacionFinanciera;
    int idinformacionOrganizacional;
    String rangoSalariosEmpleados;
    float saldoDeudasActual;
    float saldoLiquidez;

    public int getIdinformacionFinanciera() {
        return idinformacionFinanciera;
    }

    public void setIdinformacionFinanciera(int idinformacionFinanciera) {
        this.idinformacionFinanciera = idinformacionFinanciera;
    }

    public int getIdinformacionOrganizacional() {
        return idinformacionOrganizacional;
    }

    public void setIdinformacionOrganizacional(int idinformacionOrganizacional) {
        this.idinformacionOrganizacional = idinformacionOrganizacional;
    }

    public String getRangoSalariosEmpleados() {
        return rangoSalariosEmpleados;
    }

    public void setRangoSalariosEmpleados(String rangoSalariosEmpleados) {
        this.rangoSalariosEmpleados = rangoSalariosEmpleados;
    }

    public float getSaldoDeudasActual() {
        return saldoDeudasActual;
    }

    public void setSaldoDeudasActual(float saldoDeudasActual) {
        this.saldoDeudasActual = saldoDeudasActual;
    }

    public float getSaldoLiquidez() {
        return saldoLiquidez;
    }

    public void setSaldoLiquidez(float saldoLiquidez) {
        this.saldoLiquidez = saldoLiquidez;
    }
    
    @Override
    public String toString(){
        return "Persona{" + "id informacion financiera=" + idinformacionFinanciera + ", id informacion organizacional=" + idinformacionOrganizacional + 
                ", rango de salarios de los empleados=" + rangoSalariosEmpleados + ", saldo de liquidez=" + saldoLiquidez + ", saldo de deuda actual=" + saldoDeudasActual + '}';
    }
 
    //listar
    /*@RequestMapping(value = "/getall", method = RequestMethod.GET)
    public String getAll(Model model){
        System.out.println("--> Recuperar Todas las Personas de mi BD.");
        
        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);
        
        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<InformacionFinanciera> entity = new HttpEntity<InformacionFinanciera>(headers);
        
        //Enviamos el request via GET
        try{
            ResponseEntity<InformacionFinancieraList> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/informacionfinanciera", 
                    HttpMethod.GET, entity, InformacionFinancieraList.class);
            // Agregamos al Model
            model.addAttribute("personasGetAll", result.getBody().getData());
        
        }catch(Exception e){
            System.out.println(e);
        }
        
        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "consultarPersona";
    }
    
    //crear
    @RequestMapping(value = "informacion/add", method = RequestMethod.GET)
    public String getAddPage(Model model) {
        System.out.println("--> Recibiendo el Request para mostrarlo en la página de agregar.");

        // Creamos una persona y la agregamos al modelo
        model.addAttribute("personaAttribute", new InformacionFinanciera());

        // Esto es para enviar al JSP de WEB-INF/jsp/agregarPersona.jsp
        return "agregarPersona";
    }
    
    //crear
    @RequestMapping(value = "informacion/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("personaAttribute") InformacionFinanciera infoFi, Model model) {
        System.out.println("--> Agregar una nueva persona.");

        //Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<InformacionFinanciera> entity = new HttpEntity<InformacionFinanciera>(infoFi, headers);

        // Enviamos el Request via POST
        try {
            ResponseEntity<InformacionFinanciera> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/informacionfinancieraAdd", 
                    HttpMethod.POST, entity, InformacionFinanciera.class);
            
        } catch (Exception e) {
            System.out.println(e);
        }

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "redirect:/getall";
    }
    
    //modificar editar
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String getUpdatePage(@RequestParam(value="id", required=true) Integer id, Model model) {
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
            ResponseEntity<InformacionFinanciera> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/informacionfinancieraUp/{id}", 
                    HttpMethod.GET, entity, InformacionFinanciera.class, id);
            // Agregamos al Model
            model.addAttribute("personaAttribute", result.getBody());

        } catch (Exception e) {
                System.out.println(e);
        }
    	
    	// Esto es para enviar al JSP de WEB-INF/jsp/actualizarPersona.jsp
    	return "actualizarPersona";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePerson(@ModelAttribute("personaAttribute") InformacionFinanciera infoFi,
            @RequestParam(value="id",  required=true) int id, Model model) {
        System.out.println("--> Actualizando la persona.");

        ///Preparar Tipos de datos a trabajar
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);

        //Preparo el header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<InformacionFinanciera> entity = new HttpEntity<InformacionFinanciera>(infoFi, headers);

        // Enviamos el Request via PUT
        ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/clac-servicio-administracionGeneral/informacionfinancieraUp/{id}", 
                HttpMethod.PUT, entity, String.class, id);

        // Esto es para enviar al JSP de WEB-INF/jsp/consultarPersonas.jsp
        return "redirect:/getall";
    }*/
}
