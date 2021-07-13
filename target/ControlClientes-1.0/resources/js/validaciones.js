/**
 * Funcion para validar los elementos requeridos (*)
 * @param {object} forma
 */

function validarForma(forma) {

    //Validamos que la contraseña y la confirmacion coincidan
    var contrasenia = forma.contrasenia;
    var confirmContrasenia = forma.confirmaContrasenia;
    if (contrasenia.value == confirmContrasenia.value) {
        //si es asi se envia el formulario
        return true;
    } else {

        //El formulario no es valido
        alert("Las contraseñas no coinciden");
        contrasenia.focus();
        contrasenia.select();
        return false;

    }


}
