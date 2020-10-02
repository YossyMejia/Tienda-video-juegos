<%-- 
    Document   : index
    Created on : 30/09/2020, 06:36:08 PM
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
        <div class="container">
        <h1>Bienvenido!</h1>
        <form action="./loginC" method="post">
        <div style="color: #FF0000;">${errorMessage}</div>
            <hr>
            <table class="table table-bordered">
                <tr>
                    <td>
                        Ingresa tu correo:
                    </td>
                    <td>
                        <input class="label-default" class="text-center" type="text" name="Correo" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Ingresa tu contrasena:
                    </td>
                    <td>
                        <input class="label-default" class="text-center" type="password" name="Password" required/>
                    </td>
                </tr>
            
            </table>
            <button class="btn btn-success btn-sm btn-group-lg"  name="btn_ingresar" value="Ingresar"/>Ingresar</button>
        </form>
        <form action="./loginC" method="get">
            <button class="btn btn-warning btn-sm btn-group-lg" name="btn_registrarse" value="Registrarse">Registrarse</button>
        </form>
        </div>
    </body>
</html>
