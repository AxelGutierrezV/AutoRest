<%-- 
    Document   : agregarPlato
    Created on : 7 oct. 2023, 00:15:36
    Author     : HJVM
--%>

<%@page import="modelo.Plato"%>
<%@page import="java.util.List"%>
<%@page import="dao.PlatoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Plato</title>
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
                    <a class="navbar-brand" href="main.jsp">
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
                        <a href="login.jsp"><button class="btn btn-danger" type="submit">Cerrar Sesion</button></a>
                    </div>
                </div>
            </nav>
        </header>
        <%
            PlatoDAO platoDao = new PlatoDAO();
            List<Plato> nombresDeCategorias = platoDao.listarNombresYCodigosDeCategorias();
        %>
        <h1>Agregar Plato, NUEVO CODIGO: <%=platoDao.siguienteCodigoPlato()%></h1>

        <form action="SvPlatos" method="get">
            <input type="hidden" name="opc" value="8">
            <label>Ingrese nombre del plato: </label> <input type="text" name="nombrePlato" required="true"><br><br>
            <label>Precio del plato: </label> <input type="number" name="precio" required="true">

            <br><br>

            <label>Estado</label>
            <select name="estado">
                <option value="A">Activo</option>
            </select>

            <br><br>

            <label>Categoria: </label>
            <select name="categoria">
                <%
                    for (Plato p : nombresDeCategorias) {
                %>
                <option value="<%=p.getCodCat()%>"><%=p.getCatNombre()%></option>
                <%
                    }
                %>
            </select>

            <br><br>

            <label>Imagen: </label><input type="file" name="imagen">

            <br><br><br>

            <input type="submit" value="Agregar Plato">

        </form>
    </body>
</html>
