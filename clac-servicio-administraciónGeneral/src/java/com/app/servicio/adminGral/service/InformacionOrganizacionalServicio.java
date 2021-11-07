
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.connect.Conexion;
import com.app.servicio.adminGral.domain.InformacionOrganizacional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("informacionOrganizacionalServicio")
public class InformacionOrganizacionalServicio {
    
    // Conexión a la BD.
    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    
    // Variables a utilizar
    private List<InformacionOrganizacional> informacionOrganizacionales = new ArrayList<InformacionOrganizacional>();
    List datos;
    
    
    // LISTAR InformacionOrganizacional
    public List<InformacionOrganizacional> getAll(){
        System.out.println("Recuperando todos los datos de información organizacional de la BD.");
        
        String sql = "SELECT * FROM registro.informacionorganizacional AS INFORG INNER JOIN registro.rubro AS R ON INFORG.idRubro = R.idRubro";
        
        informacionOrganizacionales = this.jdbcTemplate.query(sql, new InformacionOrganizacionalRowMapper2());
        
        System.out.println(informacionOrganizacionales);
        
        return informacionOrganizacionales;
    }

    
    // CONSULTAR informacionOrganizacional por ID
    public InformacionOrganizacional getByID(int id){
        System.out.println("Recuperando informacionOrganizacional con ID: " + id);
        
        String sql = "SELECT * FROM registro.informacionorganizacional WHERE idInformacionOrganizacional = ?";
        
        return this.jdbcTemplate.queryForObject(sql, new InformacionOrganizacionalRowMapper(), id);
    }
    
    
    // CREAR InformacionOrganizacional
    public InformacionOrganizacional add(InformacionOrganizacional informacionOrganizacional){
        System.out.println("Insertando nueva informacion organizacional.");
        
        try{
            String sql = "INSERT INTO registro.informacionorganizacional(idRubro, nombreNegocio, cantidadEmpleados, direccionNegocio, cantidadSucursales ) "
                    + "VALUES(?, ?, ?, ?, ?)";
            
            this.jdbcTemplate.update(sql, informacionOrganizacional.getIdRubro(), informacionOrganizacional.getNombreNegocio(), 
                    informacionOrganizacional.getCantEmpleados(), informacionOrganizacional.getDireccionNegocio(), informacionOrganizacional.getCantSucursales());
            
            System.out.println("Información Organizacional Insertada Correctamente. ");
            
            return informacionOrganizacional;
            
        }catch(Exception e){
            System.out.println(e);
            
            return null;
        }
    }
    
 
    // EDITAR InformacionOrganizacional
    public Boolean edit(InformacionOrganizacional informacionOrganizacional){
        System.out.println("Editando información organizacional con ID: " + informacionOrganizacional.getIdInfOrganizacional());
        
        try{
            String sql = "UPDATE registro.informacionorganizacional SET idRubro=?, nombreNegocio=?, cantidadEmpleados=?, direccionNegocio=?, cantidadSucursales =?  "
                    + "WHERE idInformacionOrganizacional = ?";
            
            this.jdbcTemplate.update(sql, informacionOrganizacional.getIdRubro(), informacionOrganizacional.getNombreNegocio(), informacionOrganizacional.getCantEmpleados(),
                    informacionOrganizacional.getDireccionNegocio(), informacionOrganizacional.getCantSucursales(), informacionOrganizacional.getIdInfOrganizacional());
                               
            
            System.out.println("Informacion Organizacional Actualizada Correctamente.");
            
            return true;
            
        }catch(Exception e){
            System.out.println(e);
            
            return false;
        }
    }
    
}
    
    
    
    

