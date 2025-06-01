import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClubTest {
    private Club club;

    @BeforeEach
    void setUp() {
        club = new Club();
        club.establecerNombre("Club Social y Deportivo Orientado a Objetos");
        club.establecerTarifaSocio(500);
        club.establecerTarifaSocioVIP(700);

        Socio socio1 = new Socio();
        socio1.establecerNombre("Carlos");
        club.agregarSocio(socio1);

        Socio socio2 = new Socio();
        socio2.establecerNombre("Marcio");
        club.agregarSocioVIP(socio2);
    }

    @Test
    void test01LaRecaudacionInicialDelClubDebeSerCero() {
        int recaudacion = club.recaudacionTotal();

        assertEquals(0, recaudacion);
    }

    @Test
    void test02SeAgreganDosSociosAlClubYSeDevuelveElConjuntoDeSusNombres() {

        Set<String> nombresSocios = club.nombresSocios();

        assertEquals(Set.of("Carlos", "Marcio"), nombresSocios);
    }

    @Test
    void test03SeAgreganDosSociosAlClubYLaCantidadDeSociosEsDos() {

        int cantidadDeSocios = club.cantidadSocios();

        assertEquals(2, cantidadDeSocios);
    }

    @Test
    void test04SeAgregaUnSocioComunYOtroVipYRealizanUnPagoCadaUnoYLaRecaudacionTotalEs1200() {

        club.recibirPagoDe("Carlos");
        club.recibirPagoDe("Marcio");

        int recaudacionTotal = club.recaudacionTotal();

        assertEquals(1200,recaudacionTotal);
    }

    @Test
    void test05SeAgreganDosSociosComunesYOtroVipYRealizanTresPagosCadaUnoYLaRecaudacionTotalEs5100() {

        Socio socio3 = new Socio();
        socio3.establecerNombre("Pablo");
        club.agregarSocio(socio3);

        for (int i = 0; i < 3; i++) {
            club.recibirPagoDe("Marcio");
            club.recibirPagoDe("Carlos");
            club.recibirPagoDe("Pablo");
        }

        int recaudacionTotal = club.recaudacionTotal();
        assertEquals(5100,recaudacionTotal);
    }

    @Test
    void test06SeAgreganDosSociosComunesYOtroVipYRealizanSietePagosComunYLaCantidadPagadaPorElSegundoSocioComunEs1500() {

        Socio socio3 = new Socio();
        socio3.establecerNombre("Pablo");
        club.agregarSocio(socio3);

        for (int i = 0; i < 3; i++) {
            club.recibirPagoDe("Marcio");
            club.recibirPagoDe("Carlos");
            club.recibirPagoDe("Pablo");
        }
        club.recibirPagoDe("Marcio");
        club.recibirPagoDe("Carlos");

        int cantidadPagada = club.cantidadPagadaPor("Pablo");
        assertEquals(1500,cantidadPagada);
    }
}