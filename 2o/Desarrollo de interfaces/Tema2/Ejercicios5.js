/**
 * @author Sergio Trillo Rodriguez
 */

// 1. Crea un programa que genere un array con 1000 números aleatorios del 0 al 99.
let numeros = [];
for (let i = 0; i < 1000; i++) 
    numeros.push(Math.floor(Math.random() * 100));

// a. Crea una función que calcule la media aritmética.
function calcularMedia(array) {
    let suma = 0;
    for (let num of array)
        suma += num;
    return suma / array.length;
}

// b. Calcula la frecuencia de cada número del 0 al 99.
function calcularFrecuencia(array) {
    let frecuencia = Array(100).fill(0);
    for (let num of array)
        frecuencia[num]++;
    return frecuencia;
}

// c. Crea una función que ordene el array de menor a mayor sin usar métodos de Javascript.
function ordenarManual(array) {
    for (let i = 0; i < array.length - 1; i++) {
        for (let j = i + 1; j < array.length; j++) {
            if (array[i] > array[j]) {
                let temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
    return array;
}

// d. Ahora, usa una función de Javascript para realizar la ordenación.
function ordenarJS(array) {
    return array.sort((a, b) => a - b);
}

// 2. Crea una función que calcule el factorial de un número usando un bucle.
function factorial(n) {
    let resultado = 1;
    for (let i = 2; i <= n; i++)
        resultado *= i;
    
    return resultado;
}

// 3. Crea una función que busque todas las ocurrencias de una palabra en un texto dado.
function buscarOcurrencias(texto, palabra) {
    let posiciones = [];
    let index = texto.indexOf(palabra);
    while (index !== -1) {
        posiciones.push(index);
        index = texto.indexOf(palabra, index + 1);
    }
    return posiciones;
}

// 4. Programa FizzBuzz del 1 al 100.
function fizzBuzz() {
    for (let i = 1; i <= 100; i++) {
        if (i % 15 === 0)
            console.log("fizzbuzz");
        else if (i % 3 === 0)
            console.log("fizz");
        else if (i % 5 === 0)
            console.log("buzz");
        else console.log(i);
    }
}

// 5. Página que genera un acertijo matemático simple.
function generarAcertijo() {
    let a = Math.floor(Math.random() * 10);
    let b = Math.floor(Math.random() * 10);
    let operador = Math.random() > 0.5 ? '+' : '-';
    let resultado = operador === '+' ? a + b : a - b;
    return { pregunta: `${a} ${operador} ${b}`, respuesta: resultado };
}

// 6. Página web que genera contraseñas aleatorias.
function generarPassword(longitud) {
    const caracteres = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()';
    let password = '';
    for (let i = 0; i < longitud; i++) 
        password += caracteres.charAt(Math.floor(Math.random() * caracteres.length));
    return password;
}

// 7. Script que cuenta vocales y consonantes en una cadena.
function contarVocalesConsonantes(cadena) {
    let vocales = 0, consonantes = 0;
    for (let letra of cadena.toLowerCase()) {
        if (/[aeiou]/.test(letra)) vocales++;
        else if (/[a-z]/.test(letra)) consonantes++;
    }
    return { vocales, consonantes };
}

// 8. Validación de formulario con nombre, correo y edad.
function validarFormulario(nombre, correo, edad) {
    let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (nombre.length <= 3)
        return false;
    if (edad < 0 || edad > 120)
        return false;
    if (!emailRegex.test(correo))
        return false;
    return true;
}

// 9. Implementa el cifrado César.
function cifradoCesar(texto, desplazamiento) {
    let resultado = '';
    for (let letra of texto) {
        if (letra.match(/[a-z]/i)) {
            let base = letra === letra.toUpperCase() ? 65 : 97;
            resultado += String.fromCharCode((letra.charCodeAt(0) - base + desplazamiento) % 26 + base);
        } else
            resultado += letra;
    }
    return resultado;
}

// 10. Cronómetro con comenzar, parar y reiniciar.
let segundos = 0;
let intervalo;

function comenzarCronometro() {
    intervalo = setInterval(() => {  segundos++;  mostrarTiempo(); }, 1000);
}

function pararCronometro() {
    clearInterval(intervalo);
}

function reiniciarCronometro() {
    clearInterval(intervalo);
    segundos = 0;
    mostrarTiempo();
}

function mostrarTiempo() {
    let min = Math.floor(segundos / 60);
    let seg = segundos % 60;
    console.log(`${min}:${seg < 10 ? '0' + seg : seg}`);
}

// 11. Tabla de multiplicar según valor del desplegable.
function tablaMultiplicar(numero) {
    let tabla = [];
    for (let i = 1; i <= 10; i++)
        tabla.push(`${numero} x ${i} = ${numero * i}`);
    return tabla;
}

// 12. Juego de Piedra, Papel o Tijera contra la máquina.
function jugarPPT(usuario) {
    const opciones = ['piedra', 'papel', 'tijera'];
    const maquina = opciones[Math.floor(Math.random() * 3)];
    if (usuario === maquina) return 'Empate';
    if ( (usuario === 'piedra' && maquina === 'tijera') || (usuario === 'papel' && maquina === 'piedra') || (usuario === 'tijera' && maquina === 'papel') )
        return 'Ganaste';
    return 'Perdiste';
}
