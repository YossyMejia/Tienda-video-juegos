<%-- 
    Document   : Registro
    Created on : 30/09/2020, 08:00:51 PM
    Author     : XPC
--%>

<%@page import="vistas.RegistroC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style type="text/css">	 
.bodyb { 
 background-color: silver;
} 

</style>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body class="bodyb">
        <div class="container " text-align:center>
        <h1>Registro</h1>
        <div style="color: #008000;">${message}</div>
        <hr>
        <form action="./RegistroC" method="post">
            <div style="color: #FF0000;">${errorMessage}</div>
            <label for="nombre">Nombre: </label><br>
            <input  class="label-default" type="text" name="nombre" id="nombre" required><br><br><br>
            <label for="primer_apellido">Primer apellido: </label><br>
            <input  class="label-default" type="text" name="primer_apellido" id="primer_apellido" required><br><br><br>
            <label for="segundo_apellido">Segundo apellido: </label><br>
            <input class="label-default" type="text" name="segundo_apellido" id="segundo_apellido" required><br><br><br>
            <label for="identificacion">Identificacion (7 numeros): </label><br>
            <input class="label-default" type="text" name="identificacion" id="identificacion" pattern="[0-9]{7}" required><br><br><br>
            <label for="correo">Correo: </label><br>
            <input class="label-default" type="text" name="correo" id="correo" required><br><br><br>
            <label  for="contrasena">Contrasena: </label><br>
            <input class="label-default"  type="password" name="contrasena" id="contrasena" required><br><br><br><br>
            <div style="color: #008000;">${saveMessage}</div>
            <button class="btn btn-success btn-sm btn-group-lg" name="btn_registrarse" value="Registrarse">Registrarse</button>
        </form>
        <form action="./RegistroC" method="get">
            <button class="btn btn-warning btn-sm btn-group-lg"  name="btn_atras" value="Atras"/>Atras</button>
        </form>
        </div>
    </body>
</html>
