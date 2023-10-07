<%-- 
    Document   : platos
    Created on : Sep 21, 2023, 8:27:45 PM
    Author     : Axel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "dao.PlatoDAO, modelo.Plato" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Platos</title>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
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
                                <a class="nav-link" aria-current="page" href="main.php">Inicio</a>
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
                                    <li><a class="nav-link" href="empleados.jsp">Empleados</a></li>
                                    <a class="nav-link active" aria-current="page" href="platos.jsp">Platos</a>
                                </ul>
                            </li>
                        </ul>
                        <a href="login.php"><button class="btn btn-danger" type="submit">Cerrar Sesion</button></a>
                    </div>
                </div>
            </nav>
        </header>
        <%
            PlatoDAO obj = new PlatoDAO();
        %>
        <div>
            <a href="SvPlatos?opc=7">Agregar Plato</a>
            <a href="SvPlatos?opc=9">Agregar Categoria Platos</a>

            <button type="button" class="btn btn-primary btn-sm">Agregar Plato</button>
            <button type="button" class="btn btn-primary btn-sm">Agregar Categoria</button>
        </div>
        <div>
            <nav>
                <div class="nav nav-tabs" id="nav-tab" role="tablist">
                    <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true">Platos</button>
                    <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Categorias</button>
                </div>
            </nav>
            <div class="tab-content" id="nav-tabContent">
                <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0">
                    <table class="table table-bordered">
                        <th class="col-sm-1">Codigo de Plato<th>Plato<th>Precio<th>Categoria<th>Editar<th>Eliminar</th>
                            <%
                                for (Plato p : obj.listaPlatosConCategoria()) {
                                    out.print("<tr><td>" + p.getCodPlato() + "<td>" + p.getNombre() + "<td>" + p.getPrecio() + "<td>" + p.getCatNombre());
                            %>
                        <td><a href="SvPlatos?opc=4&codigoPlato=<%=p.getCodPlato()%>">Editar</a></td>
                        <td><a href="SvPlatos?opc=6&codigoPlato=<%=p.getCodPlato()%>">Eliminar</a></td>
                        <%
                            }
                        %>
                    </table>
                </div>
                <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab" tabindex="0">
                    <table class="table table-bordered">
                        <th>Codigo<th>Categoria 
                            <%
                                for (Plato p : obj.listarCategorias()) {
                                    out.print("<tr><td>" + p.getCodCat() + "<td>" + p.getCatNombre() + "<td>");%>
                            <a class="btn-outline-primary" href="SvPlatos?opc=1&codigoPlatoCategoria=<%=p.getCodCat()%>">Editar</a>
                            <a class="btn-danger" href="SvPlatos?opc=2&codigoPlatoCategoria=<%=p.getCodCat()%>">Eliminar</a>
                            <%
                                }
                            %>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
