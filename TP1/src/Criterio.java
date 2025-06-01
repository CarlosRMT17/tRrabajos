import java.util.List;

public interface Criterio {
    String divulgadorSegunCriterio(List<Token> tokens);

    static Criterio deTipo(String tipo) {
        return switch (tipo) {
            case "Maximo" -> new CriterioMaximo();
            case "Minimo" -> new CriterioMinimo();
            default -> throw new CriterioDesconocido();
        };
    }
}
