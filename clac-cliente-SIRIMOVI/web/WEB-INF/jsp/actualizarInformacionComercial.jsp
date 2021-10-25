<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Informacion Comercial</title>
    </head>
    
    <%@include file="nav.jsp" %>
    
    <body>
        </br>
        
        <h1 align="center">Editar Informacion Comercial</h1>
        </br>
        
        <hr size="4px" style="width:50%; margin: auto; color: black;" />
        </br>

        <c:url var="saveUrl" value="/update?id=${informacionComercialAttribute.id}" />
        <c:url var="getInformacionComercial" value="/getall" />
        
        <div class="container mt-4" align="center">
            <form:form modelAttribute="informacionComercialAttribute" method="POST" action="${saveUrl}">
                <div class="mb-3">
                    <form:label path="idco" class="form-label">id Comercial: </form:label>
                    <form:input path="idco" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                
                <div class="mb-3">
                    <form:label path="idor" class="form-label">id Organzacional: </form:label>
                    <form:input path="idor" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <div class="mb-3">
                    <form:label path="depa" class="form-label"> epartamentos de Comercio Interior: </form:label>
                    <form:input path="depa" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <div class="mb-3">
                    <form:label path="paises" class="form-label">Paises de Comercio Exterior: </form:label>
                    <form:input path="paises" required="true" type="text" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                
                <div class="mb-3">
                    <form:label path="empresas" class="form-label">Empresas Socias: </form:label>
                    <form:input path="empresas" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <button type="submit" class="btn btn-primary">Guardar</button>
                <a href="${getPerson}" class="btn btn-danger">Regresar</a>
                
            </form:form>
        </div>

    </body>
</html>