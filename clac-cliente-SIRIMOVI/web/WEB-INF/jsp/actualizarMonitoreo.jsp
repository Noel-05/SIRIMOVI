<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Monitoreo</title>
    </head>
    
    <%@include file="nav.jsp" %>
    
    <body>
        </br>
        
        <h1 align="center">Editar Monitoreo</h1>
        </br>
        
        <hr size="4px" style="width:50%; margin: auto; color: black;" />
        </br>

        <c:url var="saveUrl" value="/update?id=${monitoreoAttribute.id}" />
        <c:url var="getMonitoreo" value="/getall" />
        
        <div class="container mt-4" align="center">
            <form:form modelAttribute="monitoreoAttribute" method="POST" action="${saveUrl}">
                <div class="mb-3">
                    <form:label path="id" class="form-label">id Monitoreo: </form:label>
                    <form:input path="id" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                
                <div class="mb-3">
                    <form:label path="idInfo" class="form-label">id informacion organzacional: </form:label>
                    <form:input path="idInfo" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <div class="mb-3">
                    <form:label path="cantP" class="form-label"> Cantidad de produccion: </form:label>
                    <form:input path="cantP" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <div class="mb-3">
                    <form:label path="cantPer" class="form-label">Cantidad de perdida: </form:label>
                    <form:input path="cantPer" required="true" type="text" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                
                <div class="mb-3">
                    <form:label path="total" class="form-label">Total de ventas: </form:label>
                    <form:input path="total" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                
                <div class="mb-3">
                    <form:label path="ganancia" class="form-label">Ganancias: </form:label>
                    <form:input path="ganancia" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <button type="submit" class="btn btn-primary">Guardar</button>
                <a href="${getPerson}" class="btn btn-danger">Regresar</a>
                
            </form:form>
        </div>

    </body>
</html>