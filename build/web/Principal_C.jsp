<%-- 
    Document   : Principal_C
    Created on : 03/10/2020, 10:38:50 PM
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
        <h1 class="text-center">Pagina principal cliente</h1>
        <hr>
        <form action="./ClientePrincipal" method="post">
            <button class="btn-default" name="btn_productos" value="Productos"/>Ver productos</button>
            <button class="btn-default" name="btn_carrito" value="Carrito"/>Ver carrito</button>
            <button class="btn-default" name="btn_historial" value="Historial"/>Historial compras</button><br><br>
            <button class="btn-default" name="btn_tarjeta" value="Tarjeta"/>Ingresar tarjeta</button>
            <button class="btn-default" name="btn_direccion" value="Direccion"/>Ingresar direccion</button><br><br>
            <button class="btn-default" name="btn_soporte" value="Soporte"/>Solicitar Soporte</button><br><br>
            <button class="btn-default btn-danger right" name="btn_salir" value="Salir"/>Salir</button>
        </form>
    </body>
</html>
