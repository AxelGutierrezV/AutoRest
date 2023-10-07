<%-- 
    Document   : agregarPlatoCategoria
    Created on : 7 oct. 2023, 02:03:26
    Author     : HJVM
--%>

<%@page import="dao.PlatoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            PlatoDAO platoDao = new PlatoDAO();
            int codCategoriaNuevo = platoDao.siguienteCodigoCategoria();
        %>
        <h1>Agregar Categoria Plato, NUEVO CODIGO: <%=codCategoriaNuevo%></h1>

        <br>
        <br>
        <br>

        <form action="SvPlatos" method="post">
            <input type="hidden" name="opc" value="10">
            <input type="hidden" name="codCategoriaNuevo" value="<%=codCategoriaNuevo%>">
            <label>Ingrese nombre de la nueva categoria</label><input type="text" name="nombreNuevaCategoria">
            <br><br>
            <input type="submit" value="Agregar Categoria de plato.">
        </form>
    </body>
</html>
