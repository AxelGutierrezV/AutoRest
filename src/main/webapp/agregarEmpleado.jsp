<%-- 
    Document   : agregarEmpleado
    Created on : 7 oct. 2023, 02:45:50
    Author     : HJVM
--%>

<%@page import="modelo.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="dao.EmpleadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            EmpleadoDAO empDao = new EmpleadoDAO();
            List<Empleado> empleados = empDao.listarPerfiles();
        %>

        <h1>Bienvenido a NUEVO EMPLEADO!!!</h1>

        <form action="SvEmpleados" method="post">
            
            <input type="hidden" name="opc" value="3">
            
            <label>CODIGO DEL NUEVO EMPLEADO: </label>
            <input type="number" name="codigoEmpleaado" required="true">
            <br><br>

            <label>NOMBRE DEL EMPLEADO: </label>
            <input type="text" name="nombreEmpleado" required="true">
            
            <br><br>
            
            <label>APELLIDO DEL EMPLEADO: </label>
            <input type="text" name="apellidoEmpleado" required="true">
            
            <br><br>
            
            <label>CONTRASEÑA DEL EMPLEADO: </label>
            <input type="password" name="pass" required="true">
            
            <br><br>
            
            <label>Estado: </label>
            <select name="estado">
                <option value="1">ACTIVO</option>
                <option value="2">INACTIVO</option>
            </select>

            <br><br>
            
            <label>Cargo: </label>
            <select name="cargo">
                <%
                    for (Empleado empleado : empleados) {
                %>
                <option value="<%=empleado.getCodPerfil()%>"><%=empleado.getPerfil()%></option>
                <%
                    }
                %>
            </select>
            
            <br><br>
            <input type="submit" value="Agregar Empleado">
        </form>

    </body>
</html>
