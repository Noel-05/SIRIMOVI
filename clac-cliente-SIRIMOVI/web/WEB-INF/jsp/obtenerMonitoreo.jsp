<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Obtener Monitoreo</title>
    </head>
    
    <%@include file="nav.jsp" %>
    
    <body>
        </br>
        
        <h1 align="center">Obtener Monitoreo</h1>
        </br>
        
        <hr size="4px" style="width:50%; margin: auto; color: black;" />
        </br>
        
        <c:url var="/get" value="/monitoreosUp" />

        <div class="container mt-4" align="center">
            <c:if test="${empty monitoreoGetId}">
                No se encontraron Registros!
            </c:if>

            <c:if test="${!empty monitoreoGetId}">
                <div class="mb-3">
                    <label path="id" class="form-label"><strong>Id Monitoreo: </strong></label>
                    <input path="id" type="text" disabled class="form-control" style="width: 30%; text-align: center;" value="${monitoreoGetId.idMonitoreo}"/>
                </div>
                
                <div class="mb-3">
                    <label path="idInfo" class="form-label"><strong>Id informacion organizacional: </strong></label>
                    <input path="idInfo" type="text" disabled class="form-control" style="width: 30%; text-align: center;" value="${monitoreoGetId.idMonitoreo}"/>
                </div>
                
                <div class="mb-3">
                    <label path="cantP" class="form-label"><strong>Cantidad de Produccion: </strong></label>
                    <input path="cantP" type="text" disabled class="form-control" style="width: 30%; text-align: center;" value="${monitoreoGetId.cantP}"/>
                </div>
                    
                <div class="mb-3">
                    <label path="cantPer" class="form-label"><strong>Cantidad de perdidas: </strong></label>
                    <input path="cantPer" type="email" disabled class="form-control" style="width: 30%; text-align: center;" value="${monitoreoGetId.cantPer}"/>
                </div>
                    
                <div class="mb-3">
                    <label path="total" class="form-label"><strong>Total ventas: </strong></label>
                    <input path="total" type="text" disabled class="form-control" style="width: 30%; text-align: center;" value="${monitoreoGetId.cantPer}"/>
                </div>
                
                <div class="mb-3">
                    <label path="ganancia" class="form-label"><strong>Ganancias: </strong></label>
                    <input path="ganancia" type="text" disabled class="form-control" style="width: 30%; text-align: center;" value="${monitoreoGetId.ganancia}"/>
                </div>
                
                <p align="center"><a href="${getPerson}" class="btn btn-danger">Regresar</a></p>
            </c:if>
        </div>

    </body>
</html>