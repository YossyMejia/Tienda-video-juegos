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
@WebServlet(name = "Comprar", urlPatterns = {"/Comprar"})
public class Comprar_Servlet extends HttpServlet {
    private Controlador controlador = new Controlador();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("btn_atras") != null){
           request.setAttribute("Lista", controlador.obtenerProductosCarrito());
           RequestDispatcher view = request.getRequestDispatcher("Carrito_C.jsp");
           view.forward(request,response);
           request.getRequestDispatcher("./Carrito_C.jsp").forward(request, response);
        }
    }

    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("btn_comprar") != null){
            String direccion_string = request.getParameter("cbx_direccion");
            String tarjeta = request.getParameter("cbx_tarjetas");
            int direccion = Integer.parseInt(direccion_string);
            boolean estadoTransaccion = controlador.crearCompra(tarjeta, direccion);
            if(estadoTransaccion){
                controlador.limpiarCarrito();
                request.setAttribute("succesMessage", "Compra realizada con exito");
                request.getRequestDispatcher("./Carrito_C.jsp").forward(request, response);
            }
            else{
                request.setAttribute("errorMessage", "Error realizando la compra");
            }
            
            request.getRequestDispatcher("./Comprar_C.jsp").forward(request, response);
        }
    }
    

}
