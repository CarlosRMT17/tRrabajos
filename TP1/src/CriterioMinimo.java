import java.util.Comparator;
import java.util.List;

public class CriterioMinimo implements Criterio {
    @Override
    public String divulgadorSegunCriterio(List<Token> tokens) {
        if (tokens.isEmpty()) throw new NoSeRegistraronDivulgadores();

        return tokens.stream()
                .min(Comparator.comparingDouble(Token::calcularPrediccion))
                .orElseThrow()
                .getNombreDelRecomendador();
    }
}
