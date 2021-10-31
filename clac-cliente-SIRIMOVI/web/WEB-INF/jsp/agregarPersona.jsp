<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Informacion Financiera</title>
    </head>
    
    <%@include file="nav.jsp" %>
    
    <body>
        </br>
        
        <h1 align="center">Crear Nueva Informacion Financiera</h1>
        </br>
        
        <hr size="4px" style="width:50%; margin: auto; color: black;" />
        </br>

        <c:url var="saveUrl" value="informacionF/add" />
        <c:url var="getPerson" value="/getall" />
        
        <div class="container mt-4" align="center">
            <form:form modelAttribute="informaAttribute" method="POST" action="${saveUrl}">
                <div class="mb-3">
                    <form:label path="idInformacionFinanciera" class="form-label">id Informacion Financiera: </form:label>
                    <form:input path="idInformacionFinanciera" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <div class="mb-3">
                    <form:label path="idInformacionOrganizacional" class="form-label">id Informacion Organizacional </form:label>
                    <form:input path="idInformacionOrganizacional" required="true" type="email" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                    <div id="emailHelp" class="form-text">Tu correo nunca será compartido.</div>
                </div>
                    
                <div class="mb-3">
                    <form:label path="rangoSalariosEmpleados" class="form-label">ranro Salarios Empleados </form:label>
                    <form:input path="rangoSalariosEmpleados" required="true" type="text" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                    
                <div class="mb-3">
                    <form:label path="saldoDeudasActual" class="form-label">Saldo Deudas Actual </form:label>
                    <form:input path="saldoDeudasActual" required="true" type="text" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                
                <div class="mb-3">
                    <form:label path="saldoLiquidez" class="form-label">Saldo Liquidez </form:label>
                    <form:input path="saldoLiquidez" required="true" type="text" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                </div>
                
                <button type="submit" class="btn btn-primary">Guardar</button>
                <a href="${getPerson}" class="btn btn-danger">Regresar</a>
            </form:form>
        </div>

    </body>
</html>