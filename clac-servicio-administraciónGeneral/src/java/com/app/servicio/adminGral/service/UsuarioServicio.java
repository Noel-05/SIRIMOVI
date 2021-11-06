
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.connect.Conexion;
import com.app.servicio.adminGral.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("usuarioServicio")
public class UsuarioServicio {
    
    // Conexión a la BD.
    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    
    // Variables a utilizar
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    List datos;
    
    
    // LISTAR todas las personas
    public List<Usuario> getAll(){
        System.out.println("Recuperando todas las personas de la BD.");
        
        String sql = "SELECT * FROM registro.usuarios";
        
        usuarios = this.jdbcTemplate.query(sql, new UsuarioRowMapper());
        
        System.out.println(usuarios);
        
        return usuarios;
    }
    
    
    // CONSULTAR persona por ID
    public Usuario getByID(int idUsuario){
        System.out.println("Recuperando usuario con ID: " + idUsuario);
        
        String sql = "SELECT * FROM registro.usuarios WHERE idUsuario = ?";
        
        return this.jdbcTemplate.queryForObject(sql, new UsuarioRowMapper(), idUsuario);
    }
    
    
    // CREAR persona
    public Usuario add(Usuario usuario){
        System.out.println("Insertando nuevo usuario.");
        
        try{
            String sql = "INSERT INTO registro.usuarios(idRol, nombresUsuario, apellidosUsuario, correoUsuario, contrasenaUsuario) VALUES(?, ?, ?, ?, ?)";
            
            this.jdbcTemplate.update(sql, usuario.getIdRol(),usuario.getNombre(), usuario.getApellido(),usuario.getCorreo(), usuario.getPassword());
            
            System.out.println("Usuario Insertado Correctamente. ");
            
            return usuario;
            
        }catch(Exception e){
            System.out.println(e);
            
            return null;
        }
    }
    
    
    // EDITAR persona
    public Boolean edit(Usuario usuario){
        System.out.println("Editando Usuario con ID: " + usuario.getIdUsuario());
        
        try{
            String sql = "UPDATE registro.usuarios SET idRol = ?, nombresUsuario = ?, apellidosUsuario = ?, correoUsuario = ?, contrasenaUsuario=? WHERE idUsuario = ?";
            
            this.jdbcTemplate.update(sql, usuario.getIdRol(), usuario.getNombre(), usuario.getApellido(),usuario.getCorreo(), usuario.getPassword(), usuario.getIdUsuario());
            
            System.out.println("Usuario Actualizado Correctamente.");
            
            return true;
            
        }catch(Exception e){
            System.out.println(e);
            
            return false;
        }
    }
    
    
    // ELIMINAR persona
    public Boolean delete(int idUsuario){
        System.out.println("Eliminando usuario con ID: " + idUsuario);
        
        try{
            String sql = "DELETE FROM registro.usuarios WHERE idUsuario = " + idUsuario;
            
            this.jdbcTemplate.update(sql);
            
            System.out.println("Usuario Eliminado Correctamente");
            
            return true;
            
        }catch(Exception e){
            System.out.println(e);
            
            return false;
        }
    }
    
}
