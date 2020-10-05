<%-- 
    Document   : ResolverSolicitud_S
    Created on : 04/10/2020, 03:00:36 AM
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
        <h1 class="text-center">Resolver solicitud</h1>
        
        <div style="color: #FF0000;">${errorMessage}</div>
        <hr>
        <form action="./ResolverSolicitud" method="post">
            <label for="descripcion">Respuesta: </label><br><br>
            <textarea class="label-default" id="respuesta" name="respuesta" rows="4" cols="50" required></textarea><br><br><br>
            <div style="color: #008000;">${saveMessage}</div>
            <button class="btn-default"  name="idConsulta" value=<%=request.getParameter("idConsulta")%>>Responder</button>
        </form>
        <form action="./ResolverSolicitud" method="get">
            <button class="btn-default"  name="btn_atras" value="Atras"/>Atras</button>
        </form>
        </div>
    </body>
</html>
