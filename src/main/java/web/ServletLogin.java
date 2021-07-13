/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import datos.UsuarioDao;
import datos.UsuarioDaoJDBC;
import dominio.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juan
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

    boolean usuarioNuevo = false;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "ingresar":
                    this.ingresar(request, response);
                    break;
                case "agregar":
                    this.agregarUsuario(request, response);
                    break;
                default:
                    response.sendRedirect("index.jsp");
            }
        } else {
            response.sendRedirect("index.jsp");
        }

    }

    private void ingresar(HttpServletRequest request, HttpServletResponse response) throws IOException {

        boolean ingresar = true;
        String nombreUsuario = "";
        Usuario usuarioLogin = new Usuario(request.getParameter("usuario"), request.getParameter("password"));
        UsuarioDaoJDBC usuarioDaoJdbc = new UsuarioDaoJDBC();
        boolean usuarioEncontrado = usuarioDaoJdbc.findUsuarioByNombreAndPassword(usuarioLogin);
        HttpSession sesion = request.getSession();

        System.out.println("SE ENCONTRO EL USUARIO: " + usuarioEncontrado);

        //se evalua el resultado de buscar al usuario que ingresa, su es true entonces el usuario tiene acceso a la aplicacion,
        //y se comparten datos en el scope de Session para evitar que se pierdan al cambiar de interfaz o terminar la peticion POST
        if (usuarioEncontrado == true) {

            response.sendRedirect("/ControlClientes/ServletControlador");
            ingresar = true;
            usuarioNuevo = false;
            nombreUsuario = usuarioLogin.getNombreUsuario();
            sesion.setAttribute("nombreUsuario", nombreUsuario);
            sesion.setAttribute("nuevoUsuario", usuarioNuevo);
            sesion.setAttribute("ingresar", ingresar);

        } else {

            //de lo contrario, si no se encuentra el usuario, se mostrara un mensaje avisando al usuario de que las 
            //credenciales son incorrectas
            ingresar = false;
            usuarioNuevo = false;
            sesion.setAttribute("nuevoUsuario", usuarioNuevo);
            sesion.setAttribute("ingresar", ingresar);
            response.sendRedirect("index.jsp");

        }

    }

    private void agregarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession sesion = request.getSession();
        int usuarioInsertado = 0;
        Usuario nuevoUsuario = new Usuario(request.getParameter("email"), request.getParameter("contrasenia"));
        UsuarioDaoJDBC usuarioDaoJdbc = new UsuarioDaoJDBC();
        usuarioInsertado = usuarioDaoJdbc.insertUsuario(nuevoUsuario);

        //si el usuario insertado es TRUE quiere decir que se agrego con exito, entonces se envia un mensaje para avisar
        //y se redirige el index.jsp
        if (usuarioInsertado != 0) {

            usuarioNuevo = true;
            sesion.setAttribute("nuevoUsuario", usuarioNuevo);
            response.sendRedirect("index.jsp");

        } else {
            response.sendRedirect("index.jsp");
        }

    }


}
