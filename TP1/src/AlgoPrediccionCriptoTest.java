import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AlgoPrediccionCriptoTest {
    @Test
    void test01UnRecomendadorArgentinoConCiertoColorDePeloPatrimonioYEdadPuedePredecirUnAumentoDeCiertaCriptoDeCiertoValor()
            throws ColorDePeloNoReconocido, NacionalidadNoReconocida {

        double prediccionEsperada = 3807.25;

        AlgoPrediccionCripto algoPrediccionCripto = AlgoPrediccionCripto.conCriterio("Maximo");
        algoPrediccionCripto.registrarToken("$MASIVO", 10, "Matias", 21, 50000, "Argentina", "Colorado");

        Prediccion prediccionObtenida = algoPrediccionCripto.prediccionDe("$MASIVO", "Matias");

        assertTrue(prediccionObtenida.comparar(prediccionEsperada, 0.001));
    }

    @Test
    void test02UnRecomendadorExtranjeroConCiertoColorDePeloPatrimonioYEdadPuedePredecirUnAumentoDeCiertaCriptoDeCiertoValor()
            throws ColorDePeloNoReconocido, NacionalidadNoReconocida {
        double prediccionEsperada = 314986000.0;

        AlgoPrediccionCripto algoPrediccionCripto = AlgoPrediccionCripto.conCriterio("Maximo");
        algoPrediccionCripto.registrarToken("$MAGA",1000,"Donald",78,300000000,"Estados Unidos","Rubio");

        Prediccion prediccionObtenida = algoPrediccionCripto.prediccionDe("$MAGA", "Donald");

        assertTrue(prediccionObtenida.comparar(prediccionEsperada, 0.001));
    }

    @Test
    void test03UnRecomendadorMorochoConCiertaEdadyPatrimonioPuedePredecirUnAumentoDeCiertaCriptoDeCiertoValor()
            throws ColorDePeloNoReconocido, NacionalidadNoReconocida {
        double prediccionEsperada = 2865.6;

        AlgoPrediccionCripto algoPrediccionCripto = AlgoPrediccionCripto.conCriterio("Maximo");
        algoPrediccionCripto.registrarToken("$X AE A-XII",1000,"Elon",53,320000000,"Sudafrica","Morocho");

        Prediccion prediccionObtenida = algoPrediccionCripto.prediccionDe("$X AE A-XII", "Elon");

        assertTrue(prediccionObtenida.comparar(prediccionEsperada, 0.001));
    }

    @Test
    void test04EntreUnRecomendadorYOtroDetectaAlQuePrediceUnMayorValor()
            throws ColorDePeloNoReconocido, NacionalidadNoReconocida {
        String divulgadorMayorGananciaEsperado = "Matias";
        AlgoPrediccionCripto algoPrediccionCripto = AlgoPrediccionCripto.conCriterio("Maximo");

        algoPrediccionCripto.registrarToken("$PLEBEYO", 10, "Matias", 21, 50000, "Argentina", "Colorado");
        algoPrediccionCripto.registrarToken( "$TESLA", 1000 , "Elon", 53 , 320000000 , "Sudafrica", "Morocho");

        String divulgadorMayorGananciaObtenido = algoPrediccionCripto.obtenerDivulgadorSegunCriterio();

        assertEquals(divulgadorMayorGananciaObtenido, divulgadorMayorGananciaEsperado);
    }

    @Test
    void test05EntreVariosRecomendadoresDetectoAlQuePrediceUnMenorValor()
        throws ColorDePeloNoReconocido, NacionalidadNoReconocida {
        String divulgadorMenorGananciaEsperado = "Javier";

        AlgoPrediccionCripto algoPrediccionCripto = AlgoPrediccionCripto.conCriterio("Minimo");
        algoPrediccionCripto.registrarToken("$MASIVO" , 10, "Matias", 21 , 50000, "Argentina", "Colorado");
        algoPrediccionCripto.registrarToken( "$BITCOIN", 1000 , "Elon", 53 , 320000000 , "Sudafrica", "Morocho");
        algoPrediccionCripto.registrarToken( "$BITCOIN", 1000 , "Donald", 78, 300000000 , "Estados Unidos", "Rubio");
        algoPrediccionCripto.registrarToken( "$LIBRA",1, "Javier", 54, 10000000, "Argentina", "Morocho");

        String divulgadorMenorGananciaObtenido = algoPrediccionCripto.obtenerDivulgadorSegunCriterio();

        assertEquals(divulgadorMenorGananciaObtenido,divulgadorMenorGananciaEsperado);
    }

    @Test
    void test06EntreVariosRecomendadoresDetectaAlQuePrediceUnMayorValor()
        throws ColorDePeloNoReconocido, NacionalidadNoReconocida {
        String divulgadorMayorGananciaEsperado = "Donald";
        AlgoPrediccionCripto algoPrediccionCripto = AlgoPrediccionCripto.conCriterio("Maximo");

        algoPrediccionCripto.registrarToken("$MASIVO" , 10 , "Matias", 21 , 50000, "Argentina", "Colorado");
        algoPrediccionCripto.registrarToken("$MECHANICUS", 1000 ,"Elon" , 53 , 320000000 ,"Sudafrica" ,"Morocho");
        algoPrediccionCripto.registrarToken( "$BITCOIN", 1000 , "Donald", 78 , 300000000 , "Estados Unidos", "Rubio");
        algoPrediccionCripto.registrarToken( "$LIBRA", 1, "Javier", 54 , 10000000 , "Argentina", "Morocho");

        String divulgadorMayorGananciaObtenido = algoPrediccionCripto.obtenerDivulgadorSegunCriterio();

        assertEquals(divulgadorMayorGananciaObtenido,divulgadorMayorGananciaEsperado);

    }

    @Test
    void test07UnRecomendadorConCiertoColorDePeloPatrimonioYEdadPuedePredecirUnAumentoDeCiertaCriptoDeCiertoValorEnPesos()
        throws ColorDePeloNoReconocido, NacionalidadNoReconocida {
        double prediccionEsperadaEnPesos = 4568700;

        AlgoPrediccionCripto algoPrediccionCripto = AlgoPrediccionCripto.conCriterio("Maximo");
        algoPrediccionCripto.registrarToken( "$MASIVO" ,10 ,"Matias" ,21 , 50000 ,"Argentina", "Colorado");
        Prediccion prediccionObtenida = algoPrediccionCripto.prediccionDe("$MASIVO","Matias");

        assertTrue(prediccionObtenida.compararEnPesos(prediccionEsperadaEnPesos,0.001));
    }
}