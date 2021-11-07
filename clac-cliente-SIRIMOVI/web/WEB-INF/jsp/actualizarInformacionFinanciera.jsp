<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion Financiera</title>
    </head>
    
    <%@include file="nav.jsp" %>
    
    <body>
        </br>
        
        <h1 align="center">Editar InformacionFinanciera</h1>
        </br>
        
        <hr size="4px" style="width:50%; margin: auto; color: black;" />
        </br>

        <c:url var="saveUrl" value="/updateInformacionFinanciera?id=${inforAttribute.idinformacionFinanciera}" />
        <c:url var="getInfFin" value="/getAllInformacionFinanciera" />
        
        <div class="container mt-4" align="center">
            <form:form modelAttribute="inforAttribute" method="POST" action="${saveUrl}">
                <div class="mb-3">
                    <form:label path="idinformacionOrganizacional" class="form-label">Negocio </form:label>
                    <form:select path="idinformacionOrganizacional" class="form-control" style="width: 30%;" required="true">
                        <c:forEach var="infOrg" items="${informacionOrganizacionalList}">
                            <form:option value="${infOrg.idInfOrganizacional}">${infOrg.nombreNegocio}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                    
                <div class="mb-3">
                    <form:label path="rangoSalariosEmpleados" class="form-label">Rango de Salarios de Empleados </form:label>
                    <form:input path="rangoSalariosEmpleados" required="true" type="text" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                    <div id="emailHelp" class="form-text">Escribirlo de la siguiente manera: Ejemplo: $300.00 - $1,000.00</div>
                </div>
                
                <div class="mb-3">
                    <form:label path="saldoDeudasActual" class="form-label">Saldo de Deudas Actual </form:label>
                    <form:input path="saldoDeudasActual" required="true" type="number" step= "0.01" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                
                <div class="mb-3">
                    <form:label path="saldoLiquidez" class="form-label">Saldo de Liquidez Actual</form:label>
                    <form:input path="saldoLiquidez" required="true" type="number" step= "0.01" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <button type="submit" class="btn btn-primary">Guardar</button>
                <a href="${getInfFin}" class="btn btn-danger">Regresar</a>
                
            </form:form>
        </div>
        </br>

    </body>
</html>