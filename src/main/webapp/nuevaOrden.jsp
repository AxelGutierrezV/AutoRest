<%-- 
    Document   : nuevaOrden
    Created on : Sep 25, 2023, 11:40:34 PM
    Author     : Axel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.PlatoDAO, modelo.Plato"%>
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

        </form>
        <%
            PlatoDAO obj = new PlatoDAO();
        %>
        <br><center><h2>Seleccion de platos</h2></center><br>
        <div class ="row">
            <div class="col-sm-9">
                <nav>
                    <div class="nav nav-pills" id="nav-tab" role="tablist">
                        <%
                            for (Plato p : obj.listarCategorias()) {
                                out.print("<button class=\"nav-link\" id=\"nav-"
                                            + p.getCatNombre() + "-tab\" data-bs-toggle=\"tab\" data-bs-target=\"#nav-" + p.getCatNombre()
                                            + "\" type=\"button\" role=\"tab\" aria-controls=\"nav-home\" aria-selected=\"true\">" + p.getCatNombre() + "</button>");
                            }
                        %>

                    </div>
                </nav>
                <div class="tab-content" id="nav-tabContent">
                    <%
                        for (Plato p : obj.listarCategorias()) {
                            out.print("<div class=\"tab-pane fade\" id=\"nav-" + p.getCatNombre()
                                        + "\" role=\"tabpanel\" aria-labelledby=\"nav-" + p.getCatNombre() + "-tab\" tabindex=\"0\">");

                            out.print("<table class=\"table table-bordered\">");
                            out.print("<tr><th>Codigo de Plato<th>Nombre<th>Precio<th>");
                    %>

                    <%
                        for (Plato pl : obj.listaPlatosPorCategoria(p.getCodCat())) {
                            out.print("<tr><td class=\"col-sm-2\">" + pl.getCodPlato() + "<td>" + pl.getNombre() + "<td>" + pl.getPrecio() + "<td>");
                    %>
                    <center><button class="btn-success">+</button></center>
                        <%
                            }
                        %>
                        <%
                                out.print("</table>");
                                out.print("</div>");
                            }
                        %>
                </div>
            </div>
            <div class="col-sm-3">
                <h4>Detalle de Orden</h4>
                <table class="table table-bordered">
                    <tr><th>Plato<th>Cantidad<th>Precio</tr> 
                </table>
                <br>codigo para añadir platos


            </div>
        </div>
    </body>
</html>
