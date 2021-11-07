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
        
        <h1 align="center">Obtener Producto</h1>
        </br>
        
        <hr size="4px" style="width:50%; margin: auto; color: black;" />
        </br>
        
        <c:url var="getProducto" value="/getallProducto" />

        <div class="container mt-4" align="center">
            <c:if test="${empty productoGetId}">
                No se encontraron Registros!
            </c:if>

            <c:if test="${!empty productoGetId}">
                <div class="mb-3">
                    <label path="nombre" class="form-label"><strong>Nombre Producto </strong></label>
                    <input path="nombre" type="text" disabled class="form-control" style="width: 30%; text-align: center;" value="${productoGetId.nombre}"/>
                </div>
                
                <div class="mb-3">
                    <label path="nombreNegocio" class="form-label"><strong>Id Informacion Comercial: </strong></label>
                    <input path="nombreNegocio" type="text" disabled class="form-control" style="width: 30%; text-align: center;" value="${productoGetId.nombreNegocio}"/>
                </div>
                    
                <div class="mb-3">
                    <label path="precioVenta" class="form-label"><strong>Precio Venta </strong></label>
                    <input path="precioVenta" type="number" disabled class="form-control" style="width: 30%; text-align: center;" value="${productoGetId.precioVenta}"/>
                </div>
                
                <div class="mb-3">
                    <label path="precioFabricacion" class="form-label"><strong>Precio Fabricacion </strong></label>
                    <input path="precioFabricacion" type="number" disabled class="form-control" style="width: 30%; text-align: center;" value="${productoGetId.precioFabricacion}"/>
                </div>
                
                <p align="center"><a href="${getProducto}" class="btn btn-danger">Regresar</a></p>
            </c:if>
        </div>
        </br>

    </body>
</html>
