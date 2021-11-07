<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Producto</title>
    </head>
    
    <%@include file="nav.jsp" %>
    
    <body>
        </br>
        
        <h1 align="center">Crear Nuevo Producto</h1>
        </br>
        s
        <hr size="4px" style="width:50%; margin: auto; color: black;" />
        </br>

        <c:url var="saveUrl" value="/addProducto" />
        <c:url var="getProducto" value="/getallProducto" />
        
        <div class="container mt-4" align="center">
            <form:form modelAttribute="productoAttribute" method="POST" action="${saveUrl}">
                
                <div class="mb-3">
                    <form:label path="idInformacionComercial" class="form-label">Negocio </form:label>
                    <form:select path="idInformacionComercial" class="form-control" style="width: 30%;" required="true">
                        <c:forEach var="nomNeg" items="${informacionComercialList}">
                            <form:option value="${nomNeg.idInformacionComercial}">${nomNeg.nombreNegocio}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                    
                <div class="mb-3">
                    <form:label path="nombre" class="form-label">Nombre Producto </form:label>
                    <form:input path="nombre" required="true" type="text" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                    <div id="emailHelp" class="form-text"></div>
                </div>
                    
                <div class="mb-3">
                    <form:label path="precioVenta" class="form-label">Precio Venta </form:label>
                    <form:input path="precioVenta" required="true" type="number" step= "0.01" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <div class="mb-3">
                    <form:label path="precioFabricacion" class="form-label">Precio Fabricacion </form:label>
                    <form:input path="precioFabricacion" required="true" type="number" step="0.01" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                
                <button type="submit" class="btn btn-primary">Guardar</button>
                <a href="${getProducto}" class="btn btn-danger">Regresar</a>
            </form:form>
        </div>
        </br>

    </body>
</html>