import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class RecomendadorTest {

    @Test
    public void test01_calcularPrediccionColorado() throws ColorDePeloNoReconocido, NacionalidadNoReconocida {
        double valorToken = 10;
        Recomendador recomendadorColorado = Recomendador.conNombre(
                "Lucas", 20, 30000, "Uruguay", "Colorado");

        double aumento = (30000 / 10.0) + (3 * 20); // 3000 + 60 = 3060
        double veracidad = 1.10;
        double prediccionEsperada = (aumento * veracidad) + valorToken;
        double prediccionObtenida = recomendadorColorado.calcularPrediccionDeTokenConValor(valorToken);

        assertEquals(prediccionEsperada, prediccionObtenida, 0.001);
    }

    @Test
    public void test02_calcularPrediccionMorocho() throws ColorDePeloNoReconocido, NacionalidadNoReconocida {
        double valorToken = 100;
        Recomendador recomendadorMorocho = Recomendador.conNombre(
                "Brian", 30, 100000, "Argentina", "Morocho");

        double aumento = (30 * 100000) / 10000000.0; // 3.0
        double veracidad = 0.75;
        double prediccionEsperada = (aumento * veracidad) + valorToken;

        double prediccionObtenida = recomendadorMorocho.calcularPrediccionDeTokenConValor(valorToken);

        assertEquals(prediccionEsperada, prediccionObtenida, 0.001);
    }

    @Test
    public void test03_calcularPrediccionRubio() throws ColorDePeloNoReconocido, NacionalidadNoReconocida {
        double valorToken = 50;
        Recomendador recomendadorRubio = Recomendador.conNombre(
                "Ana", 25, 6000000, "Canada", "Rubio");

        double aumento = 6000000 - (25 * 175000); // 6000000 - 4375000 = 1625000
        double veracidad = 1.10;
        double prediccionEsperada = (aumento * veracidad) + valorToken;

        double prediccionObtenida = recomendadorRubio.calcularPrediccionDeTokenConValor(valorToken);

        assertEquals(prediccionEsperada, prediccionObtenida, 0.001);
    }

    private Recomendador recomendador;

    @BeforeEach
    public void setUp() throws ColorDePeloNoReconocido, NacionalidadNoReconocida {
        recomendador = Recomendador.conNombre("Lucas", 35, 1000000, "Argentina", "Morocho");
    }

    @Test
    public void test04CalcularPrediccionConValorValido() {
        double valorToken = 50;
        double valorEsperado = 52.625;
        double resultado = recomendador.calcularPrediccionDeTokenConValor(valorToken);

        assertEquals(resultado, valorEsperado);
    }

    @Test
    public void test05CalcularPrediccionDeUnPeloCastanioError() {
        assertThrows(ColorDePeloNoReconocido.class, () -> {
            Recomendador recomendadorCastanio = Recomendador.conNombre("Lucas", 35, 1000000, "Argentina", "Castanio");
        });
    }


}