<%-- 
    Document   : EditarProducto_A
    Created on : 03/10/2020, 10:53:45 PM
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
        <h1 class="text-center">Editar producto</h1>
        <div style="color: #FF0000;">${errorMessage}</div>
        <hr>
        <form action="./EditarProducto" method="post">
            <label for="id">Codigo producto: <%=request.getParameter("idProducto")%></label><br><br><br>
            <label for="nombre">Nombre: </label><br>
            <input class="label-default" type="text" name="nombre" id="nombre" required><br><br><br>
            <label for="precio">Precio: </label><br><br>
            <input class="label-default" type="text" name="precio" id="precio" required pattern="[0-9]+"><br><br><br>
            <label for="cantidad">Cantidad </label><br><br>
            <input class="label-default" type="text" name="cantidad" id="cantidad" required pattern="[0-9]+"><br><br><br>
            <div style="color: #008000;">${saveMessage}</div>
            <button class="btn-default"  name="idProducto" value=<%=request.getParameter("idProducto")%>>Guardar cambios</button>
        </form>
        <form action="./EditarProducto" method="get">
            <button class="btn-default"  name="btn_atras" value="Atras"/>Atras</button>
        </form>
        </div>
    </body>
</html>
