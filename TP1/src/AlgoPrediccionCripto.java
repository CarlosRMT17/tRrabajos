import java.util.*;

public class AlgoPrediccionCripto {
    private Criterio criterio;
    private List<Token> tokens;

    public AlgoPrediccionCripto() {
        this.tokens = new ArrayList<>();
    }

    public static AlgoPrediccionCripto conCriterio(String tipoCriterio) {
        AlgoPrediccionCripto algo = new AlgoPrediccionCripto();
        algo.criterio = Criterio.deTipo(tipoCriterio);
        return algo;
    }

    public Prediccion prediccionDe(String nombreToken, String nombreRecomendador) {
        return tokens.stream()
                .filter(token -> token.getNombre().equals(nombreToken) && token.getNombreDelRecomendador().equals(nombreRecomendador))
                .findFirst()
                .map(token -> new Prediccion(token.calcularPrediccion()))
                .orElseThrow(TokenYRecomendadorNoEncontrado::new);
    }

    public String obtenerDivulgadorSegunCriterio() {
        return criterio.divulgadorSegunCriterio(tokens);
    }

    public void registrarToken(String nombreToken, double valor, String nombreRecomendador,
                               int edad, double patrimonio, String nacionalidad, String colorDePelo)
            throws ColorDePeloNoReconocido, NacionalidadNoReconocida {

        Recomendador recomendador = Recomendador.conNombre(nombreRecomendador, edad, patrimonio, nacionalidad, colorDePelo);
        Token token = Token.conNombre(nombreToken, valor, recomendador);
        tokens.add(token);
    }

}
