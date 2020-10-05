/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.Controlador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author XPC
 */
@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class Registro_Servlet extends HttpServlet {
    private Controlador controlador = new Controlador();
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("btn_atras") != null){
           request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        if(request.getParameter("btn_registrarse") != null){
            
            String nombre = request.getParameter("nombre");
            String primer_apellido = request.getParameter("primer_apellido");
            String segundo_apellido = request.getParameter("segundo_apellido");
            String identificacion_str = request.getParameter("identificacion");
            int identificacion = Integer.parseInt(identificacion_str);
            String correo = request.getParameter("correo");
            String contrasena = request.getParameter("contrasena");
            String tipo = "Cliente";
            
            boolean correoValido = controlador.correoValido(correo);
            if(correoValido){
                boolean estadoTransaccion = controlador.crearUsuario(identificacion, nombre, primer_apellido, 
                    segundo_apellido, tipo, correo, contrasena);
                if(estadoTransaccion){
                    request.setAttribute("saveMessage", "Registro exitoso");
                }
                else{
                    request.setAttribute("errorMessage", "Error realizando el registro");
                }
            }
            else{
                request.setAttribute("errorMessage", "Correo ya registrado");
            }
            request.getRequestDispatcher("./Registro.jsp").forward(request, response);   //Llamo la pagina pero con mensaje modificado
        }
            
    }


}
