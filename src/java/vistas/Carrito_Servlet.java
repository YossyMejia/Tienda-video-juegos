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
import modelo.Direccion;
import modelo.Tarjeta;

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
           if(controlador.carritoVacio() == false){
            ArrayList<Direccion> listaDirecciones = controlador.obtenerDirecciones();
            ArrayList<Tarjeta> listaTarjetas =  controlador.obtenerTarjetas();
                if(listaDirecciones.isEmpty() || listaTarjetas.isEmpty()){
                    request.setAttribute("errorMessage", "Debe tener al menos una direccion y una tarjeta para comprar");
                    request.getRequestDispatcher("./Carrito_C.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("ListaDirecciones", listaDirecciones);  
                    request.setAttribute("ListaTarjetas", listaTarjetas);
                    RequestDispatcher view = request.getRequestDispatcher("Comprar_C.jsp");
                    view.forward(request,response);
                    request.getRequestDispatcher("./Comprar_C.jsp").forward(request, response);
                }
           }
           else{
               request.setAttribute("errorMessage", "Debe tener al menos un producto para comprar");
               request.getRequestDispatcher("./Carrito_C.jsp").forward(request, response);
           }
           
       }
       else if(request.getParameter("btn_atras") != null){
           request.getRequestDispatcher("./Principal_C.jsp").forward(request, response);
       }
       request.getRequestDispatcher("./Principal_C.jsp").forward(request, response);
        
    }

}
