/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class UsuarioDaoJDBC implements UsuarioDao {

    private static final String SQL_SELECT = "SELECT * FROM usuario";

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM usuario WHERE id_cliente = ?";

    private static final String SQL_SELECT_NAME_AND_PASSWORD = "SELECT * FROM usuario WHERE nombre_usuario = ?"
            + " AND password_usuario = ?";

    private static final String SQL_INSERT = "INSERT INTO usuario(nombre_usuario, password_usuario) VALUES(?, ?)";

    private static final String SQL_UPDATE = "UPDATE usuario SET nombre_usuario = ?, password_usuario = ?"
            + " WHERE id_cliente = ?";

    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";

    @Override
    public List<Usuario> findAllUsuarios() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();

        List<Usuario> usuarios = new ArrayList<>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                usuario.setPasswordUsuario(rs.getString("password_usuario"));

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);

        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return usuarios;

    }

    @Override
    public int findUsuarioById(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean findUsuarioByNombreAndPassword(Usuario usuario) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean resultado = false;
        String usuarioRecuperado = "", passwordRecuerado = "";

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_NAME_AND_PASSWORD);
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getPasswordUsuario());
            rs = stmt.executeQuery();

            while (rs.next()) {

                usuarioRecuperado = rs.getString("nombre_usuario");
                passwordRecuerado = rs.getString("password_usuario");

            }
            
            //Se comparan los datos de usuario ingresado con el encontrado, para verificar que la contraseña y el usuario
            //coincidan

            if (usuario.getNombreUsuario().equals(usuarioRecuperado) && usuario.getPasswordUsuario().equals(passwordRecuerado)) {

                resultado = true;

            } else {
                resultado = false;
            }

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);

        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return resultado;

    }

    @Override
    public int insertUsuario(Usuario usuario) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getPasswordUsuario());
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
    public int updateUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
