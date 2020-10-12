<%-- 
    Document   : Direccion_C
    Created on : 12/10/2020, 02:32:19 AM
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
        <h1 class="text-center">Ingresar direccion de compra</h1>
        <div style="color: #FF0000;">${errorMessage}</div>
        <hr>
        <form action="./Direccion" method="post">
            <label for="provincia">Provincia: </label><br>
            <input class="label-default" type="text" name="provincia" id="provincia" required><br><br><br>
            <label for="canton">Canton: </label><br>
            <input class="label-default" type="text" name="canton" id="canton" required><br><br><br>
            <label for="distrito">Distrito: </label><br><br>
            <input class="label-default" type="text" name="distrito" id="distrito" required><br><br><br>
            <label for="datosExtra">Datos extra: </label><br><br>
            <input class="label-default" type="text" name="datosExtra" id="datosExtra" required><br><br><br>
            <div style="color: #008000;">${saveMessage}</div>
            <button class="btn-default"  name="btn_guardar" value="guardar">Guardar</button>
        </form>
        <form action="./Direccion" method="get">
            <button class="btn-default"  name="btn_atras" value="Atras"/>Atras</button>
        </form>
        </div>
    </body>
</html>
