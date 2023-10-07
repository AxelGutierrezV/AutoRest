/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.EmpleadoDAO;
/**
 *
 * @author Axel
 */
public class SvEmpleados extends HttpServlet {

    EmpleadoDAO obj = new EmpleadoDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int op=Integer.parseInt(request.getParameter("opc"));
        if(op==3)deletePerfil(request,response);
    }

    protected void addPerfil(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("nro"));
        obj.deletePerfil(nro);
        String pag = "/empleados.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void modifyPerfil(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("nro"));
        obj.deletePerfil(nro);
        String pag = "/empleados.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    protected void deletePerfil(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("nro"));
        obj.deletePerfil(nro);
        String pag = "/empleados.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    
    protected void deleteEmpleado(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("nro"));
        obj.deletePerfil(nro);
        String pag = "/empleados.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void addEmpleado(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("nro"));
        obj.deletePerfil(nro);
        String pag = "/empleados.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void modifyEmpleado(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("nro"));
        obj.deletePerfil(nro);
        String pag = "/empleados.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
