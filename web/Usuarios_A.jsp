<%-- 
    Document   : Usuarios_A
    Created on : 01/10/2020, 07:56:56 PM
    Author     : XPC
--%>

<%@page import="modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style type="text/css">	 
.bodyb { 
 background-color: silver;
} 
.scrollit {
    overflow:scroll;
    height:500px;
}
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body class="bodyb">
        <div class="container">
            <h1>Lista usuarios</h1>
            <hr>
            <div class="scrollit">
            <table class="table table-bordered">
                <tr>
                    <th>Nombre</th>
                    <th class="text-center">Apellido</th>
                     <th class="text-center">Correo</th>
                     <th class="text-center">Tipo Usuario</th>
                     <th class="text-center">Accion</th>
                </tr>
                <%if(request.getAttribute("Lista") != null){ %>
                <% ArrayList<Usuario> lista = (ArrayList<Usuario>) request.getAttribute("Lista"); %>
                <%  for(int i=0; i<lista.size(); i++){ %>

                <tr>
                    <td><%= lista.get(i).getNombre()%></td>
                    <td class="text-center"><%= lista.get(i).getApellido1()%></td>
                    <td class="text-center"><%= lista.get(i).getCorreo()%></td>
                    <td class="text-center"><%= lista.get(i).getDescripcionTipo()%></td>
                    <td>
                        <a >Editar</a>
                        <a >Eliminar</a>
                    </td>
                </tr> 
                <%}%>
               <%}%>
            </table>
            <form action="./Usuarios" method="post">
            </div><br><br><br>
            <button class="btn-default" name="btn_crear" value="crear"/>Crear nuevo</button>
            <button class="btn-default" name="btn_atras" value="Atras"/>Atras</button>
            </form>
       </div>
    </body>
</html>
