/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.Controlador;
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
public class AdministradorPrincipal_Servlet extends HttpServlet {
    private Controlador controlador = new Controlador();
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if(request.getParameter("btn_categorias") != null){
           request.setAttribute("Lista", controlador.obtenerCategorias());
           RequestDispatcher view = request.getRequestDispatcher("Categorias_A.jsp");
           view.forward(request,response);
           request.getRequestDispatcher("./Categorias_A.jsp").forward(request, response);
       }
       else if(request.getParameter("btn_productos") != null){
           request.setAttribute("Lista", controlador.obtenerProductos());
           RequestDispatcher view = request.getRequestDispatcher("Productos_A.jsp");
           view.forward(request,response);
           request.getRequestDispatcher("./Productos_A.jsp").forward(request, response);
       }
       else if(request.getParameter("btn_usuarios") != null){
           request.setAttribute("Lista", controlador.obtenerUsuarios());
           RequestDispatcher view = request.getRequestDispatcher("Usuarios_A.jsp");
           view.forward(request,response);
           request.getRequestDispatcher("./Usuarios_A.jsp").forward(request, response);
       }
       else if(request.getParameter("btn_registro_soporte") != null){
           request.setAttribute("Lista", controlador.obtenerSolicitudDetalle());
           RequestDispatcher view = request.getRequestDispatcher("Solicitudes_A.jsp");
           view.forward(request,response);
           request.getRequestDispatcher("./Solicitudes_A.jsp").forward(request, response);
       }
       else if(request.getParameter("btn_salir") != null){
           request.getRequestDispatcher("./index.jsp").forward(request, response);
       }
       request.getRequestDispatcher("./Principal_A.jsp").forward(request, response);
        
    }



}
