<%-- 
    Document   : CrearProdcutoView
    Created on : 01/10/2020, 11:48:32 PM
    Author     : XPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style type="text/css">	 
.bodyb { 
 background-color: silver;
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
        <div class="container " text-align:center>
        <h1 class="text-center">Crear producto</h1>
        <input type="hidden" name="nombreCategoria" value=<%=request.getParameter("btn_crearproducto")%>>
        <div style="color: #FF0000;">${errorMessage}</div>
        <hr>
        <form action="./CrearProducto" method="post">
            <label for="id">Codigo producto: </label><br>
            <input class="label-default" type="text" name="id" id="id" required pattern="[0-9]{5}"><br><br><br>
            <label for="nombre">Nombre: </label><br>
            <input class="label-default" type="text" name="nombre" id="nombre" required><br><br><br>
            <label for="precio">Precio: </label><br><br>
            <input class="label-default" type="text" name="precio" id="precio" required pattern="[0-9]+"><br><br><br>
            <label for="cantidad">Cantidad </label><br><br>
            <input class="label-default" type="text" name="cantidad" id="cantidad" required pattern="[0-9]+"><br><br><br>
            <label for="descripcion">Descripcion: </label><br><br>
            <textarea class="label-default" id="descripcion" name="descripcion" rows="4" cols="50" required></textarea><br><br><br>
            <div style="color: #008000;">${saveMessage}</div>
            <button class="btn-default"  name="idCategoria" value=<%=request.getParameter("idCategoria")%>>Guardar</button>
        </form>
        <form action="./CrearProducto" method="get">
            <button class="btn-default"  name="btn_atras" value="Atras"/>Atras</button>
        </form>
        </div>
    </body>
</html>
