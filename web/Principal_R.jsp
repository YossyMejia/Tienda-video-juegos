<%-- 
    Document   : Principal_R
    Created on : 16/10/2020, 06:10:16 PM
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
        <h1 class="text-center">Pagina principal soporte</h1>
        <hr>
        <form action="./RepartidoPrincipal" method="post">
            <button class="btn-default" name="btn_historial" value="Historial"/>Ver historial de ordenes</button>
            <button class="btn-default btn-danger" name="btn_salir" value="Salir"/>Salir</button>
        </form>
    </body>
</html>