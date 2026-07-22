import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReservaServiceTest {

    private SalaCine sala;
    private ReservaService reservaService;

    @BeforeEach
    void setUp() {

        sala = new SalaCine("Sala 1", 10);

        sala.agregarAsiento(new Asiento("A1", "VIP"));
        sala.agregarAsiento(new Asiento("A2", "VIP"));
        sala.agregarAsiento(new Asiento("A3", "ESTANDAR"));
        sala.agregarAsiento(new Asiento("A4", "4D"));
        sala.agregarAsiento(new Asiento("A5", "VIP"));
        sala.agregarAsiento(new Asiento("A6", "ESTANDAR"));

        reservaService = new ReservaService(sala);
    }

    @Test
    @DisplayName("CP-16: Reservar un asiento")
    void testReservarUnAsiento() {

        double total = reservaService.reservarAsientos(
                Arrays.asList("A1"));

        assertEquals(8.5, total);
        assertTrue(sala.buscarAsiento("A1").isOcupado());
    }

    @Test
    @DisplayName("CP-17: Reservar cuatro asientos con descuento")
    void testReservarCuatroAsientos() {

        double total = reservaService.reservarAsientos(
                Arrays.asList("A1", "A2", "A3", "A4"));

        // VIP + VIP + ESTANDAR + 4D = 34.0
        // Descuento del 15% = 28.9
        assertEquals(28.9, total, 0.001);
    }

    @Test
    @DisplayName("CP-18: Lista vacía")
    void testListaVacia() {

        assertThrows(IllegalArgumentException.class,
                () -> reservaService.reservarAsientos(Collections.emptyList()));
    }

    @Test
    @DisplayName("CP-19: Más de seis asientos")
    void testMasDeSeisAsientos() {

        assertThrows(IllegalArgumentException.class,
                () -> reservaService.reservarAsientos(
                        Arrays.asList("A1", "A2", "A3", "A4", "A5", "A6", "A7")));
    }

    @Test
    @DisplayName("CP-20: Reservar un asiento ya ocupado")
    void testReservarAsientoOcupado() {

        reservaService.reservarAsientos(Arrays.asList("A1"));

        assertThrows(IllegalStateException.class,
                () -> reservaService.reservarAsientos(Arrays.asList("A1")));
    }
}