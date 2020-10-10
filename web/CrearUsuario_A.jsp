<%-- 
    Document   : CrearUsuario_A
    Created on : 02/10/2020, 07:14:42 AM
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
        <h1 class="text-center">Crear usuario</h1>
        <hr>
        <form action="./CrearUsuario" method="post">
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
            <label for="contrasena">Contrasena: </label><br>
            <input class="label-default"  type="password" name="contrasena" id="contrasena" required><br><br><br><br>
            <div style="color: #008000;">${saveMessage}</div>
            <p>Selecciona el tipo de usuario:</p><br>
            <input type="radio" id="Tecnico" name="tipo" value="Tecnico">
            <label for="tecnico">Tecnico</label><br>
            <input type="radio" id="Repartidor" name="tipo" value="Repartidor">
            <label for="repartidor">Repartidor</label><br>
            <input type="radio" id="Administrador" name="tipo" value="Administrador">
            <label for="administrador">Administrador</label><br><br><br>
            <button class="btn-default" name="btn_guardar" value="Guardar usuario">Registrarse</button>
        </form>
        <form action="./CrearUsuario" method="get">
            <button class="btn-default"  name="btn_atras" value="Atras"/>Atras</button>
        </form>
        </div>
    </body>
</html>
