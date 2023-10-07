/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control;

import dao.PlatoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.Plato;

/**
 *
 * @author Axel
 */
public class SvPlatos extends HttpServlet {

    PlatoDAO platoDao = new PlatoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int opc = Integer.parseInt(request.getParameter("opc"));

        switch (opc) {
            case 1://EditarPlatosCategoria
                editarPlatoCategoria(request, response);//redirige a la pagina de editarPlatoCategoria
                break;
            case 2://EliminarPlatosCategoria
                eliminarPlatoCategoria(request, response);
                break;

            case 3://TerminarEditarPlatosCategoria
                terminarEditarPlatoCategoria(request, response);
                break;
            //-------------------------------
            case 4://EditarPlatos
                editarPlato(request, response);
                break;
            case 5://Terminar de editar platos
                terminarEditarPlato(request, response);
                break;
            case 6://Eliminar plato
                eliminarPlato(request, response);
                break;
            case 7://Agregar plato
                agregarPlato(request, response);
                break;
            case 8://Terminar de agregar plato
                terminarAgregarPlato(request, response);
                break;
            case 9:
                agregarPlatoCategoria(request, response);
                break;
            case 10:
                terminarAgregarCategoriaPlato(request, response);
                break;
        }
    }

    protected void terminarAgregarCategoriaPlato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String nombrePlatoCategoria = request.getParameter("nombreNuevaCategoria");
        int codCategoriaNuevo = Integer.parseInt(request.getParameter("codCategoriaNuevo"));
        
        Plato p = new Plato();
        p.setCatNombre(nombrePlatoCategoria);
        p.setCodCat(codCategoriaNuevo);
        
        platoDao.addCategoriaPlatos(p);
        request.getRequestDispatcher("/platos.jsp").forward(request, response);
    }
    
    protected void agregarPlatoCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/agregarPlatoCategoria.jsp").forward(request, response);
    }

    protected void editarPlatoCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigoPlatoCategoria = Integer.parseInt(request.getParameter("codigoPlatoCategoria"));
        Plato platoCategoria = platoDao.obtenerDatosCategoria(codigoPlatoCategoria);
        request.setAttribute("platoCategoria", platoCategoria);
        request.getRequestDispatcher("/editarPlatoCategoria.jsp").forward(request, response);
    }

    protected void terminarEditarPlatoCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombrePlatoCategoria = request.getParameter("nombreCategoria");
        int codigoCategoria = Integer.parseInt(request.getParameter("codigoPlatoCategoria"));
        platoDao.terminarEditarCategoria(nombrePlatoCategoria, codigoCategoria);
        request.getRequestDispatcher("/platos.jsp").forward(request, response);
    }

    protected void eliminarPlatoCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigoPlatoCategoria = Integer.parseInt(request.getParameter("codigoPlatoCategoria"));
        platoDao.deleteCategoriaPlatos(codigoPlatoCategoria);
        request.getRequestDispatcher("/platos.jsp").forward(request, response);
    }

    // ------------------------------------------------------------
    protected void agregarPlato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/agregarPlato.jsp").forward(request, response);
    }

    protected void terminarAgregarPlato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Plato p = new Plato();
        p.setCodPlato(platoDao.siguienteCodigoPlato());
        p.setNombre(request.getParameter("nombrePlato"));
        p.setPrecio(Double.parseDouble(request.getParameter("precio")));
        p.setEstado(request.getParameter("estado"));
        p.setCodCat(Integer.parseInt(request.getParameter("categoria")));
        String img = request.getParameter("imagen");
        p.setImagen(img.equals("") ? null : img);
        platoDao.addPlato(p);
        request.getRequestDispatcher("/platos.jsp").forward(request, response);
    }

    protected void editarPlato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigoPlato = Integer.parseInt(request.getParameter("codigoPlato"));
        Plato plato = platoDao.obtenerDatosPlato(codigoPlato);
        request.setAttribute("plato", plato);
        request.getRequestDispatcher("/editarPlato.jsp").forward(request, response);
    }

    protected void terminarEditarPlato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombrePlato = request.getParameter("nombrePlato");
        int codigoPlato = Integer.parseInt(request.getParameter("codigoPlato"));
        platoDao.modifyPlato(nombrePlato, codigoPlato);
        request.getRequestDispatcher("/platos.jsp").forward(request, response);
    }

    protected void eliminarPlato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigoPlato = Integer.parseInt(request.getParameter("codigoPlato"));
        platoDao.deletePlato(codigoPlato);
        request.getRequestDispatcher("/platos.jsp").forward(request, response);
    }

    protected void reserva(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
