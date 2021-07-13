<%-- 
    Document   : editarCliente
    Created on : 27/06/2021, 11:26:32 PM
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
        <title>Editar Clientes</title>
    </head>
    <body>

        <!--incluimos el cabecero desde otro archivo para ahorrar codigo html-->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>


        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${clienteEncontrado.idCliente}" method="POST" class="was-validated">

            <!--incluimos la seccion de botones de navegacion-->
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEditar.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                
                                <div class="card-header">
                                    <h4>
                                        Editar Cliente N°: ${clienteEncontrado.idCliente}
                                    </h4>
                                </div>

                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="nombre">CC:</label>
                                        <input type="number" class="form-control" name="cc" value="${clienteEncontrado.ccCliente}" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="nombre">Nombre:</label>
                                        <input type="text" class="form-control" name="nombre" value="${clienteEncontrado.nombreCliente}" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="nombre">Apellido:</label>
                                        <input type="text" class="form-control" name="apellido" value="${clienteEncontrado.apellidoCliente}" required>
                                    </div>     
                                    <div class="form-group">
                                        <label for="nombre">Email:</label>
                                        <input type="email" class="form-control" name="email" value="${clienteEncontrado.emailCliente}" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="nombre">Telefono:</label>
                                        <input type="tel" class="form-control" name="telefono" value="${clienteEncontrado.telefonoCliente}" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="nombre">Saldo:</label>
                                        <input type="number" class="form-control" name="saldo" value="${clienteEncontrado.saldoCliente}" step="any" required>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </form>


        <!--incluimos la seccion de pie de pagina-->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script> 
    </body>
</html>
