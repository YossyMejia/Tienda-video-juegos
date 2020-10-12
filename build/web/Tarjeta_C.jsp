<%-- 
    Document   : Tarjeta_C
    Created on : 11/10/2020, 11:05:42 PM
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
        <h1 class="text-center">Ingresar tarjeta de compra</h1>
        <div style="color: #FF0000;">${errorMessage}</div>
        <hr>
        <form action="./Tarjeta" method="post">
            <label for="numero">Numero tarjeta: </label><br>
            <input class="label-default" type="text" name="numeroTarjeta" id="numeroTarjeta" required pattern="[0-9]{16}"><br><br><br>
            <label for="nombre">Titular: </label><br>
            <input class="label-default" type="text" name="nombreTarjeta" id="nombreTarjeta" required><br><br><br>
            <label for="fecha">Fecha vencimiento: (MM/YY)</label><br><br>
            <input class="label-default" type="text" name="fecha" id="fecha" required pattern="[0-9]{2}/[0-9]{2}"><br><br><br>
            <label for="ccv">CCV </label><br><br>
            <input class="label-default" type="text" name="ccv" id="ccv" required pattern="[0-9]{3}"><br><br><br>
            <div style="color: #008000;">${saveMessage}</div>
            <button class="btn-default"  name="btn_guardar" value="guardar">Guardar</button>
        </form>
        <form action="./Tarjeta" method="get">
            <button class="btn-default"  name="btn_atras" value="Atras"/>Atras</button>
        </form>
        </div>
    </body>
</html>