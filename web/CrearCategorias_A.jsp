<%-- 
    Document   : CrearCategorias_A
    Created on : 01/10/2020, 12:40:02 AM
    Author     : XPC
--%>

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
        <div class="container " text-align:center>
        <h1 class="text-center">Crear categoria</h1>
        <hr>
        <form action="./CrearCategorias" method="post">
            <div style="color: #FF0000;">${errorMessage}</div>
            <label for="nombre">Nombre: </label><br>
            <input class="label-default" type="text" name="nombre" id="nombre" required><br><br><br>
            <label for="descripcion">Descripcion: </label><br><br>
            <textarea class="label-default" id="descripcion" name="descripcion" rows="4" cols="50" required></textarea><br><br><br>
            <button  class="btn-default" name="btn_guardar" value="Guardar">Guardar</button>
            <div style="color: #008000;">${saveMessage}</div>
        </form>
        <form action="./CrearCategorias" method="get">
            <button class="btn-default"  name="btn_atras" value="Atras"/>Atras</button>
        </form>
        </div>
    </body>
</html>
