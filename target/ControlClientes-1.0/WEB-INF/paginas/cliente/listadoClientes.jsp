<%-- 
    Document   : listadoClientes
    Created on : 25/06/2021, 11:19:42 PM
    Author     : Juan
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es_CO"/>

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>
                            Listado Clientes
                        </h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="table-dark">
                            <tr class="text-center">
                                <th>N°</th>
                                <th>CC</th>
                                <th>Nombre</th>
                                <th>Saldo</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--iteramos cada elemento de la lista clientes y lo anexamos en la tabla-->
                            <c:forEach var="cliente" items="${clientes}">
                                <tr class="text-center">
                                    <td>${cliente.idCliente}</td>
                                    <td>${cliente.ccCliente}</td>
                                    <td>${cliente.nombreCliente} ${cliente.apellidoCliente}</td>
                                    <td><fmt:formatNumber value="${cliente.saldoCliente}" type="currency"/></td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${cliente.idCliente}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-edit"></i> Editar
                                        </a>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idCliente=${cliente.idCliente}"
                                           class="btn btn-danger">
                                            <i class="fas fa-user-minus"></i> Eliminar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <!-- tarjetas que mostraran los totales-->

            </div>

            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>
                            Saldo Total
                        </h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${saldoTotal}" type="currency"/>
                        </h4>
                    </div>
                </div>

                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>
                            Total Clientes
                        </h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalClientes}
                        </h4>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>

<!-- Agregar cliente en una ventana MODAL-->
<jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp"/>