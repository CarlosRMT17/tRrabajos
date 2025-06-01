import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrediccionTest {
    @Test
    void test01PrediccionesDeIgualValorDanTrue() {
        double valorComparado = 100;
        double precision = 1.0;

        Prediccion prediccion = new Prediccion(100);

        assertTrue(prediccion.comparar(valorComparado, precision));
    }

    @Test
    void test02CompararPrediccionEnPesosDentroDePrecision(){
        Prediccion prediccion = new Prediccion(100);

        assertTrue(prediccion.compararEnPesos(119990,100));
    }
}