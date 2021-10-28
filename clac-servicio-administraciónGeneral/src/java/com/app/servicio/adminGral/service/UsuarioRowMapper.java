
package com.app.servicio.adminGral.service;

import com.app.servicio.adminGral.domain.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UsuarioRowMapper implements RowMapper<Usuario>{
    
    @Override
    public Usuario mapRow(ResultSet rs, int i) throws SQLException {
        Usuario user = new Usuario();
        
        user.setIdUsuario(rs.getInt("idUsuario"));
        user.setIdRol(rs.getInt("idRol"));
        user.setNombre(rs.getString("nombresUsuario"));
        user.setApellido(rs.getString("apellidosUsuario"));
        user.setCorreo(rs.getString("correoUsuario"));
        user.setPassword(rs.getString("contrasenaUsuario"));
        
        return user;
    }
}
