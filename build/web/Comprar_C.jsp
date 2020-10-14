<%-- 
    Document   : Comprar_C
    Created on : 12/10/2020, 03:02:30 AM
    Author     : XPC
--%>

<%@page import="modelo.Tarjeta"%>
<%@page import="modelo.Direccion"%>
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
        <h1 class="text-center">Comprar</h1>
        <div style="color: #FF0000;">${errorMessage}</div>
        <hr>
        <form action="./Comprar" method="post">
                <%if(request.getAttribute("ListaDirecciones") != null &&
                     request.getAttribute("ListaTarjetas") != null  ){ %> 
                <label for="direccion">Elije la direccion de envio </label><br>
                <select name="cbx_direccion">
                         
                    <% ArrayList<Direccion> listaDirecciones = (ArrayList<Direccion>) request.getAttribute("ListaDirecciones"); %>
                    <%  for(int i=0; i<listaDirecciones.size(); i++){ %>
                    <option name="cbx_direccion" value=<%= listaDirecciones.get(i).getId()%>>
                        <%= listaDirecciones.get(i).getProvincia()%>
                        <%= listaDirecciones.get(i).getDistrito()%>
                        <%= listaDirecciones.get(i).getDatos_extra()%></option>
                        <%}%>
                    
                 </select>
                 <br><br><br>
                <label for="direccion">Elije la tarjeta de pago </label><br>
                <select name="cbx_tarjetas">
                         
                    <% ArrayList<Tarjeta> listaTarjetas = (ArrayList<Tarjeta>) request.getAttribute("ListaTarjetas"); %>
                    <%  for(int i=0; i<listaTarjetas.size(); i++){ %>
                    <option name="cbx_tarjetas" value=<%= listaTarjetas.get(i).getNumero()%>>
                        <%= listaTarjetas.get(i).getNumero()%>
                        <%= listaTarjetas.get(i).getNombre()%>
                        <%= listaTarjetas.get(i).getFecha()%></option>
                        <%}%>
                    
                 </select><br><br><br>
                  <button class="btn-default" name="btn_comprar" value="comprar"/>Comprar</button>
                <%}else {%>
                    <label class="label-danger" for="error">Debe tener al menos una direccion y una tarjeta para realizar la compra! </label><br>
                <% } %>
            <button class="btn-default" name="btn_atras" value="atras"/>Atras</button>
            </div><br><br>
        </form>
        </div>
    </body> 
</html>

