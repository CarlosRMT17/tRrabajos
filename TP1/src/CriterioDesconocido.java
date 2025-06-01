public class CriterioDesconocido extends RuntimeException {
    public CriterioDesconocido() {
        super("El criterio ingresado no es válido.");
    }
}