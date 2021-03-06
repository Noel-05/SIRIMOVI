<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Bienes</title>
    </head>
    
    <%@include file="nav.jsp" %>
    
    <body>
        </br>
        
        <h1 align="center">Crear Nuevo Bienes</h1>
        </br>
        
        <hr size="4px" style="width:50%; margin: auto; color: black;" />
        </br>

        <c:url var="saveUrl" value="/bienesAdd" />
        <c:url var="getBienes" value="/getallBienes" />
        
        <div class="container mt-4" align="center">
            <form:form modelAttribute="bienesAttribute" method="POST" action="${saveUrl}">
                <div class="mb-3">
                    <form:label path="idInformacionFinanciera" class="form-label">idInformacionFinanciera: </form:label>
                    <form:input path="idInformacionFinanciera" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <div class="mb-3">
                    <form:label path="nombreBien" class="form-label">nombreBien </form:label>
                    <form:input path="nombreBien" required="true" type="text" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                    <div id="emailHelp" class="form-text">Tu correo nunca será compartido.</div>
                </div>
                    
                <div class="mb-3">
                    <form:label path="cantidadBien" class="form-label">cantidadBien </form:label>
                    <form:input path="cantidadBien" required="true" type="text" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <button type="submit" class="btn btn-primary">Guardar</button>
                <a href="${getBienes}" class="btn btn-danger">Regresar</a>
            </form:form>
        </div>

    </body>
</html>