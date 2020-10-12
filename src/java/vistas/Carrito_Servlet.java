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
@WebServlet(name = "Carrito", urlPatterns = {"/Carrito"})
public class Carrito_Servlet extends HttpServlet {
    private Controlador controlador = new Controlador();
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if(request.getParameter("btn_comprar") != null){
           request.setAttribute("ListaDirecciones", controlador.obtenerDirecciones());  //hacer que en compra si las lista estan vacias decirle al usuario que vaya a anadir datos
           RequestDispatcher view = request.getRequestDispatcher("Comprar_C.jsp");
           view.forward(request,response);
           request.getRequestDispatcher("./Comprar_C.jsp").forward(request, response);
       }
       else if(request.getParameter("btn_atras") != null){
           request.getRequestDispatcher("./Principal_C.jsp").forward(request, response);
       }
       request.getRequestDispatcher("./Principal_C.jsp").forward(request, response);
        
    }

}
