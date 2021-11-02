
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.connect.Conexion;
import com.app.servicio.adminGral.domain.InformacionFinanciera;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("inFinancieraServicio")
public class InformacionFinancieraServicio {
    
    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    
    private List<InformacionFinanciera> infoFinanciera = new ArrayList<InformacionFinanciera>();
    List datos;
    
    //LISTAR
    public List<InformacionFinanciera> getAll(){
        System.out.println("Recuperando toda la Informacion Financiera de la BD.");
        
        String sql = "SELECT * FROM registro.informacionfinanciera";
        infoFinanciera = this.jdbcTemplate.query(sql, new InfoFinancieraRowMapper());
        System.out.println(infoFinanciera);
        
        return infoFinanciera;
    }
    
    public InformacionFinanciera getByID(int id){
        System.out.println("Recuperando Informacion Financiera con ID: " + id);
        
        String sql = "SELECT * FROM registro.informacionfinanciera WHERE idInformacionFinanciera = ?";
        
        return this.jdbcTemplate.queryForObject(sql, new InfoFinancieraRowMapper(), id);
    }
    
    //AGREGAR CREAR
    public InformacionFinanciera add(InformacionFinanciera informacion){
        System.out.println("Insertando nueva Informacion Financiera.");
        
        try{
            String sql = "INSERT INTO registro.informacionfinanciera(idInformacionOrganizacional, rangoSalarioEmpleados, saldoDeudasActual, saldoLiquidez) VALUES(?, ?, ?, ?)";
            
            this.jdbcTemplate.update(sql, informacion.getIdinformacionOrganizacional(), informacion.getRangoSalariosEmpleados(), informacion.getSaldoDeudasActual(), informacion.getSaldoLiquidez());
            
            System.out.println("Informacion Financiera Insertada Correctamente. ");
            
            return informacion;
            
        }catch(Exception e){
            System.out.println(e);
            
            return null;
        }
    }
    
    // EDITAR 
    public Boolean edit(InformacionFinanciera infof){
        System.out.println("Editando Informacion Financiera con ID: " + infof.getIdinformacionFinanciera());
        
        try{
            String sql = "UPDATE registro.informacionfinanciera SET idInformacionOrganizacional=?, rangoSalarioEmpleados=?, saldoDeudasActual=?, saldoLiquidez=? WHERE idInformacionFinanciera = ?";
            
            this.jdbcTemplate.update(sql, infof.getIdinformacionOrganizacional(), infof.getRangoSalariosEmpleados(), infof.getSaldoDeudasActual(),
                     infof.getSaldoLiquidez(), infof.getIdinformacionFinanciera());
            
            System.out.println("Informacion Financiera Actualizada Correctamente.");
            
            return true;
            
        }catch(Exception e){
            System.out.println(e);
            
            return false;
        }
    }
}

