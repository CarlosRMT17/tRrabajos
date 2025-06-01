public class Socio {
    private String nombre;
    private boolean esVIP = false;
    private int totalPagado = 0;

    public void establecerNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void marcarComoVIP() {
        this.esVIP = true;
    }

    public boolean esVIP() {
        return esVIP;
    }

    public void registrarPago(int monto) {
        totalPagado += monto;
    }

    public int getTotalPagado() {
        return totalPagado;
    }
}
