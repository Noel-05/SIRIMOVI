<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </head>
    
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            
            <c:url var="getPerson" value="/getall" />
            <c:url var="home" value="/" />
            <c:url var="prueba" value="/getallPrueba" />
                
            <div class="container-fluid">
                
                <a class="navbar-brand" href="${home}" >
                    <img src="<c:url value='/img/CLAC-SFC21.png'/>" width="18%" height="18%"/>
                    <strong>&nbsp; &nbsp; &nbsp;SIRIMOVI</strong>
                </a>
                
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        
                        <a class="nav-link active" aria-current="page" href="${home}">Inicio</a>
                        
                        <a class="nav-link" href="${getPerson}">Personas</a>
                        
                        <a class="nav-link" href="${prueba}">Prueba</a>
                        
                        <a class="nav-link" href="">Monitoreos</a>
                        
                        <a class="nav-link disabled">Visitas</a>
                    
                    </div>
                </div>
            </div>
        </nav>
    </body>
</html>