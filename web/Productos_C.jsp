<%-- 
    Document   : Productos_C
    Created on : 04/10/2020, 06:45:22 PM
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
            <h1>Vista de productos</h1>
            <hr>
            <form class="form-inline" action="./ProductosCliente" method="get">
                <label for="filtroPrecio">Filtro precio minimo: </label>
                <input type="text" name="txt_filtroPrecio" pattern="[0-9]+" required> 
                <label for="filtroCategoria">Filtro categoria por nombre: </label>
                <input type="text" name="txt_filtroCategoria" required> 
                <button class="btn-default" name="btn_filtro"  value="Filtro" >Aplicar filtros</button>
            </form>
            <form class="form-inline" action="./ProductosCliente" method="post">
             <button class="btn-default" name="btn_eliminarFiltro"  value="Filtro" >Eliminar filtros</button><br><br>
             <div class="scrollit">
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
                <%if(lista.get(i).getCantidad() > 0){ %>
                <tr>
                <tr>
                    <td><%= lista.get(i).getCodigo()%></td>
                    <td class="text-center"><%= lista.get(i).getNombre()%></td>
                    <td class="text-center"><%= lista.get(i).getPrecio()%></td>
                    <td class="text-center"><%= lista.get(i).getCantidad()%></td>
                    <td class="text-center"><%= lista.get(i).getNombreCategoria()%></td>
                    <td>
                        <button class="btn-default" name="idProducto"  value=<%=lista.get(i).getCodigo()%> >Ver detalles</button>
                    </td>
                </tr> 
                 <%}%>
                <%}%>
               <%}%>
            </table>
             </div><br><br><br>
            <button class="btn-default" name="btn_atras" value="Atras"/>Atras</button>
            </form>
        </div>
    </body>
</html>