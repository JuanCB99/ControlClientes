package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
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
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.refrescarInfoClientes(request, response);
            }
        } else {
            this.refrescarInfoClientes(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.refrescarInfoClientes(request, response);
            }
        } else {
            this.refrescarInfoClientes(request, response);
        }
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        //se instancia un objeto de cliente con el atributo de id
        Cliente cliente = new Cliente(idCliente);
        //se elimina el cliente mediante la capa de datos, creando un objeto de tipo ClienteDaoJDBC
        ClienteDaoJDBC clienteDao = new ClienteDaoJDBC();
        int registrosAfectados = clienteDao.eliminar(cliente);

        //se refresca la informacion de la pagina de clientes 
        refrescarInfoClientes(request, response);

    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        int cc = Integer.parseInt(request.getParameter("cc"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = Double.parseDouble(request.getParameter("saldo"));

        //se instancia un objeto de cliente con todos los atributos
        Cliente cliente = new Cliente(idCliente, cc, nombre, apellido, email, telefono, saldo);
        //se modifican los datos mediante la capa de datos, creando un objeto de tipo ClienteDaoJDBC
        ClienteDaoJDBC clienteDao = new ClienteDaoJDBC();
        int registrosAfectados = clienteDao.actualiazar(cliente);

        //se refresca la informacion de la pagina de clientes 
        refrescarInfoClientes(request, response);
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos el id enviado desde la lista
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        Cliente cliente = new Cliente(idCliente);
        Cliente clienteEncontrado = new ClienteDaoJDBC().encontrar(cliente);
        System.out.println("CLIENTE: " + clienteEncontrado);
        //se comparte el cliente econstrado con el JSP en el scope de request y se despliega la vista de editar
        request.setAttribute("clienteEncontrado", clienteEncontrado);
        String jspEditar = "WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cc = Integer.parseInt(request.getParameter("cc"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = Double.parseDouble(request.getParameter("saldo"));

        //se instancia un objeto de cliente
        Cliente cliente = new Cliente(cc, nombre, apellido, email, telefono, saldo);
        //se insertan los datos mediante la capa de datos, creando un objeto de tipo ClienteDaoJDBC
        ClienteDaoJDBC clienteDao = new ClienteDaoJDBC();
        int registrosAfectados = clienteDao.insertar(cliente);

        //se refresca la informacion de la pagina de clientes 
        refrescarInfoClientes(request, response);
    }

    private void refrescarInfoClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("Clientes = " + clientes);
        //se debe usar el alcance de sesion, dado que al usar el metodo (sendRedirect();) no se puede recuperar la info
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", calcularSaldoTotal(clientes));
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");
    }

    private double calcularSaldoTotal(List<Cliente> clientes) {
        double sumaTotal = 0;
        for (Cliente cliente : clientes) {
            sumaTotal = cliente.getSaldoCliente() + sumaTotal;
        }
        return sumaTotal;
    }

}
