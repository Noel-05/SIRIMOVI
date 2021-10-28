<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Anton">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Italianno">
        <link rel="stylesheet" href="<c:url value='/img/css/estilo.css'/>" >
        <title>SIRIMOVI | Inicio</title>
        <style>
            .texto {
                font-family: Times New Roman;
            }

            .texto2 {
                font-family: 'Tangerine', serif;
            }

            .texto3 {
                font-family: 'Anton', serif;
            }

            .texto4 {
                font-family: 'Italianno', serif;
            }
        </style>
    </head>
    
<!--    Times New Roman, Georgia, Arial, Verdana, Courier New, Lucida, Console-->
    
    <%@include file="nav.jsp" %>

    <body>
        
        </br></br>
        <h1 align="center" class="texto"><strong>SIRIMOVI | CLAC</strong></h1>
        
        </br>
        <h2 align="center" class="texto">Sistema de Recolecci&oacute;n de Informaci&oacute;n de Monitoreo y Visitas</h2>
        
        <h3 align="center" class="texto2"><i><strong>Coordinadora Latinoamericana y del Caribe de Pequeños Productores de Comercio Justo</strong></i></h3>
        
        </br></br>
        <div align="center">
            <img src="<c:url value='/img/CLAC.png'/>" width="15%" height="15%"/>
        </div>
        
    </body>
</html>
