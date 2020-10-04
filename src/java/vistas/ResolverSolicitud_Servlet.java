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
@WebServlet(name = "ResolverSolicitud", urlPatterns = {"/ResolverSolicitud"})
public class ResolverSolicitud_Servlet extends HttpServlet {
    private Controlador controlador = new Controlador();
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("btn_atras") != null){
           request.setAttribute("Lista", controlador.obtenerConsultas());
           RequestDispatcher view = request.getRequestDispatcher("VerSolicitudes_S.jsp");
           view.forward(request,response);
           request.getRequestDispatcher("./VerSolicitudes_S.jsp").forward(request, response);
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if(request.getParameter("idConsulta") != null){
            String respuesta = request.getParameter("respuesta");
            String id_string = request.getParameter("idConsulta");
            int id_solicitud = Integer.parseInt(id_string);
            boolean estadoTransaccion = controlador.crearSolucion(id_solicitud, respuesta);
            
            if(estadoTransaccion){
                request.setAttribute("saveMessage", "Solicitud creada con exito");
            }
            else{
                request.setAttribute("errorMessage", "Error creando la solicitud");
            }
       }
       request.setAttribute("Lista", controlador.obtenerConsultas());
       RequestDispatcher view = request.getRequestDispatcher("VerSolicitudes_S.jsp");
       view.forward(request,response);
       request.getRequestDispatcher("./VerSolicitudes_S.jsp").forward(request, response);
        
    }

}
