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
        <form action="./ClienteC" method="post">
            <button class="btn-default" name="btn_categorias" value="Categorias"/>Administrar Categorias</button>
            <button class="btn-default" name="btn_usuarios" value="Usuarios"/>Administrar Usuarios</button>
            <button class="btn-default" name="btn_soporte" value="Soporte"/>Solicitar Soporte</button>
            <button class="btn-default btn-group-xs" name="btn_salir" value="Salir"/>Salir</button>
        </form>
    </body>
</html>
