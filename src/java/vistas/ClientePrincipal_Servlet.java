/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.Controlador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author XPC
 */
@WebServlet(name = "ClientePrincipal", urlPatterns = {"/ClientePrincipal"})
public class ClientePrincipal_Servlet extends HttpServlet {

     private Controlador controlador = new Controlador();
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if(request.getParameter("btn_soporte") != null){
           request.getRequestDispatcher("./CrearSolicitud_C.jsp").forward(request, response);
       }
       else if(request.getParameter("btn_productos") != null){
           request.setAttribute("Lista", controlador.obtenerProductos());
           RequestDispatcher view = request.getRequestDispatcher("Productos_C.jsp");
           view.forward(request,response);
           request.getRequestDispatcher("./Productos_C.jsp").forward(request, response);
       }
       else if(request.getParameter("btn_carrito") != null){
           request.setAttribute("Lista", controlador.obtenerProductosCarrito());
           RequestDispatcher view = request.getRequestDispatcher("Carrito_C.jsp");
           view.forward(request,response);
           request.getRequestDispatcher("./Carrito_C.jsp").forward(request, response);
       }
       else if(request.getParameter("btn_salir") != null){
           request.getRequestDispatcher("./index.jsp").forward(request, response);
       }
       else if(request.getParameter("btn_tarjeta") != null){
           request.getRequestDispatcher("./Tarjeta_C.jsp").forward(request, response);
       }
       else if(request.getParameter("btn_direccion") != null){
           request.getRequestDispatcher("./Direccion_C.jsp").forward(request, response);
       }
       else if(request.getParameter("btn_historial") != null){
           request.setAttribute("Lista", controlador.obtenerComprasCliente());
           RequestDispatcher view = request.getRequestDispatcher("Historial_C.jsp");
           view.forward(request,response);
           request.getRequestDispatcher("./Historial_C.jsp").forward(request, response);
       }
       request.getRequestDispatcher("./Principal_C.jsp").forward(request, response);
        
    }
}
