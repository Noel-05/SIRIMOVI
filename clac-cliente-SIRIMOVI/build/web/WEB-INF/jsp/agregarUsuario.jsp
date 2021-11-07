<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Usuario</title>
    </head>
    
    <%@include file="nav.jsp" %>
    
    <body>
        </br>
        
        <h1 align="center">Crear Nuevo Usuario</h1>
        </br>
        
        <hr size="4px" style="width:50%; margin: auto; color: black;" />
        </br>

        <c:url var="saveUrl" value="/addUsuarios" />
        <c:url var="getUser" value="/getallUsuarios" />
        
        <div class="container mt-4" align="center">
            <form:form modelAttribute="usuarioAttribute" method="POST" action="${saveUrl}">
                
                <div class="mb-3">
                    <form:label path="nombre" class="form-label">Nombres: </form:label>
                    <form:input path="nombre" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                    <div id="emailHelp" class="form-text">NO utilizar tildes ni el caracter Ñ.</div>
                </div>
                
                <div class="mb-3">
                    <form:label path="apellido" class="form-label">Apellidos: </form:label>
                    <form:input path="apellido" type="text" required="true" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                    <div id="emailHelp" class="form-text">NO utilizar tildes ni el caracter Ñ.</div>
                </div>
                
                <div class="mb-3">
                    <form:label path="idRol" class="form-label">Rol: </form:label>
                    <form:select path="idRol" class="form-control" style="width: 30%;" required="true">
                        <c:forEach var="nomRol" items="${rolList}">
                            <form:option value="${nomRol.idRol}">${nomRol.nombreRol}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                    
                <div class="mb-3">
                    <form:label path="correo" class="form-label">Correo: </form:label>
                    <form:input path="correo" required="true" type="email" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                    <div id="emailHelp" class="form-text">Tu correo nunca será compartido.</br>NO utilizar tildes ni el caracter Ñ.</div>
                </div>
                    
                <div class="mb-3">
                    <form:label path="password" class="form-label">Contraseña: </form:label>
                    <form:input path="password" required="true" type="password" class="form-control" aria-describedby="emailHelp" style="width: 30%;"/>
                    <div id="emailHelp" class="form-text">NO utilizar tildes ni el caracter Ñ.</div>
                </div>
                    
                <button type="submit" class="btn btn-primary">Guardar</button>
                <a href="${getUser}" class="btn btn-danger">Regresar</a>
            </form:form>
        </div>
        </br>

    </body>
</html>
