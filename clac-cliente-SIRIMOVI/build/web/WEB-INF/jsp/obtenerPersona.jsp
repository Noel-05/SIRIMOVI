<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Obtener Persona</title>
    </head>
    
    <%@include file="nav.jsp" %>
    
    <body>
        </br>
        
        <h1 align="center">Obtener Producto</h1>
        </br>
        
        <hr size="4px" style="width:50%; margin: auto; color: black;" />
        </br>
        
        <c:url var="getPerson" value="/getallperson" />

        <div class="container mt-4" align="center">
            <c:if test="${empty personaGetId}">
                No se encontraron Registros!
            </c:if>

            <c:if test="${!empty productoGetId}">
                <div class="mb-3">
                    <label path="id" class="form-label"><strong>ID: </strong></label>
                    <input path="id" type="text" disabled class="form-control" style="width: 30%; text-align: center;" value="${personaGetId.id}"/>
                </div>
                
                <div class="mb-3">
                    <label path="nom" class="form-label"><strong>Nombre: </strong></label>
                    <input path="nom" type="text" disabled class="form-control" style="width: 30%; text-align: center;" value="${personaGetId.nom}"/>
                </div>
                    
                <div class="mb-3">
                    <label path="correo" class="form-label"><strong>Correo </strong></label>
                    <input path="correo" type="email" disabled class="form-control" style="width: 30%; text-align: center;" value="${personaGetId.correo}"/>
                </div>
                    
                <div class="mb-3">
                    <label path="nacio" class="form-label"><strong>Nacionalidad </strong></label>
                    <input path="nacio" type="text" disabled class="form-control" style="width: 30%; text-align: center;" value="${personaGetId.nacio}"/>
                </div>
                
                <p align="center"><a href="${getPerson}" class="btn btn-danger">Regresar</a></p>
            </c:if>
        </div>

    </body>
</html>