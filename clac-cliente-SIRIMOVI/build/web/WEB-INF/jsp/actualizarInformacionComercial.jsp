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

        <c:url var="saveUrl" value="/updateInformacionComercial?id=${informacionComercialAttribute.idInformacionComercial}" />
        <c:url var="getInformacionComercial" value="/getallInformacionComercial" />
        
        <div class="container mt-4" align="center">
            <form:form modelAttribute="informacionComercialAttribute" method="POST" action="${saveUrl}">
                <div class="mb-3">
                    <form:label path="idInformacionOrganizacional" class="form-label">Negocio </form:label>
                    <form:select path="idInformacionOrganizacional" class="form-control" style="width: 30%;" required="true">
                        <c:forEach var="infOrg" items="${InformacionOrganizacionalList}">
                            <form:option value="${infOrg.idInfOrganizacional}">${infOrg.nombreNegocio}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                    
                <div class="mb-3">
                    <form:label path="departamentosDeComercioInterior" class="form-label"> Departamentos de Comercio Interior: </form:label>
                    <form:input path="departamentosDeComercioInterior" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <div class="mb-3">
                    <form:label path="paisesDeComercioExterior" class="form-label">Paises de Comercio Exterior: </form:label>
                    <form:input path="paisesDeComercioExterior" type="text" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                
                <div class="mb-3">
                    <form:label path="empresasSocias" class="form-label">Empresas Socias: </form:label>
                    <form:input path="empresasSocias" type="text" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <button type="submit" class="btn btn-primary">Guardar</button>
                <a href="${getInformacionComercial}" class="btn btn-danger">Regresar</a>
                
            </form:form>
        </div>

    </body>
</html>