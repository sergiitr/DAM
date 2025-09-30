# Proyecto con Node.js y Express

Este proyecto utiliza **Node.js** y el framework **Express** para crear aplicaciones web o APIs.

---

## 1. Inicializar el proyecto

Para empezar, necesitas crear un archivo `package.json`, que almacenará la configuración de tu proyecto y la lista de dependencias (librerías que usa el proyecto).  
Ejecuta el siguiente comando en la carpeta de tu proyecto:

```bash
npm init
```

Este comando te hará una serie de preguntas sobre tu proyecto, como el nombre, versión, descripción, etc.  
Si deseas aceptar los valores por defecto, simplemente presiona **Enter** para cada pregunta.  

Al final, tendrás un archivo **`package.json`** en tu carpeta del proyecto.

---

## 2. Instalar Express como dependencia

Ahora, puedes instalar **Express** (u otros paquetes que necesites) usando NPM.  
Para instalar Express, ejecuta:

```bash
npm install express
```

Esto agregará Express en la sección de **dependencies** dentro de tu `package.json`.

---

## 3. Ejemplo de `package.json`

Después de inicializar el proyecto e instalar Express, tu archivo `package.json` podría verse así:

```json
{
  "name": "mi-proyecto",
  "version": "1.0.0",
  "description": "Un proyecto simple con Express",
  "main": "index.js",
  "scripts": {
    "start": "node index.js"
  },
  "author": "",
  "license": "ISC",
  "dependencies": {
    "express": "^4.18.2"
  }
}
```

---

## 4. Crear un servidor básico con Express

Crea un archivo `index.js` con el siguiente contenido:

```javascript
const express = require('express');
const app = express();
const port = 3000;

app.get('/', (req, res) => {
  res.send('¡Hola, mundo con Express!');
});

app.listen(port, () => {
  console.log(`Servidor escuchando en http://localhost:${port}`);
});
```

---

## 5. Ejecutar el proyecto

Finalmente, inicia tu servidor con:

```bash
npm start
```

Luego abre tu navegador en:  
👉 [http://localhost:3000](http://localhost:3000)

---

✅ ¡Listo! Ya tienes un proyecto básico con **Node.js** y **Express** funcionando.
