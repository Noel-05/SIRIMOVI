<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Monitoreo</title>
    </head>
    
    <%@include file="nav.jsp" %>
    
    <body>
        </br>
        
        <h1 align="center">Crear Nuevo Monitoreo</h1>
        </br>
        
        <hr size="4px" style="width:50%; margin: auto; color: black;" />
        </br>

        <c:url var="saveUrl" value="/monitoreosAdd" />
        <c:url var="getMonitoreo" value="/getallMonitoreos" />
        
        <div class="container mt-4" align="center">
            <form:form modelAttribute="monitoreoAttribute" method="POST" action="${saveUrl}">
                
                <div class="mb-3">
                    <form:label path="idInfo" class="form-label">Negocio </form:label>
                    <form:select path="idInfo" class="form-control" style="width: 30%;" required="true">
                        <c:forEach var="nomNeg" items="${informacionOrganizacionalList}">
                            <form:option value="${nomNeg.idInfOrganizacional}">${nomNeg.nombreNegocio}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                
                <div class="mb-3">
                    <form:label path="cantidadProduccion" class="form-label">Cantidad de produccion: </form:label>
                    <form:input path="cantidadProduccion" type="number" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <div class="mb-3">
                    <form:label path="cantidadPerdidas" class="form-label">Cantidad de perdidas: </form:label>
                    <form:input path="cantidadPerdidas" type="number" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <div class="mb-3">
                    <form:label path="totalVentas" class="form-label">Total de ventas: </form:label>
                    <form:input path="totalVentas" requtotalVentasired="true" type="number" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                
                <div class="mb-3">
                    <form:label path="ganancia" class="form-label">Ganancias: </form:label>
                    <form:input path="ganancia" type="text" required="number" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <button type="submit" class="btn btn-primary">Guardar</button>
                <a href="${getMonitoreo}" class="btn btn-danger">Regresar</a>
            </form:form>
        </div>

    </body>
</html>