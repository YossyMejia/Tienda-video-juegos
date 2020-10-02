/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Login;
import modelo.MetodosLogin;
import modelo.MetodosUsuario;

/**
 *
 * @author XPC
 */
@WebServlet(name = "RegistroC", urlPatterns = {"/RegistroC"})
public class RegistroC extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistroC</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistroC at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void init() throws ServletException {
        //super.init(); //To change body of generated methods, choose Tools | Templates.
        out.println("<body>");
        out.println("<h1>Servlet RegistroC at " + "SIUUUUUUU" + "</h1>");
        out.println("</body>");
    }

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("btn_atras") != null){
           request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            
            MetodosUsuario usuario = new MetodosUsuario();
            ArrayList<Login> lista;
            MetodosLogin  modeloLogin = new MetodosLogin();
            lista = modeloLogin.checkCorreo(correo);
            if(lista.isEmpty()){
                boolean estado = usuario.postUser(identificacion, nombre, primer_apellido, segundo_apellido, tipo, correo, contrasena);
                if(estado){
                    request.setAttribute("saveMessage", "Registro exitoso");
                    request.getRequestDispatcher("./RegistroView.jsp").forward(request, response);   //Llamo la pagina siguiente
                }
                else{
                    request.setAttribute("errorMessage", "Error realizando el registro");
                }
            }
            else{
                    request.setAttribute("errorMessage", "Correo registrado");
            }
            
            request.getRequestDispatcher("./RegistroView.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
