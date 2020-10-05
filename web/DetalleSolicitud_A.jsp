<%-- 
    Document   : DetalleSolicitud_A
    Created on : 04/10/2020, 04:12:16 PM
    Author     : XPC
--%>

<%@page import="modelo.Solicitud"%>
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
        <h1 class="text-center">Consulta detalles</h1>
        <hr>
        <form action="./DetalleSolicitud" method="post">
            <div class="scrollit">
            <table class="table table-bordered">
                <tr>
                    <th name="id" >Codigo cliente: </th>
                    <th class="text-center" name="id_tecnico" >Codigo tecnico: </th>
                    <th class="text-center" name="Pregunta">Pregunta: </th>
                    <th class="text-center" name="Respuesta">Respuesta: </th>
                    <th class="text-center" name="Fecha">Fecha solucion: </th>
                    
                </tr>
                <%if(request.getAttribute("Lista") != null){ %>
                <% ArrayList<Solicitud> lista = (ArrayList<Solicitud>) request.getAttribute("Lista"); %>
                <%  for(int i=0; i<lista.size(); i++){ %>
                <tr>
                    <td><%= lista.get(i).getId_usuario()%></td>
                    <td class="text-center"><%= lista.get(i).getId_tecnico()%></td>
                    <td class="text-center"><%= lista.get(i).getPregunta()%></td>
                    <td class="text-center"><%= lista.get(i).getRespuesta()%></td>
                    <td class="text-center"><%= lista.get(i).getFecha()%></td>
                </tr> 
                    <%}%>
                <%}%>
            </table>
            </div><br><br><br>
            <button class="btn-default" name="btn_atras" value="atras"/>Atras</button>
        </form>
        </div>
    </body> 
</html>
