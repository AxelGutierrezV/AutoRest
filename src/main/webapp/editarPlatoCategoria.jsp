<%-- 
    Document   : editarPlatoCategoria
    Created on : 6 oct. 2023, 22:56:49
    Author     : HJVM
--%>

<%@page import="modelo.Plato"%>
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
            Plato platoCategoria = (Plato)request.getAttribute("platoCategoria");
        %>
        <h1>Editar Categoria Plato</h1>
        <h2>Nombre de la categoria del plato anterior: <%=platoCategoria.getCatNombre()%></h2>
        
        <form action="SvPlatos" method="post">
            <input type="hidden" name="opc" value="3">
            <input type="hidden" name="codigoPlatoCategoria" value="<%=platoCategoria.getCodCat()%>">
            <label>Ingrese nombre de categoría: </label> <input type="text" name="nombreCategoria" required="true"><br><br>
            <input type="submit" value="Modificar">
        </form>
    </body>
</html>
