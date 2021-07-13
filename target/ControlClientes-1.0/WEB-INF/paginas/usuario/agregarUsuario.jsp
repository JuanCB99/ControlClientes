<div class="modal fade" id="agregarUsuarioModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info bg-dark  text-white">
                <h5 class="modal-title">
                    Registrar Usuario
                </h5>
                <button type="button" class="btn-close bg-danger" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <form action="${pageContext.request.contextPath}/ServletLogin?accion=agregar" method="POST" 
                  class="was-validated" onsubmit="return validarForma(this);">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Email:</label>
                        <input type="email" class="form-control" name="email" required>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Contraseña:</label>
                        <input type="password" class="form-control" name="contrasenia" required>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Confirmar contraseña:</label>
                        <input type="password" class="form-control" name="confirmaContrasenia" required>
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

