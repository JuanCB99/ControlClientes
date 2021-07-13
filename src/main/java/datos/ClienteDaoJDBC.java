package datos;

import dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class ClienteDaoJDBC implements ClienteDao {

    private static final String SQL_SELECT = "SELECT id_cliente, cc_cliente, nombre_cliente, apellido_cliente, "
            + "email_cliente, telefono_cliente, saldo_cliente FROM cliente";

    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente, cc_cliente, nombre_cliente, apellido_cliente, "
            + "email_cliente, telefono_cliente, saldo_cliente FROM cliente WHERE id_cliente = ?";

    private static final String SQL_INSERT = "INSERT INTO cliente(cc_cliente, nombre_cliente, apellido_cliente, "
            + "email_cliente, telefono_cliente, saldo_cliente) VALUES(?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE cliente SET cc_cliente = ?, nombre_cliente = ?, apellido_cliente = ?, "
            + "email_cliente = ?, telefono_cliente = ?, saldo_cliente = ? WHERE id_cliente = ?";

    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente = ?";

    @Override
    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int idCliente = rs.getInt("id_cliente");
                int ccCliente = rs.getInt("cc_cliente");
                String nombreCliente = rs.getString("nombre_cliente");
                String apellidoCliente = rs.getString("apellido_cliente");
                String emailCliente = rs.getString("email_cliente");
                String telefonoCliente = rs.getString("telefono_cliente");
                double saldoCliente = rs.getDouble("saldo_cliente");

                cliente = new Cliente(idCliente, ccCliente, nombreCliente, apellidoCliente, emailCliente, telefonoCliente, saldoCliente);
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return clientes;
    }

    @Override
    public Cliente encontrar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();
            //el absolute se puede usar cuando solo se retorna un registro, en este caso 
            //estaba causando problemas
            //rs.absolute(1);
            while (rs.next()) {

                rs.getInt("id_cliente");
                int ccCliente = rs.getInt("cc_cliente");
                String nombreCliente = rs.getString("nombre_cliente");
                String apellidoCliente = rs.getString("apellido_cliente");
                String emailCliente = rs.getString("email_cliente");
                String telefonoCliente = rs.getString("telefono_cliente");
                double saldoCliente = rs.getDouble("saldo_cliente");

                cliente.setCcCliente(ccCliente);
                cliente.setNombreCliente(nombreCliente);
                cliente.setApellidoCliente(apellidoCliente);
                cliente.setEmailCliente(emailCliente);
                cliente.setTelefonoCliente(telefonoCliente);
                cliente.setSaldoCliente(saldoCliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return cliente;
    }

    @Override
    public int insertar(Cliente cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, cliente.getCcCliente());
            stmt.setString(2, cliente.getNombreCliente());
            stmt.setString(3, cliente.getApellidoCliente());
            stmt.setString(4, cliente.getEmailCliente());
            stmt.setString(5, cliente.getTelefonoCliente());
            stmt.setDouble(6, cliente.getSaldoCliente());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;

    }

    @Override
    public int actualiazar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, cliente.getCcCliente());
            stmt.setString(2, cliente.getNombreCliente());
            stmt.setString(3, cliente.getApellidoCliente());
            stmt.setString(4, cliente.getEmailCliente());
            stmt.setString(5, cliente.getTelefonoCliente());
            stmt.setDouble(6, cliente.getSaldoCliente());
            stmt.setInt(7, cliente.getIdCliente());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    @Override
    public int eliminar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getIdCliente());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;

    }

}
