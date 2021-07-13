package dominio;

/**
 *
 * @author Juan
 */
public class Cliente {
    
    private int idCliente;
    private int ccCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String emailCliente;
    private String telefonoCliente;
    private double saldoCliente;

    public Cliente() {
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(int ccCliente, String nombreCliente, String apellidoCliente, String emailCliente, String telefonoCliente, double saldoCliente) {
        this.ccCliente = ccCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.emailCliente = emailCliente;
        this.telefonoCliente = telefonoCliente;
        this.saldoCliente = saldoCliente;
    }

    public Cliente(int idCliente, int ccCliente, String nombreCliente, String apellidoCliente, String emailCliente, String telefonoCliente, double saldoCliente) {
        this.idCliente = idCliente;
        this.ccCliente = ccCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.emailCliente = emailCliente;
        this.telefonoCliente = telefonoCliente;
        this.saldoCliente = saldoCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCcCliente() {
        return ccCliente;
    }

    public void setCcCliente(int ccCliente) {
        this.ccCliente = ccCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public double getSaldoCliente() {
        return saldoCliente;
    }

    public void setSaldoCliente(double saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", ccCliente=" + ccCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente + ", emailCliente=" + emailCliente + ", telefonoCliente=" + telefonoCliente + ", saldoCliente=" + saldoCliente + '}';
    }
    
    
}
