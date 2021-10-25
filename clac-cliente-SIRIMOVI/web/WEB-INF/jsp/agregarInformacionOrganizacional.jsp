<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Información Organizacional</title>
    </head>
    
    <%@include file="nav.jsp" %>
    
    <body>
        </br>
        
        <h1 align="center">Crear Nueva Información Organizacional</h1>
        </br>
        
        <hr size="4px" style="width:50%; margin: auto; color: black;" />
        </br>

        <c:url var="saveUrl" value="/add" />
        <c:url var="getPerson" value="/getall" />
        
        <div class="container mt-4" align="center">
            <form:form modelAttribute="informacionOrganizacionalAttribute" method="POST" action="${saveUrl}">
                
              <div class="mb-3">
                    <form:label path="idInformacionOrganizacional" class="form-label">Id Informacion Organizacional: </form:label>
                    <form:input path="idInformacionOrganizacional" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
             
              <div class="mb-3">
                    <form:label path="idRubro" class="form-label">Id Rubro: </form:label>
                    <form:input path="idRubro" required="true" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;" />
                    
                </div>
                    
                <div class="mb-3">
                    <form:label path="nombreNegocio" class="form-label">Nombre de negocio: </form:label>
                    <form:input path="nombreNegocio" required="true" type="text" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                
                <div class="mb-3">
                    <form:label path="cantidadEmpleados" class="form-label">Cantidad de empleados: </form:label>
                    <form:input path="cantidadEmpleados" required="true" type="text" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                
                  <div class="mb-3">
                    <form:label path="direccionNegocio" class="form-label">Direccion del negocio: </form:label>
                    <form:input path="direccionNegocio" required="true" type="text" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                   
                <div class="mb-3">
                    <form:label path="cantidadSucursales" class="form-label">Cantidad de sucursales: </form:label>
                    <form:input path="cantidadSucursales" required="true" type="text" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>

               
                <button type="submit" class="btn btn-primary">Guardar</button>
                <a href="${getPerson}" class="btn btn-danger">Regresar</a>
            </form:form>
        </div>

    </body>
</html>