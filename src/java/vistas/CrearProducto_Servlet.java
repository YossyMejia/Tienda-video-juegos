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
import modelo.MetodosProductos;
import modelo.Producto;

/**
 *
 * @author XPC
 */
@WebServlet(name = "CrearProductoC", urlPatterns = {"/CrearProductoC"})
public class CrearProducto_Servlet extends HttpServlet {
    private Controlador controlador = new Controlador();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("btn_atras") != null){
           request.setAttribute("Lista", controlador.obtenerCategorias());
           RequestDispatcher view = request.getRequestDispatcher("Categorias_A.jsp");
           view.forward(request,response);
           request.getRequestDispatcher("./Categorias_A.jsp").forward(request, response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("idCategoria") != null){
            String id_str = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String precio_str = request.getParameter("precio");
            String cantidad_str = request.getParameter("cantidad");
            String descripcion = request.getParameter("descripcion");
            String categoria_str = request.getParameter("idCategoria");
            int id = Integer.parseInt(id_str);
            int precio = Integer.parseInt(precio_str);
            int cantidad = Integer.parseInt(cantidad_str);
            int categoria = Integer.parseInt(categoria_str);
            boolean estadoTransaccion = controlador.crearProducto(id, nombre,
                    precio, cantidad, descripcion, categoria);
            if(estadoTransaccion){
                request.setAttribute("saveMessage", "Producto guardado con exito");
            }
            else{
                request.setAttribute("errorMessage", "Error guardando el producto");
            }
            
            request.getRequestDispatcher("./CrearProducto_A.jsp").forward(request, response);
        }
    }
 
}
