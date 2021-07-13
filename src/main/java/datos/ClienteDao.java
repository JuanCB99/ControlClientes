package datos;

import dominio.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface ClienteDao {
    
    public List<Cliente> listar();
    
    public Cliente encontrar(Cliente cliente);
    
    public int insertar(Cliente cliente);
    
    public int actualiazar(Cliente cliente);
    
    public int eliminar(Cliente cliente);
    
}
