/**
 * @author Sergio Trillo Rodriguez
 * @description Ejercicios Arrays
 */

// a - Crea un array “datos” vacío con un literal
let datos = new Array();

// b. Añade a "datos" los números del 1 al 50 con un bucle for.
for (let n = 1; n <= 50; n++) {
    datos[datos.length] = n;
}

/**
 * c. Elimina los elementos del 25 al 50 asignando un nuevo tamaño a la propiedad length
 */
datos.length = 24;

// d. Usa el operador spread para hacer una copia del array anterior.
let copiaDatos = Array(...datos);

// e. Crea un array de tamaño 50 con el constructor Array.
let array50 = Array(50);

// f. Copia el array anterior a otro con la factoría from.
let copiaArray50 = Array.from(array50, (x) => x);

// g. Crea un array multidimensional de 10 filas (i) y 10 columnas (j).
// Inicializa cada celda con el valor i*j.
let multiArray = Array.from({ length: 10 }, (_, i) =>
    Array.from({ length: 10 }, (_, j) => i * j)
);

/**
 * h. Crea un array con la factoría of con los números del 1 al 5.
 * Después añade un elemento en la posición 10 y otro en la 50. 
 * Recorre el array con for imprimiendo valores y después con forEach.
 */
let arrayH = Array.of(1, 2, 3, 4, 5);
arrayH.splice(10, 0, 10);
arrayH[50] = 50;
for (let i = 0; i < arrayH.length; i++) console.log(arrayH[i]);
arrayH.forEach(v => console.log(v));

// i. Elimina dos elementos con delete
delete arrayH[13];
delete arrayH[19];

// j. Calcula el producto de todos los numeros del array "datos" con foreach
let producto = 1;
datos.forEach(num => producto *= num);

// k. Cada elemento x del array "datos" debe cambiarse por x*x usando forEach
datos.forEach((x, i, arr) => arr[i] = x ** 2);

/**
 * l. Crea un nuevo array con map recorriendo cada elemento x de "datos" donde cada elemento sea un string "El elemento es: x"
 * Usa template string
 */
let stringArray = datos.map(num => `El valor es: ${num}`);

/**
 * m. Crea un nuevo array mediante map que incremente
 * cada elemento de datos en 5 unidades
 */
let array2 = datos.map(valor => valor + 5);

/**
 * n. Mediante filter, quedate con los numeros impares en un
 * nuevo array impares
 */
let numImpares = datos.filter(num => num % 2);

// o. Usa find para buscar el numero 13
let busquedaNum13 = datos.find(v => v === 13);

// p. Usa every para comprobar si todos los números son positivos
let todosPositivos = datos.every(v => v > 0);

// q. Calcula la sumatoria del array datos mediante reduce
let sumatoria = datos.reduce((acc, v) => acc + v, 0);

// r. Calcula el valor más pequeño del array mediante reduce.
let valorMinimo = datos.reduce((min, v) => Math.min(min, v));

// s. Usa flat para aplanar el array multidimensional que creaste anteriormente.
let arrayAplanado = multiArray.flat();

/**
 * t. Tenemos la cadena: “Vamos a usar flatMap. Es igual que map. Pero aplana los arrays”. Separa
 * mediante split las distintas frases. Después, mediante map, quita los espacios sobrantes (trim).
 * A continuación, usa flatMap para extraer todas las palabras de cada frase en un único array
 */
let cadena = "Vamos a usar flatMap. Es igual que map. Pero aplana los arrays";
let frases = cadena.split(". ");
let palabras = frases.flatMap(oracion => oracion.trim().split(" "));

/**
 * u. Crea el array a [1,2,3,4,5] y b [6,7,8,9,10] con literales. Concatena los arrays a y b con concat.
 * Después con operador spread. Crea una variable const cola. Usa unshift y shift para añadir y quitar elementos.
 * Dado el array resultante de la concatenación de a y b, obten el subarray desde el índice 2 al penúltimo elemento (slice). 
 * Usa splice para quitar los 2 últimos elementos de un array.
 */
let a = [1, 2, 3, 4, 5];
let b = [6, 7, 8, 9, 10];
let concatenado = [].concat(a, b);
let concatenadoSpread = [...a, ...b];
const cola = concatenadoSpread.slice();
cola.unshift(-1);
cola.shift();
let subArray = concatenadoSpread.slice(2, -1);
subArray.splice(-2, 2);

// v. Rellena con fill un array de 100 elementos con -1.
let arrayRelleno = Array(100).fill(-1);

// w. Crea un array de cadenas. Busca con indexOf una cadena.
let cadenas = ["uno", "dos", "tres", "cuatro", "cinco"];
let indexCadena = cadenas.indexOf("tres");

// x. Comprueba si la cadena "hola" está dentro del array anterior.
let contieneHola = cadenas.includes("hola");

// y. Ordena la lista de cadenas anterior de forma alfabética con sort.
let cadenasOrdenadas = [...cadenas].sort();

/**
 * z. Crea un array vacío de 50 posiciones. Con forEach asigna valores aleatorios entre 0 y 100.
 * Después ordena con sort de menor a mayor. Cambia y ordena de mayor a menor.
 */
let arrayRandom = Array(50).fill(null);
arrayRandom = arrayRandom.map(() => Math.floor(Math.random() * 101));
arrayRandom.sort((a, b) => a - b);
arrayRandom.sort((a, b) => b - a);

// aa. Usa reverse para invertir el array anterior.
arrayRandom.reverse();
