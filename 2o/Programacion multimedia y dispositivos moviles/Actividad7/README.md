# Actividad 7 – Eventos de botones en Android

**Autor:** Sergio Trillo Rodriguez  
**Curso:** 2º DAM  
**Lenguaje:** Kotlin  
**IDE:** Android Studio  

---

## Descripción del proyecto

Esta aplicación de ejemplo permite trabajar con **eventos de botones** en Android.  
Contiene **tres botones** y un **TextView** para mostrar mensajes según la acción del usuario:

- **Saludar** → Muestra el mensaje: `"¡Hola!"`
- **No saludar** → Muestra el mensaje: `"No quiero saludar..."`
- **Saludar a clase** → Muestra el mensaje: `"¡Hola clase!"`

El objetivo es practicar **tres formas diferentes de manejar eventos de botones**:

1. Usando **`android:onClick` en el XML** y un método en la `MainActivity`.  
2. Implementando la **interfaz `View.OnClickListener`** en `MainActivity`.  
3. Usando **expresiones lambda** para asignar `setOnClickListener` a cada botón de forma individual.

---

## Estructura del proyecto

`` 
Actividad7/
├─ app/
│ ├─ src/
│ │ ├─ main/
│ │ │ ├─ java/com/example/actividad7/MainActivity.kt
│ │ │ └─ res/
│ │ │ └─ layout/activity_main.xml
│ │ └─ AndroidManifest.xml
└─ build.gradle

``

- `MainActivity.kt` → Contiene la lógica de los botones y la gestión de eventos.  
- `activity_main.xml` → Layout con los tres botones y el TextView.  

---

## Instrucciones de uso

1. Abrir el proyecto en **Android Studio**.  
2. Ejecutar la aplicación en un **emulador** o **dispositivo físico**.  
3. Pulsar cada botón para ver el mensaje correspondiente en el **TextView**.

---

## Funcionalidades

| Botón              | Mensaje mostrado            |
|-------------------|----------------------------|
| Saludar            | "¡Hola!"                   |
| No Saludar         | "No quiero saludar..."     |
| Saludar a clase    | "¡Hola clase!"             |

---

## Tecnologías utilizadas

- **Kotlin** como lenguaje principal.  
- **Android Studio** como IDE.  
- **SDK de Android** para desarrollo de aplicaciones móviles.  

---

## Notas

- La primera versión usa `android:onClick` en el XML.  
- La segunda versión implementa `View.OnClickListener`.  
- La tercera versión utiliza **lambdas** para simplificar el código.  


