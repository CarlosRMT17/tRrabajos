import java.util.HashSet;
import java.util.Set;

public class Club {
    private String nombre;
    private int tarifaSocio;
    private int tarifaSocioVIP;
    private int recaudacion = 0;
    private Set<Socio> socios = new HashSet<>();

    public void establecerNombre(String nombre) {
        this.nombre = nombre;
    }

    public void establecerTarifaSocio(int tarifa) {
        this.tarifaSocio = tarifa;
    }

    public void establecerTarifaSocioVIP(int tarifa) {
        this.tarifaSocioVIP = tarifa;
    }

    public void agregarSocio(Socio socio) {
        socios.add(socio);
    }

    public void agregarSocioVIP(Socio socio) {
        socio.marcarComoVIP();
        socios.add(socio);
    }

    public void recibirPagoDe(String nombreSocio) {
        for (Socio socio : socios) {
            if (socio.getNombre().equals(nombreSocio)) {
                int monto = socio.esVIP() ? tarifaSocioVIP : tarifaSocio;
                recaudacion += monto;
                socio.registrarPago(monto);
                return;
            }
        }
        throw new IllegalArgumentException("Socio no encontrado: " + nombreSocio);
    }

    public int recaudacionTotal() {
        return recaudacion;
    }

    public Set<String> nombresSocios() {
        Set<String> nombres = new HashSet<>();
        for (Socio s : socios) {
            nombres.add(s.getNombre());
        }
        return nombres;
    }


    public int cantidadSocios() {
        return socios.size();
    }

    public int cantidadPagadaPor(String nombreSocio) {
        for (Socio socio : socios) {
            if (socio.getNombre().equals(nombreSocio)) {
                return socio.getTotalPagado();
            }
        }
        throw new IllegalArgumentException("Socio no encontrado: " + nombreSocio);
    }
}
