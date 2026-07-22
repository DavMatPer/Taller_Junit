# Taller #5

## Integrantes
- Nejeh Zouein
- David Matos
- Kevin Borbor

## Tabla de Casos de Prueba

| Clase | ID | Método | Datos de entrada | Salida esperada | Propósito |
|------|------|---------|------------------|-----------------|-----------|
| Asiento | CP-01 | Constructor | codigo="A1", tipo="VIP" | Objeto creado, ocupado=false | Caso válido |
| Asiento | CP-02 | Constructor | codigo="B5", tipo="4D" | Objeto creado, ocupado=false | Caso límite |
| Asiento | CP-03 | Constructor | codigo="", tipo="VIP" | IllegalArgumentException | Caso de error |
| Asiento | CP-04 | calcularPrecioBase() | tipo="ESTANDAR" | 5.0 | Caso válido |
| Asiento | CP-05 | calcularPrecioBase() | tipo="VIP" | 8.5 | Caso válido |
| Asiento | CP-06 | calcularPrecioBase() | tipo="4D" | 12.0 | Caso límite |
| Asiento | CP-07 | ocupar() | asiento libre | ocupado=true | Caso válido |
| Asiento | CP-08 | ocupar() | asiento recién creado | ocupado=true | Caso límite |
| Asiento | CP-09 | ocupar() | asiento ocupado | IllegalStateException | Caso de error |
| SalaCine | CP-10 | agregarAsiento() | asiento válido | Asiento agregado | Caso válido |
| SalaCine | CP-11 | agregarAsiento() | último asiento permitido | Asiento agregado | Caso límite |
| SalaCine | CP-12 | agregarAsiento() | código repetido | IllegalArgumentException | Caso de error |
| SalaCine | CP-13 | buscarAsiento() | código existente | Retorna Asiento | Caso válido |
| SalaCine | CP-14 | buscarAsiento() | único asiento | Retorna Asiento | Caso límite |
| SalaCine | CP-15 | buscarAsiento() | código inexistente | NoSuchElementException | Caso de error |
| ReservaService | CP-16 | reservarAsientos() | 1 asiento | Total sin descuento | Caso válido |
| ReservaService | CP-17 | reservarAsientos() | 4 asientos | Total con 15% descuento | Caso límite |
| ReservaService | CP-18 | reservarAsientos() | lista vacía | IllegalArgumentException | Caso de error |