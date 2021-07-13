/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Usuario;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface UsuarioDao {

    public List<Usuario> findAllUsuarios();

    public int findUsuarioById(Usuario usuario);

    public boolean findUsuarioByNombreAndPassword(Usuario usuario);

    public int insertUsuario(Usuario usuario);

    public int updateUsuario(Usuario usuario);

    public int deleteUsuario(Usuario usuario);

}
