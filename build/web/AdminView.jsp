<%-- 
    Document   : Principal.jsp
    Created on : 30/09/2020, 07:16:42 PM
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
        <h1 class="text-center">Pagina principal administrador</h1>
        <hr>
        <form action="./AdministradorC" method="post">
            <button class="btn-default" name="btn_categorias" value="Categorias"/>Administrar Categorias</button>
            <button class="btn-default" name="btn_usuarios" value="Usuarios"/>Administrar Usuarios</button>
            <button class="btn-default" name="btn_productos" value="Productos"/>Administrar Productos</button>
        </form>
    </body>
</html>