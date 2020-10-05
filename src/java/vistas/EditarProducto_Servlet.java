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
@WebServlet(name = "EditarProducto", urlPatterns = {"/EditarProducto"})
public class EditarProducto_Servlet extends HttpServlet {
     private Controlador controlador = new Controlador();
   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("btn_atras") != null){
           request.setAttribute("Lista", controlador.obtenerProductos());
           RequestDispatcher view = request.getRequestDispatcher("Productos_A.jsp");
           view.forward(request,response);
           request.getRequestDispatcher("./Productos_A.jsp").forward(request, response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("idProducto") != null){
            String id_str = request.getParameter("idProducto");
            String nombre = request.getParameter("nombre");
            String precio_str = request.getParameter("precio");
            String cantidad_str = request.getParameter("cantidad");
            int id = Integer.parseInt(id_str);
            int precio = Integer.parseInt(precio_str);
            int cantidad = Integer.parseInt(cantidad_str);
            boolean estadoTransaccion = controlador.modificarProducto(id, nombre,
                    precio, cantidad);
            if(estadoTransaccion){
                request.setAttribute("saveMessage", "Producto modificado con exito");
            }
            else{
                request.setAttribute("errorMessage", "Error modificando el producto");
            }
            
           request.getRequestDispatcher("./EditarProducto_A.jsp").forward(request, response);
        }
    }

}
