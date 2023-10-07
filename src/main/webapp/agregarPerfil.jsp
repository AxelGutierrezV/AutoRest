<%-- 
    Document   : agregarPerfil
    Created on : 7 oct. 2023, 02:54:30
    Author     : HJVM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <form action="SvEmpleados" method="post">
            <label>Ingrese el codigo de perfil: </label><input type="number" name="codigo">
            <br>

            <label>Ingrese la categoria del perfil</label><input type="text" name="categoria">
            <br><br><br>
            <input type="submit" value="Agregar Perfil">
        </form>
    </body>
</html>
