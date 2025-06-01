import java.util.Comparator;
import java.util.List;

public class CriterioMaximo implements Criterio {
    @Override
    public String divulgadorSegunCriterio(List<Token> tokens) {
        if (tokens.isEmpty()) throw new NoSeRegistraronDivulgadores();

        return tokens.stream()
                .max(Comparator.comparingDouble(Token::calcularPrediccion))
                .orElseThrow()
                .getNombreDelRecomendador();
    }
}
