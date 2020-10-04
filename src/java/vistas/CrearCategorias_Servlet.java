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

/**
 *
 * @author XPC
 */
@WebServlet(name = "CrearCategoriaC", urlPatterns = {"/CrearCategoriaC"})
public class CrearCategorias_Servlet extends HttpServlet {
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
        if(request.getParameter("btn_guardar") != null){
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            
            boolean estadoTransaccion = controlador.crearCategoria(nombre,descripcion);
            
            if(estadoTransaccion){
                request.setAttribute("saveMessage", "Categoria guardada con exito");
            }
            else{
                request.setAttribute("errorMessage", "Error guardando la categoria");
            }
            request.getRequestDispatcher("/CrearCategorias_A.jsp").forward(request, response);
        }
    }


}
