<%-- 
    Document   : VerSolicitudes_S
    Created on : 04/10/2020, 02:31:12 AM
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
        <h1 class="text-center">Consultas abiertas</h1>
        <hr>
        <form action="./VerSolicitudes" method="post">
            <div class="scrollit">
            <table class="table table-bordered">
                <tr>
                    <th name="id" >Codigo</th>
                    <th class="text-center" name="Solicitud" >Solicitud</th>
                    <th class="text-center" name="Fecha">Fecha</th>
                    <th class="text-center">Accion</th>
                </tr>
                <%if(request.getAttribute("Lista") != null){ %>
                <% ArrayList<Solicitud> lista = (ArrayList<Solicitud>) request.getAttribute("Lista"); %>
                <%  for(int i=0; i<lista.size(); i++){ %>
                <tr>
                    <td><%= lista.get(i).getId()%></td>
                    <td class="text-center"><%= lista.get(i).getPregunta()%></td>
                    <td class="text-center"><%= lista.get(i).getFecha()%></td>
                    <td>
                        <button class="btn btn-default btn-sm" name="idConsulta" value=<%=lista.get(i).getId()%> >Resolver</button>
                       <%-- Aqui se agrega el id al boton para obtenerlo en el servlet --%>
                    </td>
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