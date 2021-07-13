<%-- 
    Document   : clientes
    Created on : 25/06/2021, 09:43:43 PM
    Author     : Juan
--%>

<%@page import="dominio.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymouse"></script>
        <link href="resources/css/headers.css" rel="stylesheet">
        <title>Control de Clientes</title>
    </head>
    <body>

        <!--incluimos el cabecero desde otro archivo para ahorrar codigo html-->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>

        <!--incluimos la seccion de botones de navegacion-->
        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp"/>

        <!--incluimos la seccion que listara los clientes-->
        <jsp:include page="/WEB-INF/paginas/cliente/listadoClientes.jsp"/>

        <!--incluimos la seccion de pie de pagina-->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script> 
    </body>
</html>
