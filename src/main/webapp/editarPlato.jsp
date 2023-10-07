<%-- 
    Document   : editarPlato
    Created on : Oct 6, 2023, 10:18:53 PM
    Author     : Axel
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
            Plato plato = (Plato)request.getAttribute("plato");
        %>
        
        <h1>Editar plato</h1>
        <h2>Nombre del plato anterior: <%=plato.getNombre()%></h2>
        
        <form action="SvPlatos" method="post">
            <input type="hidden" name="opc" value="5">
            <input type="hidden" name="codigoPlato" value="<%=plato.getCodPlato()%>">
            <label>Ingrese nombre del plato: </label> <input type="text" name="nombrePlato" required="true"><br><br>
            <input type="submit" value="Modificar">
        </form>
    </body>
</html>
