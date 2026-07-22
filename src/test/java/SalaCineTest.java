/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author CltControl
 */
public class SalaCineTest {
    
    private SalaCine sala;
    
    
    @BeforeEach
    /**
     * Crea una sala de cine con una capacidad de 2 para facilitar las pruebas
     */
    void setUp() {
        sala = new SalaCine("Sala 1", 2);
    }
    

    @Test
    @DisplayName("CP-10: Agregar un asiento correctamente")
    /**
     * Prueba para colocar un asiento y se espera que actue correctamente
     */
    void testAgregarAsiento() {

        Asiento asiento = new Asiento("A1", "VIP");

        sala.agregarAsiento(asiento);

        assertEquals(asiento, sala.buscarAsiento("A1"));
    }

    @Test
    @DisplayName("CP-11: Agregar asientos hasta la capacidad máxima")
    /**
     * Prueba para tertear el límite de insertar asíentos.
     */
    void testAgregarHastaCapacidad() {

        sala.agregarAsiento(new Asiento("A1", "VIP"));
        sala.agregarAsiento(new Asiento("A2", "ESTANDAR"));

        assertEquals(2, sala.contarDisponibles());
    }

    @Test
    @DisplayName("CP-12: No permitir códigos repetidos")
    /**
     * Teste para agregar asientos repetidos y que salga error.
     */
    void testAgregarAsientoRepetido() {

        sala.agregarAsiento(new Asiento("A1", "VIP"));

        assertThrows(IllegalArgumentException.class, () -> {
        sala.agregarAsiento(new Asiento("A1", "4D"));
        });
    }

    @Test
    @DisplayName("CP-13: Buscar asiento existente")
    void testBuscarAsientoExistente() {

        Asiento asiento = new Asiento("B1", "VIP");

        sala.agregarAsiento(asiento);

        assertEquals(asiento, sala.buscarAsiento("B1"));
    }

    @Test
    @DisplayName("CP-14: Buscar asiento inexistente")
    void testBuscarAsientoInexistente() {

        assertThrows(NoSuchElementException.class, () -> {
        sala.buscarAsiento("Z9");
        });
    }

    @Test
    @DisplayName("CP-15: Calcular ingreso total")
    void testCalcularIngresoTotal() {

        Asiento a1 = new Asiento("A1", "VIP");
        Asiento a2 = new Asiento("A2", "ESTANDAR");

        sala.agregarAsiento(a1);
        sala.agregarAsiento(a2);

        a1.ocupar();
        a2.ocupar();

        assertEquals(13.5, sala.calcularIngresoTotal());
    }
}
