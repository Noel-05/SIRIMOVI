<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Obtener Producto</title>
    </head>
    
    <%@include file="nav.jsp" %>
    
    <body>
        </br>
        
        <h1 align="center">Obtener Informacion Comercial</h1>
        </br>
        
        <hr size="4px" style="width:50%; margin: auto; color: black;" />
        </br>
        
        <c:url var="getInformacionComercial" value="/getallInformacionComercial" />

        <div class="container mt-4" align="center">
            <c:if test="${empty informacionComercialGetId}">
                No se encontraron Registros!
            </c:if>

            <c:if test="${!empty informacionComercialGetId}">
                <div class="mb-3">
                    <label path="idInformacionOrganizacional" class="form-label"><strong>ID informacion Organizacional </strong></label>
                    <input path="idInformacionOrganizacional" type="number" disabled class="form-control" style="width: 30%; text-align: center;" value="${informacionComercialGetId.idInformacionOrganizacional}"/>
                </div>
                
                <div class="mb-3">
                    <label path="departamentosDeComercioInterior" class="form-label"><strong>Departamento de Comercio Interior: </strong></label>
                    <input path="departamentosDeComercioInterior" type="text" disabled class="form-control" style="width: 30%; text-align: center;" value="${informacionComercialGetId.departamentosDeComercioInterior}"/>
                </div>
                    
                <div class="mb-3">
                    <label path="paisesDeComercioExterior" class="form-label"><strong>Paises de Comercio Exterior </strong></label>
                    <input path="paisesDeComercioExterior" type="text" disabled class="form-control" style="width: 30%; text-align: center;" value="${informacionComercialGetId.paisesDeComercioExterior}"/>
                </div>
                
                <div class="mb-3">
                    <label path="empresasSocias" class="form-label"><strong>Empresas Socias </strong></label>
                    <input path="empresasSocias" type="text" disabled class="form-control" style="width: 30%; text-align: center;" value="${informacionComercialGetId.empresasSocias}"/>
                </div>
                
                <p align="center"><a href="${getInformacionComercial}" class="btn btn-danger">Regresar</a></p>
            </c:if>
        </div>
        </br>

    </body>
</html>
