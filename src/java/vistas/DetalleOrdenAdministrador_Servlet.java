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
@WebServlet(name = "DetalleOrdenAdministrador", urlPatterns = {"/DetalleOrdenAdministrador"})
public class DetalleOrdenAdministrador_Servlet extends HttpServlet {
    private Controlador controlador = new Controlador();
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if(request.getParameter("btn_atras") != null){
           request.setAttribute("Lista", controlador.obtenerCompras());
           RequestDispatcher view = request.getRequestDispatcher("Historial_A.jsp");
           view.forward(request,response);
           request.getRequestDispatcher("./Historial_A.jsp").forward(request, response);
       }
       request.getRequestDispatcher("./DetalleOrden_A.jsp").forward(request, response);
        
    }
    

}
