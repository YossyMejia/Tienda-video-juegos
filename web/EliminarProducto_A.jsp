<%-- 
    Document   : EliminarProducto_A
    Created on : 09/10/2020, 11:09:41 PM
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
        <h1 class="text-center">Eliminar producto</h1>
        <div style="color: #FF0000;">${errorMessage}</div>
        <hr>
        <form action="./EliminarProducto" method="post">
            <label for="id">Seguro que desea eliminar el producto con identificador <%=request.getParameter("idProductoEliminar")%> ?</label><br><br><br>
            <button class="btn-default btn-danger"  name="idProductoEliminar" value=<%=request.getParameter("idProductoEliminar")%>>Confirmar eliminacion</button>
        </form>
        <form action="./EliminarProducto" method="get">
            <button class="btn-default"  name="btn_atras" value="Atras"/>Atras</button>
        </form>
        </div>
    </body>
</html>