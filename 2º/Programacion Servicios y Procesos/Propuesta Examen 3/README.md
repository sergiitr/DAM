# Proyecto: Opera y RealizaOperacion (Java)

## Funcionalidad del proyecto

Este proyecto contiene dos programas Java independientes. El programa principal, **Opera.java**, se encarga de compilar automáticamente el archivo `RealizaOperacion.java`, generar su JAR correspondiente y ejecutar las operaciones que introduzca el usuario. El segundo programa, **RealizaOperacion.java**, recibe una operación matemática con el formato `( + 3 5 )`, valida que cumpla el patrón correcto mediante una expresión regular y devuelve el resultado. Se pueden realizar sumas, restas, multiplicaciones y divisiones enteras. Si la operación es incorrecta o hay división por cero, se muestra un mensaje de error.

## Cómo ejecutar el proyecto

### Requisitos
- Tener instalado **Java JDK 8 o superior**.
- Comprobar que los comandos `javac`, `java` y `jar` funcionan en la terminal.

### Archivos necesarios
Guarda ambos archivos en la misma carpeta:
- `Opera.java`
- `RealizaOperacion.java`

### Pasos de ejecución

1. Compila el programa principal:
   ```bash
   javac Opera.java
2. Ejecuta el programa:
   ```bash
   java Opera
4. Introduce las operaciones que quieras calcular, una por línea, con el formato:
  ```bash
   ( + 3 5 )
   ( - 10 4 )
   ( * 6 7 )
   ( : 8 2 )
   Pulsa Enter sin escribir nada para finalizar.
  ```

## Notas
- Opera.java compila y genera automáticamente RealizaOperacion.jar, por lo que no es necesario hacerlo manualmente.
- No se redirigen flujos de entrada o salida; toda la comunicación se realiza mediante procesos independientes.
- El proyecto está pensado para ejecutarse directamente desde la terminal.
