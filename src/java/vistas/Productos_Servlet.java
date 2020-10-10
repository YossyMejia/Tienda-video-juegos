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

/**
 *
 * @author XPC
 */
@WebServlet(name = "Productos", urlPatterns = {"/Productos"})
public class Productos_Servlet extends HttpServlet {
    private Controlador controlador = new Controlador();
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if(request.getParameter("btn_atras") != null){
           request.getRequestDispatcher("./Principal_A.jsp").forward(request, response);
       }
       else if(request.getParameter("idProducto") != null){
           request.getRequestDispatcher("./EditarProducto_A.jsp").forward(request, response);
       } 
       else if(request.getParameter("idProductoEliminar") != null){
           request.getRequestDispatcher("./EliminarProducto_A.jsp").forward(request, response);
       }
        request.getRequestDispatcher("./Productos_A.jsp").forward(request, response);
    }


}
