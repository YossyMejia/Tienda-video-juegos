<%-- 
    Document   : AdminProuctosView
    Created on : 01/10/2020, 09:57:35 PM
    Author     : XPC
--%>

<%@page import="modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style type="text/css">	 
.bodyb { 
 background-color: silver;
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
            <h1>Administrador de productos</h1>
            <hr>
            <form action="./AdmProductosC" method="post">
            <table class="table table-bordered">
                <tr>
                    <th>Codigo</th>
                    <th class="text-center">Nombre</th>
                     <th class="text-center">Precio</th>
                     <th class="text-center">Cantidad</th>
                     <th class="text-center">Categoria</th>
                     <th class="text-center">Acciones</th>
                </tr>
                <%if(request.getAttribute("Lista") != null){ %>
                <% ArrayList<Producto> lista = (ArrayList<Producto>) request.getAttribute("Lista"); %>
                <%  for(int i=0; i<lista.size(); i++){ %>
                <tr>
                    <td><%= lista.get(i).getCodigo()%></td>
                    <td class="text-center"><%= lista.get(i).getNombre()%></td>
                    <td class="text-center"><%= lista.get(i).getPrecio()%></td>
                    <td class="text-center"><%= lista.get(i).getCantidad()%></td>
                    <td class="text-center"><%= lista.get(i).getNombreCategoria()%></td>
                    <td>
                        <button class="btn-default" name="btn_editar" value="Editar" >Editar</button>
                    </td>
                </tr> 
                <%}%>
               <%}%>
            </table>
            <button class="btn-default" name="btn_atras" value="Atras"/>Atras</button>
            <button class="btn-default" name="btn_crear" value="Crear"/>Crear producto</button>
            </form>
        </div>
    </body>
</html>
