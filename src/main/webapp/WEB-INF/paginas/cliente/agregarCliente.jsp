<%-- 
    Document   : agregarCliente
    Created on : 26/06/2021, 10:21:15 AM
    Author     : Juan
--%>

<!-- Modal -->
<!--
<div class="modal fade" id="agregarClienteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
-->
<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info bg-dark  text-white">
                <h5 class="modal-title">
                    Agregar Cliente
                </h5>
                <button type="button" class="btn-close bg-danger" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">CC:</label>
                        <input type="number" class="form-control" name="cc" required>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Apellido:</label>
                        <input type="text" class="form-control" name="apellido" required>
                    </div>     
                    <div class="form-group">
                        <label for="nombre">Email:</label>
                        <input type="email" class="form-control" name="email" required>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Telefono:</label>
                        <input type="tel" class="form-control" name="telefono" required>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Saldo:</label>
                        <input type="number" class="form-control" name="saldo" step="any" required>
                    </div>
                </div>
                <div class="modal-footer">                 
                    <button class="btn btn-warning" type="reset"><i class="fas fa-eraser"></i> Limpiar</button>
                    <button class="btn btn-primary" type="submit"><i class="fas fa-save"></i> Guardar</button>
                </div>
            </form>

        </div>
    </div>
</div>
