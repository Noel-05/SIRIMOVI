
package com.app.servicio.adminGral.connect;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conexion {
    
    public DriverManagerDataSource Conectar(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        try{
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/registro?autoReconnect=true&useSSL=false");
            dataSource.setUsername("root");
            dataSource.setPassword("administrador");
            // Por si da error la Url se puede usar también está
            // dataSource.setUrl("jdbc:mysql://localhost:3306/spring_mvc?autoReconnect=true&useSSL=false&useTimezone=true&serverTimezone=UTC");
            System.out.println("Conexión Exitosa a la Base de Datos");
            
            return dataSource;
            
        }catch(Exception e){
            System.out.println("\nConexión a Base de Datos Fallida");
            System.out.println(e);
            
            return null;
        }
    }   
}
