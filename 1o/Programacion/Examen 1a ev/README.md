# Examen Programación - 1° Evaluación

## Descripción
Este programa simula un combate en Java entre un personaje controlado por el jugador y un jefe final llamado **Artorias**. El simulador incluye características de combate como:

- Uso de armas y escudos.
- Curación con estus (pociones).
- Turnos alternos entre jugador y jefe.

## Requisitos

El programa debe implementar las siguientes clases y records:

### Record `Escudo`
- **Atributos:**
  - `nombre` (String)
  - `defensa` (int)

### Record `Arma`
- **Atributos:**
  - `nombre` (String)
  - `daño` (int)

### Clase `Personaje`

#### Atributos:
- `nombre` (String): Nombre del personaje.
- `clase` (String): Clase del personaje.
- `vidaMaxima` (int): Vida máxima del personaje.
- `vidaActual` (int): Vida actual del personaje.
- `fuerza` (int): Fuerza del personaje.
- `resistencia` (int): Resistencia del personaje.
- `estus` (int): Cantidad de estus (inicializado a 10).
- `escudo` (Escudo): Escudo equipado.
- `arma` (Arma): Arma equipada.

#### Constructores:
1. **Constructor con atributos:** `nombre`, `clase`, `vidaMaxima`, `fuerza`, `resistencia`.
   - `vidaActual` debe ser igual a `vidaMaxima`.
2. **Constructor completo:** Atributos anteriores + `escudo` y `arma`.

#### Métodos:
- `int getVidaActual()`: Devuelve el atributo `vidaActual`.
- `int defensa()`: Devuelve la suma de la defensa del escudo y el doble de la resistencia del personaje.
- `void morir()`: Actualiza `vidaActual` a 0 y muestra el mensaje **"HAS MUERTO"** (método privado).
- `void recibirGolpe(int golpe)`: Resta el daño recibido al personaje y llama a `morir()` si su vida llega a 0.
- `int atacar()`: Devuelve el daño que el personaje inflige, calculado como el daño del arma + el doble de la fuerza.
- `void beberEstus()`: Consume un estus para recuperar salud (3 veces la resistencia). No puede superar `vidaMaxima`. Si no quedan estus, muestra **"No te quedan estus"**.

### Clase `Partida`

#### Métodos principales:

1. **`crearPersonaje()`**:
   - Muestra un menú donde el usuario puede escoger una clase:
     - **Guerrero**: `vidaMaxima = 1500`, `fuerza = 200`, `resistencia = 100`.
     - **Bandido**: `vidaMaxima = 1300`, `fuerza = 300`, `resistencia = 50`.
     - **Marginado**: `vidaMaxima = 800`, `fuerza = 200`, `resistencia = 80`.
   - Devuelve el personaje creado.

2. **`accion(Personaje pj, Personaje artorias)`**:
   - Muestra un menú con las acciones disponibles:
     - **Atacar:** Utiliza los métodos `atacar()` y `recibirGolpe()`.
     - **Beber Estus:** Usa el método `beberEstus()`.
   - Maneja las acciones tanto del jugador como de Artorias.

3. **`main(String[] args)`**:
   - Crea los objetos iniciales:
     - Escudo y arma de Artorias: `Gran escudo de Artorias` (defensa 80) y `Espadón de Artorias` (daño 60).
     - Personaje Artorias: Clase `Boss`, `vidaMaxima = 3000`, `fuerza = 200`, `resistencia = 150`.
     - Escudo del jugador: `Escudo emblema hierba` (defensa 30).
   - Permite al usuario crear su propio personaje con `crearPersonaje()`.
   - Alterna turnos usando un generador aleatorio.

### Turnos y Fin del Juego
- Se utiliza la clase `Random` para determinar a quién le toca cada turno:
  ```java
  Random random = new Random();
  int turno = random.nextInt(4); // 1 para Artorias, el resto para el jugador
  ```
- Si la `vidaActual` de cualquiera de los personajes llega a 0, el juego termina mostrando el mensaje:
  **"Fin de la partida"**.
