<%-- 
    Document   : CrearSolicitud_C
    Created on : 03/10/2020, 11:35:49 PM
    Author     : XPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <h1>Solicitar Soporte</h1>
        <hr>
        <form action="./CrearSolicitud" method="post">
            <div style="color: #FF0000;">${errorMessage}</div>
            <label for="descripcion">Descripcion del problema: </label><br>
            <textarea class="label-default" id="descripcion" name="descripcion" rows="4" cols="50" required></textarea><br><br><br>
            <div style="color: #008000;">${saveMessage}</div>
            <button class="btn btn-success btn-sm btn-group-lg" name="btn_enviar" value="Enviar">Enviar consulta</button>
        </form>
        <form action="./CrearSolicitud" method="get">
            <button class="btn-default" name="btn_atras" value="atras"/>Atras</button>
        </form>
        </div>
    </body>
</html>
