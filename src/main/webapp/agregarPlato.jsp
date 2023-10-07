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
    </head>
    <body>
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
