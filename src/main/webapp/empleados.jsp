<%-- 
    Document   : platos
    Created on : Sep 21, 2023, 8:27:45 PM
    Author     : Axel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "dao.EmpleadoDAO, modelo.Empleado" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/boton.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

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
                                <a class="nav-link" aria-current="page" href="main.jsp">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Ordenes</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Comandas</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown" aria-current="page" aria-expanded="false">Administración</a>
                                <ul class="dropdown-menu">
                                    <li><a class="nav-link active"  aria-current="page" href="#">Empleados</a></li>
                                    <a class="nav-link" href="platos.jsp">Platos</a>
                                </ul>
                            </li>
                        </ul>
                        <a href="login.jsp"><button class="btn btn-danger" type="submit">Cerrar Sesion</button></a>
                    </div>
                </div>
            </nav>
        </header>

        <%
            EmpleadoDAO obj = new EmpleadoDAO();
        %>
        <div>
            <a class="basico basicoRedondoTitulo basicoRedondo boton-link-azul" href="SvEmpleados?opc=1">Nuevo Empleado</a>
            <a class="basico basicoRedondoTitulo basicoRedondo boton-link-azul" href="SvEmpleados?opc=2">Nuevo Perfil</a>
        </div>
        <br>
        <nav>
            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true">Empleados</button>
                <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Perfiles</button>
            </div>
        </nav>
        <div class="tab-content" id="nav-tabContent">
            <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0">
                <table class="table table-bordered">
                    <th>Codigo de Empleado<th>Nombre<th>Estado<th>Cargo<th>Editar / Eliminar
                        <%
                            for (Empleado e : obj.empleados()) {
                                out.print("<tr><td>" + e.getCodEmpleado() + "<td>" + e.getNombre() + " " + e.getApellido() + "<td>" + e.estadoNombre() + "<td>" + e.getPerfil() + "<td>");
                        %>
                        
                        <button class="btn-outline-primary">editar</button>
                        <button class="btn-danger">eliminar</button>
                        <%
                            }
                        %>
                </table>
            </div>
            <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab" tabindex="0">
                <table class="table table-bordered">
                    <tr><th>Codigo<th>Categoria<th><th style="text-align: center;">Editar<th style="text-align: center;">Delete 
                            <%
                                for (Empleado p : obj.PerfilesEmpleados()) {
                                    out.print("<tr><td>" + p.getCodPerfil() + "<td>" + p.getPerfil() + "<td>");
                            %>
                        <td style="text-align: center;">
                            
                            <form>
                                <input type="hidden" name="codPerfil" value="<%= p.getCodPerfil()%>">
                                <input type="submit" class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offCanvasEditarPerfil" aria-controls="offCanvasEditarPerfil" value="Editar">
                            </form>
                        </td>

                        <td style="text-align: center;">
                            <a href="SvEmpleados?opc=3&nro=<% out.print(p.getCodPerfil());  %>" class="btn btn-default">delete</a> 
                        </td> 
                        <%
                            }
                        %>
                </table>
            </div>
        </div>
        <div class="offcanvas offcanvas-bottom" tabindex="-1" id="offCanvasEditarPerfil" aria-labelledby="offcanvasBottomLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasBottomLabel">Editar Perfil</h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body small">
                <form>
                    <%
                        Empleado pr = obj.getPerfilEmpleado(1);
                        String i = request.getParameter("codPerfil");
                        out.print("<input type=\"text\" value=\"" + i+ "\">");
                    %>
                    <a href="SvEmpleados?opc=4&nro=<% out.print(pr.getCodPerfil());%>" class="btn btn-default">Editar</a>  
                </form>
            </div>
        </div>
        <div class="offcanvas offcanvas-bottom" tabindex="-1" id="offCanvasAddPerfil" aria-labelledby="offcanvasBottomLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasBottomLabel">Añadir Perfil</h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body small">
                <form>
                    AQUI VA EL FORMULARIO PARA AÑADIR PERFILES
                    <input type="submit" value="enviar">
                </form>
            </div>
        </div>
    </body>
</html>
