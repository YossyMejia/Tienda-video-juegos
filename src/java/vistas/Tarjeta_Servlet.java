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
@WebServlet(name = "Tarjeta", urlPatterns = {"/Tarjeta"})
public class Tarjeta_Servlet extends HttpServlet {
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
            String numero = request.getParameter("numeroTarjeta");
            String nombre = request.getParameter("nombreTarjeta");
            String fecha = request.getParameter("fecha");
            String ccv_str = request.getParameter("ccv");
            int ccv = Integer.parseInt(ccv_str);
            
            boolean estadoTransaccion = controlador.creaTarjeta(numero, nombre,
                    fecha, ccv);
            if(estadoTransaccion){
                request.setAttribute("saveMessage", "Tarjeta guardada con exito");
            }
            else{
                request.setAttribute("errorMessage", "Error guardando la tarjeta");
            }
            
            request.getRequestDispatcher("./Tarjeta_C.jsp").forward(request, response);
        }
    }
    

}
