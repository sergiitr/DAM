/**
 * @author Sergio Trillo Rodriguez
 */


// Ejercicio a: Desestructura el día, mes y año e imprime la fecha
const miFecha = ['06', 'Octubre', '2021'];
const [diaHoy, mesHoy, añoHoy] = miFecha;
console.log(`La fecha es: ${diaHoy} de ${mesHoy} de ${añoHoy}`);

// Ejercicio b: Dado un array de números, desestructura los números en posiciones impares
const listaNumeros = [1, 2, 3, 4, 5, 6, 7, 8, 9];
const [, num2, , num4, , num6, , num8] = listaNumeros;
console.log(`Números en posiciones impares: ${num2}, ${num4}, ${num6}, ${num8}`);

// Ejercicio c: Desestructura el primer número, el segundo y el resto en otra variable
const [primeroNum, segundoNum, ...restoNums] = listaNumeros;
console.log(`Primer número: ${primeroNum}, Segundo número: ${segundoNum}, Resto: ${restoNums}`);

// Ejercicio d: Desestructura nombre, apellidos y teléfono del objeto
const datosPersona = { nombre: 'Luis', apellidos: 'Molina', telefono: '+34666554433' };
const { nombre: nom, apellidos: ape, telefono: tel } = datosPersona;
console.log(`Nombre: ${nom}, Apellidos: ${ape}, Teléfono: ${tel}`);

// Ejercicio e: Desestructurar cada entrada e imprimir llave y valor por separado
for (const [clave, valor] of Object.entries(datosPersona)) {
    console.log(`Llave: ${clave}, Valor: ${valor}`);
}

// Ejercicio f: Desestructura los puntos en las variables x1, y1, x2, y2
const coordenadas = [{ x: 1, y: 2 }, { x: 3, y: 4 }];
const [{ x: xP1, y: yP1 }, { x: xP2, y: yP2 }] = coordenadas;
console.log(`Punto 1: (${xP1}, ${yP1}), Punto 2: (${xP2}, ${yP2})`);

// Ejercicio g: Función que desestructura nombre y apellidos de un objeto e imprime
function mostrarNombreCompleto({ nombre, apellidos, ...otros }) {
    console.log(`Nombre Completo: ${nombre} ${apellidos}`);
}
const otraPersona = { nombre: 'Ana', apellidos: 'García', edad: 30, ciudad: 'Madrid', pais: 'España' };
mostrarNombreCompleto(otraPersona);

// Ejercicio h: Combina dos objetos con spread y elimina una propiedad
const objetoA = { a: 1, b: 2, c: 3 };
const objetoB = { d: 4, e: 5, f: 6 };
const combinadoObj = { ...objetoA, ...objetoB };
const { c: eliminado, ...resultado } = combinadoObj;
console.log(`Objeto combinado sin la propiedad 'c':`, resultado);

// Ejercicio i: Función que retorna un array y desestructura los valores
function generarValores() {
    return [10, 20, 30];
}
const [v1, v2, v3] = generarValores();
console.log(`Valores desestructurados: ${v1}, ${v2}, ${v3}`);

// Ejercicio j: Clonación profunda de un objeto anidado
const objetoComplejo = {
    nombre: 'Carlos',
    detalles: {
        edad: 28,
        habilidades: ['JavaScript', 'React', 'Node.js']
    }
};
const clonObj = JSON.parse(JSON.stringify(objetoComplejo));
console.log(clonObj);
