<%-- 
    Document   : Comprar_C
    Created on : 12/10/2020, 03:02:30 AM
    Author     : XPC
--%>

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
        <hr>
        <form action="./Comprar" method="post">
            <div class="scrollit">
                <select>
                    <option >Elije una direccion</option>
                    <%if(request.getAttribute("ListaDirecciones") != null){ %>      
                    <% ArrayList<Direccion> lista = (ArrayList<Direccion>) request.getAttribute("ListaDirecciones"); %>
                    <%  for(int i=0; i<lista.size(); i++){ %>
                    <option value="<%= lista.get(i).getProvincia()%>"><%= lista.get(i).getProvincia()%></option>
                        <%}%>
                    <%}%>
                 </select>
            </div><br><br><br>
            <button class="btn-default" name="btn_crear" value="crear"/>Comprar</button>
            <button class="btn-default" name="btn_atras" value="atras"/>Atras</button>
        </form>
        </div>
    </body> 
</html>

