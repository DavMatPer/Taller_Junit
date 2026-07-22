import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AsientoTest {
    Asiento asiento;
    Asiento asientoLimite;

    @BeforeEach
    void setUp(){
        asiento=new Asiento("A1","VIP");
    }

    @Test
    @DisplayName("Constructor crea asiento válido")
    void constructorValido(){
        assertFalse(asiento.isOcupado());
        assertEquals("A1",asiento.getCodigo());
    }

    // TODO: Traducir los demás casos de su tabla a métodos @Test.

    @Test
    @DisplayName("CP-04: Precio asiento valido Estandar")
    void calcularPrecioValido(){
        Asiento a = new Asiento("E1", "ESTANDAR");
        assertEquals(5.0, a.calcularPrecioBase());
    }

    @Test
    @DisplayName("CP-05: Precio asiento VIP")
    void testCalcularPrecioVip() {
        assertEquals(8.5, asiento.calcularPrecioBase());
    }

    @BeforeEach
    void setUpLimite(){
        asientoLimite = new Asiento("A2", "4D");
    }

    @Test
    @DisplayName("CP-06: Precio asiento 4D ")
    void calcularPrecioLimite(){
        assertEquals(12.0, asientoLimite.calcularPrecioBase());
    }

    @Test
    @DisplayName("CP-07: Ocupar asiento libre")
    void testOcuparAsiento(){
        asiento.ocupar();
        assertTrue(asiento.isOcupado());
    }
    @Test
    @DisplayName("CP-08: Liberar asiento ya ocupado")
    void testLiberarAsiento(){
        asiento.ocupar();
        asiento.liberar();
        assertFalse(asiento.isOcupado());
    }
    
    @Test
    @DisplayName("CP-09: Ocupar asiento ya ocupado ")
    void testOcuparAsientoOcupado(){
        asiento.ocupar();
        assertThrows(IllegalStateException.class, ()-> asiento.ocupar());
    }
}
