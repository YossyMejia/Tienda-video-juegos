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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Solicitud;

/**
 *
 * @author XPC
 */
@WebServlet(name = "VerSolicitudes", urlPatterns = {"/VerSolicitudes"})
public class VerSolicitudes_Servlet extends HttpServlet {
    private Controlador controlador = new Controlador();
   
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("btn_atras") != null){
           request.getRequestDispatcher("./Principal_S.jsp").forward(request, response);
        }
        else if(request.getParameter("idConsulta") != null){ 
           request.getRequestDispatcher("./ResolverSolicitud_S.jsp").forward(request, response);
        }
       request.getRequestDispatcher("./VerSolicitudes_S.jsp").forward(request, response);
    }

}
