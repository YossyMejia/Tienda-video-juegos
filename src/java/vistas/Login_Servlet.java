/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.Controlador;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "loginC", urlPatterns = {"/loginC"})
public class Login_Servlet extends HttpServlet {
    private Controlador controlador = new Controlador();
   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("btn_registrarse") != null){
            request.setAttribute("message", "hello");
            RequestDispatcher view=request.getRequestDispatcher("/Registro.jsp");
            view.forward(request,response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        if(request.getParameter("btn_ingresar") != null){
            String correo = request.getParameter("Correo");
            String contrasena = request.getParameter("Password");
            String estado = controlador.verificarLogin(correo, contrasena);                 //Controlador verifica si las credenciales son correctas
            
            if(estado == "Administrador"){
                request.getRequestDispatcher("Principal_A.jsp").forward(request, response);   //Llamo la pagina siguiente
            }
            else if(estado == "Cliente"){
                request.getRequestDispatcher("Principal_C.jsp").forward(request, response);
            }
            else if(estado == "Soporte Tecnico"){
                request.getRequestDispatcher("Principal_S.jsp").forward(request, response);
            }
            else{
                request.setAttribute("errorMessage", "Datos incorrectos");
            }
            request.getRequestDispatcher("/index.jsp").forward(request, response);      //Llamo a la pantalla anterior pero con el mensaje de error
        }
    }

}
