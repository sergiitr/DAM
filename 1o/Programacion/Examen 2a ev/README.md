# Examen de Programación - 2ª Evaluación: PolionCraft

## Descripción del Proyecto
Eres un alquimista en el mundo de _PolionCraft_ y necesitas desarrollar un sistema para gestionar distintas **pociones mágicas**. El proyecto consiste en implementar un conjunto de clases que modelen diferentes tipos de pociones, sus propiedades y su interacción en el juego.

## Requisitos

### Estructura del Código
1. **Enum `Potencia`**:
   - Valores: `FUERTE` (factor 1.2), `MEDIA` (factor 1.0), `DEBIL` (factor 0.8).
   - Atributo `factor` (double) y método `getFactor()`.

2. **Interfaz `Comerciable`**:
   - Constante `PRECIO_BASE = 50`.
   - Métodos: `int vender()` y `void regatear()`.

3. **Clase `Pocion`**:
   - Implementa `Comerciable` y `Comparable<Pocion>`.
   - Atributos: `nombre` (String), `potencia` (Potencia), `ingredientes` (String[]), `precio` (double).
   - Métodos:
     - `regatear()`: Aplica un multiplicador aleatorio (0.5 a 1.5) al precio.
     - `vender()`: Devuelve el precio redondeado.
     - `compareTo()`: Ordena por potencia (mayor a menor) y, en empate, por nombre (alfabético).
     - `toString()`: Muestra nombre y potencia (ej: "Poción Sandora FUERTE").
     - `mostrarDescripcion()`: Devuelve "Poción Sandora FUERTE es útil".
     - `hashCode()` y `equals()`: Dos pociones son iguales si tienen mismo nombre y potencia.
   - Documentación adecuada.

4. **Clase `PocionSanadora`** (hereda de `Pocion`):
   - Atributo `sanacion` (50 * factor de potencia).
   - Sobrescribe `mostrarDescripcion()` para añadir "para sanar a los enfermos".
   - Clase final (no heredable).

5. **Clase `PocionVenenosa`** (hereda de `Pocion`):
   - Atributo `danio` (50 * factor de potencia).
   - Sobrescribe `mostrarDescripcion()` para añadir "para dañar a los enemigos".
   - Clase final (no heredable).

6. **Clase Principal `Partida`**:
   - Método `main`:
     - Crea arrays de ingredientes para pociones sanadoras y venenosas.
     - Crea una lista `inventario` con 3 pociones sanadoras y 2 venenosas (todas las potencias).
     - Baraja el inventario con `Collections.shuffle()`.
     - Muestra el inventario usando `mostrarInventario()`.
     - Vende las 3 primeras pociones (mostrar descripción, regatear, vender, eliminar).
     - Ordena el inventario y muéstralo nuevamente.
   - Método `mostrarInventario`:
     - Muestra la lista de pociones.
     - Cuenta y muestra el número de pociones sanadoras y venenosas.


## Bonus (Opcional)
Mejora el proyecto añadiendo:
- Interfaz de usuario (clientes aleatorios pidiendo pociones, recolección de plantas, etc.).
- Jugabilidad adicional para aumentar la nota.
