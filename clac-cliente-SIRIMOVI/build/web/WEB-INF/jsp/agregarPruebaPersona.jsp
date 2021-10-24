<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Persona</title>
    </head>
    
    <%@include file="nav.jsp" %>
    
    <body>
        </br>
        
        <h1 align="center">Crear Nueva Persona PRUEBA</h1>
        </br>
        
        <hr size="4px" style="width:50%; margin: auto; color: black;" />
        </br>

        <c:url var="saveUrl" value="/addPrueba" />
        <c:url var="getPerson" value="/getallPrueba" />
        
        <div class="container mt-4" align="center">
            <form:form modelAttribute="pruebaPersonaAttribute" method="POST" action="${saveUrl}">
                <div class="mb-3">
                    <form:label path="nombreMascota" class="form-label">Nombre Mascota: </form:label>
                    <form:input path="nombreMascota" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <div class="mb-3">
                    <form:label path="cantidadMascota" class="form-label">Cantidad </form:label>
                    <form:input path="cantidadMascota" required="true" type="text" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <div class="mb-3">
                    <form:select path="persona" class="form-label">
                        <c:forEach var="persn" items="${pruebaPersona}">
                            <form:option value="${persn.id}">${persn.nom}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                    
                <button type="submit" class="btn btn-primary">Guardar</button>
                <a href="${getPerson}" class="btn btn-danger">Regresar</a>
            </form:form>
        </div>

    </body>
</html>