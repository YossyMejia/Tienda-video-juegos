<%-- 
    Document   : Historial_A
    Created on : 14/10/2020, 05:45:05 PM
    Author     : XPC
--%>

<%@page import="modelo.Compra"%>
<%@page import="modelo.Producto"%>
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
form {    
    display: inline;
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
            <h1>Historial de compras</h1>
            <hr>
            <form action="./AdministradorHistorial" method="post">
             <div class="scrollit">
            <table class="table table-bordered">
                <tr>
                     <th>ID usuario</th>
                     <th class="text-center">ID orden</th>
                     <th class="text-center">Fecha orden</th>
                     <th class="text-center">Estado</th>
                     <th class="text-center">Detalles</th>
                     <th class="text-center">Monto</th>
                     <th class="text-center">Acciones</th>
                </tr>
                <%if(request.getAttribute("Lista") != null){ %>
                <% ArrayList<Compra> lista = (ArrayList<Compra>) request.getAttribute("Lista"); %>
                <%  for(int i=0; i<lista.size(); i++){ %>
                <tr>
                    <td><%= lista.get(i).getId_usuario()%></td>
                    <td class="text-center"><%= lista.get(i).getId_orden()%></td>
                    <td class="text-center"><%= lista.get(i).getFecha_orden()%></td>
                    <td class="text-center"><%= lista.get(i).getEstado_orden()%></td>
                    <td class="text-center"><%= lista.get(i).getDetalles_orden()%></td>
                    <td class="text-center"><%= lista.get(i).getMonto()%></td>
                    <td>
                        <button class="btn-default" name="idOrden"  value=<%=lista.get(i).getId_orden()%>>Ver detalles</button>
                    </td>
                </tr> 
                <%}%>
               <%}%>
            </table>
             </div><br><br><br>
            <button class="btn-default" name="btn_atras" value="Atras"/>Atras</button>
            </form>
        </div>
    </body>
</html>
