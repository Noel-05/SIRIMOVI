<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIRIMOVI | Monitoreo</title>
<!--        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>-->
    </head>
    
    <%@include file="nav.jsp" %>

    <body>
        </br>
        
        <c:url var="addUrl" value="/monitoreosAdd" />
        
        <h1 align="center">Consulta de Monitoreos</h1>
        </br>
        
        <hr size="4px" style="width:50%; margin: auto; color: black;" />
        </br>
        
        <p align="center"><a href="${addUrl}" class="btn btn-success"> Agregar </a></p>
        
        <i class="bi bi-trash-fill"></i>
        
        <div class="container mt-4">
            <div class="card border-dark">
                <div class="card-header bg-dark text-white" align="center">
                    Monitoreos
                </div>
                
                <div class="card-body">
                    <table class="table table-hover text-center">
                        
                        <thead>
                            <tr>
                                <th class="text-center" style="color:red"><strong> Id inf. organizacional </strong></th>
                                <th class="text-center" style="color:red"><strong> Cantidad de Producci&oacute;n </strong></th>
                                <th class="text-center" style="color:red"><strong> Cantidad de Perdidas </strong></th>
                                <th class="text-center" style="color:red"><strong> Total de ventas </strong></th>
                                <th class="text-center" style="color:red"><strong> Ganancias </strong></th>
                            </tr>
                        </thead>
                        
                        <tbody>
                            <c:forEach var="monitoreo" items="${monitoreosGetAll}">
                                <c:url var="editUrl" value="/updateMonitoreo?id=${monitoreo.idMonitoreo}" />
                                <c:url var="deleteUrl" value="" />
                                <c:url var="getUrl" value="" />
                                
                                <tr>
                                    <td><c:out value="${monitoreo.idInfo}" /></td>
                                    <td><c:out value="${monitoreo.cantidadProduccion}" /></td>
                                    <td><c:out value="${monitoreo.cantidadPerdidas}" /></td>
                                    <td><c:out value="${monitoreo.totalVentas}" /></td>
                                    <td><c:out value="${monitoreo.ganancia}" /></td>
                                    <td>
                                        <a href="${editUrl}" class="btn btn-warning btn-sm" title="Editar Monitoreo"> 
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
                                            <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
                                            </svg>
                                        </a>

                                        <a href="${deleteUrl}" class="btn btn-danger btn-sm" title="Eliminar Monitoreo" onclick="return confirm('??Seguro que desea eliminar est?? registro?')"> 
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
                                            <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
                                            </svg>
                                        </a>
                                            
                                        <a href="${getUrl}" class="btn btn-primary btn-sm" title="Consultar Monitoreo">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-card-list" viewBox="0 0 16 16">
                                                <path d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
                                                <path d="M5 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 5 8zm0-2.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm0 5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm-1-5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0zM4 8a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0zm0 2.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0z"/>
                                            </svg>
                                        </a>
                                    </td>
                                </tr>
                                
                            </c:forEach>
                        </tbody>
                        
                    </table>
                </div>
            </div>
        </div>

        <c:if test="${empty monitoreosGetAll}" >
            No hay monitoreos en la Base de Datos. Puedes <a href="${addUrl}">Agregar</a> una monitoreo.
        </c:if>
            
    </body>
</html>