<%-- 
    Document   : nuevaOrden
    Created on : Sep 25, 2023, 11:40:34 PM
    Author     : Axel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Orden</title>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <script src="scripts/snippets.js" type="text/javascript"></script>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg bg-gradient-yellow cabecera">
                <div class="container">
                    <a class="navbar-brand" href="main.php">
                        <img src="img/logo resturante.png" alt="Bootstrap" width="130" height="80">
                    </a>
                </div>
                <div class="container-fluid">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse textoCabecera" id="navbarNavDropdown">
                        <ul class="navbar-nav ">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="Ordenes.jsp">Ordenes</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Comandas</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Administración</a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="empleados.jsp">Empleados</a></li>
                                    <li><a class="dropdown-item" href="platos.jsp">Platos</a></li>
                                    <li><a class="dropdown-item" href="mesas.jsp">Mesas</a></li>
                                </ul>
                            </li>

                        </ul>
                        <a href="login.php"><button class="btn btn-danger" type="submit">Cerrar Sesion</button></a>
                    </div>
                </div>
            </nav>
        </header>
        <form>
            seleccionar mesa<br>
            añadir platos<br>
            enviar<br>
        </form>


        <div>
            <nav>
                <div class="nav nav-pills" id="nav-tab" role="tablist">
                    <button class="nav-link" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true">BRASA</button>
                    <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Perfiles</button>
                </div>
            </nav>
            <div id="nav-tabContent">
                <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0">
                    <table class="table table-bordered">
                        <th>Codigo de Empleado<th>Nombre<th>Estado<th>Cargo 
                            
                    </table>
                </div>
                <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab" tabindex="0">
                    <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0">
                        <table class="table table-bordered">
                            <th>Codigo<th>Categoria 

                                <button class="btn-outline-primary">editar</button>
                            <td style="width: 10%;align-content: flex-end">
                                <button class="btn-danger">eliminar</button>

                        </table>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
