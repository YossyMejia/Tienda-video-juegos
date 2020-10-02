/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Categoria;
import modelo.MetodosCategoria;
import modelo.MetodosProductos;
import modelo.MetodosUsuario;
import modelo.Producto;
import modelo.Usuario;

/**
 *
 * @author XPC
 */
@WebServlet(name = "AdministradorC", urlPatterns = {"/AdministradorC"})
public class AdministradorC extends HttpServlet {
    static String userID;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdministradorC</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdministradorC at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
       if(request.getParameter("btn_categorias") != null){
           MetodosCategoria categorias = new MetodosCategoria();
           ArrayList<Categoria> lista = categorias.getCategorias();
           request.setAttribute("Lista", lista);
           RequestDispatcher view = request.getRequestDispatcher("AdmCategoriasView.jsp");
           view.forward(request,response);
           request.getRequestDispatcher("./AdmCategoriasView.jsp").forward(request, response);
       }
       else if(request.getParameter("btn_productos") != null){
           MetodosProductos productos = new MetodosProductos();
           ArrayList<Producto> lista = productos.getProductos();
           request.setAttribute("Lista", lista);
           RequestDispatcher view = request.getRequestDispatcher("AdmProductosView.jsp");
           view.forward(request,response);
           request.getRequestDispatcher("./AdmProductosView.jsp").forward(request, response);
       }
       else if(request.getParameter("btn_usuarios") != null){
           MetodosUsuario usuarios = new MetodosUsuario();
           ArrayList<Usuario> lista = usuarios.getUsers();
           request.setAttribute("Lista", lista);
           RequestDispatcher view = request.getRequestDispatcher("AdmUsuariosView.jsp");
           view.forward(request,response);
           request.getRequestDispatcher("./AdmUsuariosView.jsp").forward(request, response);
       }
       request.getRequestDispatcher("./AdminView.jsp").forward(request, response);
        
    }

    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
