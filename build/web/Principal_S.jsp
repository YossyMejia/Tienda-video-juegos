<%-- 
    Document   : Principal_S
    Created on : 04/10/2020, 02:11:12 AM
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
        <h1 class="text-center">Pagina principal soporte</h1>
        <hr>
        <form action="./SoporteC" method="post">
            <button class="btn-default" name="btn_resolver" value="Resolver"/>Resolver consultas</button>
            <button class="btn-default btn-group-xs" name="btn_salir" value="Salir"/>Salir</button>
        </form>
    </body>
</html>