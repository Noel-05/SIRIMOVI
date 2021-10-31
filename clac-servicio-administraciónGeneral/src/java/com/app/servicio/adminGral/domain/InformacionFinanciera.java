
package com.app.servicio.adminGral.domain;

/*import com.app.servicio.adminGral.connect.Conexion;
import com.app.servicio.adminGral.service.InfoFinancieraRowMapper;
import com.app.servicio.adminGral.service.InformacionFinancieraServicio;*/
//import com.app.servicio.adminGral.service.PersonaServicio;
/*import java.util.ArrayList;
import java.util.List;*/
import javax.xml.bind.annotation.XmlRootElement;
//import org.springframework.jdbc.core.JdbcTemplate;
/*import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;*/

@XmlRootElement(name="inFinancieras")
public class InformacionFinanciera {
    
    /*Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    InformacionFinancieraServicio inFi = new InformacionFinancieraServicio();
    //private PersonaServicio infoFinanciera;
    private List<InformacionFinanciera> infoFinan = new ArrayList<InformacionFinanciera>();*/
    
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
   
    
    /*public InformacionFinanciera add(InformacionFinanciera info){//crear
        System.out.println("Insertando nueva persona.");
        
        try{
            String sql = "INSERT INTO registro.informacionfinanciera(idInformacionfinanciera, idInformacionOrganizacional, rangoSalarioEmpleados, saldoDeudasActual, saldoLiquidez) VALUES(?, ?, ?, ?, ?)";
            
            this.jdbcTemplate.update(sql, info.getIdinformacionFinanciera(), info.getIdinformacionOrganizacional(), info.getRangoSalariosEmpleados()
            , info.getSaldoDeudasActual(), info.getSaldoLiquidez());
            
            System.out.println("Informacion financiera Insertada Correctamente. ");
            
            return info;
            
        }catch(Exception e){
            System.out.println(e);          
            return null;
        }
    }
    
    public Boolean edit(InformacionFinanciera info){//editar
        System.out.println("Editando persona con ID: " + info.getIdinformacionFinanciera());
        
        try{
            String sql = "UPDATE registro.informacionfinanciera SET idinformacionOrganizacional=?, rangoSalarioEmpleado=?, saldoDeudasActual=?, saldoLiquidez=? WHERE idInformacionFinanciera = ?";
            
            this.jdbcTemplate.update(sql, info.getIdinformacionOrganizacional(), info.getRangoSalariosEmpleados(),info.getSaldoDeudasActual()
            , info.getSaldoLiquidez(), info.getIdinformacionFinanciera());
            
            System.out.println("Informacion Financiera Actualizada Correctamente.");
            
            return true;
            
        }catch(Exception e){
            System.out.println(e);          
            return false;
        }
    }
    
    public List<InformacionFinanciera> getAll(){//listar
        System.out.println("Recuperando toda la informacion financiera de la BD.");
        
        String sql = "SELECT * FROM registro.informacionfinanciera";
        infoFinan = this.jdbcTemplate.query(sql, new InfoFinancieraRowMapper());
        System.out.println(infoFinan);
        
        return infoFinan;
    }
    
    //listar
    @RequestMapping(value="/informacionfinanciera", method=RequestMethod.GET, headers="Accept=application/json, application/xml")
    private @ResponseBody InformacionFinancieraList getInfoFinanciera(){
        
        InformacionFinancieraList result = new InformacionFinancieraList();
        
        result.setData(inFi.getAll());
        
        System.out.println(result);
        
        return result;
    }
    
    //crear
    @RequestMapping(value="/informacionfinancieraAdd", method = RequestMethod.POST, headers="Accept=application/json, application/xml")
    public @ResponseBody InformacionFinanciera addInformacionFinanciera(@RequestBody InformacionFinanciera info){
    
        System.out.println("Se ha recibido la nueva persona por Request");
        
        return inFi.add(info);
    }
      
    //modificar
    @RequestMapping(value="/informacionfinancieraUp/{id}", method = RequestMethod.PUT, headers="Accept=application/json, application/xml")
    public @ResponseBody String updateInfoFinanciera(@PathVariable("id") int id, @RequestBody InformacionFinanciera inf){
        
        inf.setIdinformacionFinanciera(id);
        
        return inFi.edit(inf).toString();
    }*/
        
}
