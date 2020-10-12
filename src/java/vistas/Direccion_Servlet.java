/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.Controlador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author XPC
 */
@WebServlet(name = "Direccion", urlPatterns = {"/Direccion"})
public class Direccion_Servlet extends HttpServlet {
    private Controlador controlador = new Controlador();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("btn_atras") != null){
           request.getRequestDispatcher("./Principal_C.jsp").forward(request, response);
        }
    }
    

    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("btn_guardar") != null){
            String provincia = request.getParameter("provincia");
            String canton = request.getParameter("canton");
            String distrito = request.getParameter("distrito");
            String datosExtra = request.getParameter("datosExtra");
            
            boolean estadoTransaccion = controlador.creaDireccion(provincia, canton,
                    distrito, datosExtra);
            if(estadoTransaccion){
                request.setAttribute("saveMessage", "Direccion guardada con exito");
            }
            else{
                request.setAttribute("errorMessage", "Error guardando la direccion");
            }
            
            request.getRequestDispatcher("./Direccion_C.jsp").forward(request, response);
        }
    }

}
