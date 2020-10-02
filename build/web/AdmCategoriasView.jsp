<%-- 
    Document   : AdmCategoriasView
    Created on : 01/10/2020, 12:01:00 AM
    Author     : XPC
--%>

<%@page import="modelo.Categoria"%>
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
        <h1 class="text-center">Administracion de categorias</h1>
        <hr>
        <form action="./AdmCategoriasC" method="post">
            <table class="table table-bordered">
                <tr>
                    <th name="nombre" >Nombre</th>
                    <th class="text-center" name="descripcion" >Descripcion</th>
                    <th class="text-center">Accion</th>
                </tr>
                <%if(request.getAttribute("Lista") != null){ %>
                <% ArrayList<Categoria> lista = (ArrayList<Categoria>) request.getAttribute("Lista"); %>
                <%  for(int i=0; i<lista.size(); i++){ %>
                <tr>
                    <td><%= lista.get(i).getNombre()%></td>
                    <td class="text-center"><%= lista.get(i).getDescripcion()%></td>
                    <td>
                        <button class="btn btn-default btn-sm" name="idCategoria" value=<%=lista.get(i).getId()%> >Crear producto</button>
                    </td>
                </tr> 
                    <%}%>
                <%}%>
            </table>
            <button class="btn-default" name="btn_crear" value="crear"/>Crear categoria</button>
            <button class="btn-default" name="btn_atras" value="atras"/>Atras</button>
        </form>
    </body> 
</html>
