<%-- 
    Document   : index
    Created on : 25/06/2021, 09:36:10 PM
    Author     : Juan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymouse"></script>
        <script type="text/javascript" src="resources/js/validaciones.js"></script>

        <!-- Bootstrap core CSS -->

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>


        <!-- Custom styles for this template -->
        <link href="resources/css/signin.css" rel="stylesheet">
    </head>

    <body class="text-center">
        <main class="form-signin">
            <form method="POST" action="${pageContext.request.contextPath}/ServletLogin?accion=ingresar">
                <img class="mb-4" src="resources/images/userLogin.png" alt="" width="100" height="100">
                <h1 class="h3 mb-3 fw-normal">Inicie sesión</h1>

                <c:if test="${ingresar == false}">                   

                    <div class="alert alert-danger d-flex align-items-center" role="alert">
                        <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                        <div>
                            <i class="fas fa-exclamation-triangle"></i> Las credenciales no son correctas.
                        </div>
                    </div>

                </c:if>

                <c:if test="${nuevoUsuario == true}">    

                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        <i class="far fa-check-circle"></i><strong>Registrado!</strong> El nuevo usuario se registro con exito.
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>

                </c:if>  


                <div class="form-floating">
                    <input name="usuario" type="email" class="form-control" id="floatingInput" placeholder="name@example.com" required>
                    <label for="floatingInput">Correo electronico</label>
                </div>
                <div class="form-floating">
                    <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="Password" required>
                    <label for="floatingPassword">Contraseña</label>
                </div>

                <div class="checkbox mb-3">
                    <label>
                        <button type="button" data-bs-toggle="modal" data-bs-target="#agregarUsuarioModal" href="" >Crear un usuario</button>
                    </label>
                </div>

                <button class="w-100 btn btn-lg btn-warning" type="submit"><i class="fas fa-sign-in-alt"></i> Ingresar</button>
                <p class="mt-5 mb-3 text-muted">&copy; 2021</p>
            </form>

        </main>

        <jsp:include page="/WEB-INF/paginas/usuario/agregarUsuario.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script> 
    </body>
</html>