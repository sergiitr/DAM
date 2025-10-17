// a - Crea un array “datos” vacío con un literal
let datos = [];

// b. Añade a "datos" los números del 1 al 50 con un bucle for.
for (let i = 1; i <= 50; i++) {
    datos.push(i);
}

/**
 * c. Elimina los elementos del 25 al 50 asignando 
 * un nuevo tamaño a la propiedad length
 */
datos.length = 24;

// d. Usa el operador spread para hacer una copia del array anterior.
 let copiaDatos = [...datos];

// e. Crea un array de tamaño 50 con el constructor Array.
let array50 = new Array(50);

// f. Copia el array anterior a otro con la factoría from.
let copiaArray50 = Array.from(array50);

/**
 * g. Crea un array multidimensional de 10 filas (i) y 10 columnas (j).
 * Inicializa cada celda con el valor i*j.
 */
let multiArray = [];
for (let i = 0; i < 10; i++) {
    let row = [];
    for (let j = 0; j < 10; j++) {
        row.push(i * j);
    }
    multiArray.push(row);
}

/**
 * h. Crea un array con la factoría of con los números del 1 al 5.
 * Después añade un elemento en la posición 10 y otro en la 50. 
 * Recorre el array con for imprimiendo valores y después con forEach.
 */
let arrayH = Array.of(1, 2, 3, 4, 5);
arrayH[10] = 10;
arrayH[50] = 50;
for (let i = 0; i < arrayH.length; i++) {
    console.log(arrayH[i]);
}
arrayH.forEach((value) => console.log(value));

// i. Elimina dos elementos con delete
delete arrayH[13];
delete arrayH[19];

// j. Calcula el producto de todos los numeros del array "datos" con foreach
let producto = 1;
datos.forEach((value) => {
    producto *= value;
});

// k. Cada elemento x del array "datos" debe cambiarse por x*x usando forEach
datos.forEach((value, index) => {
    datos[index] = value * value;
});

/**
 * l. Crea un nuevo array con map recorriendo cada elemento x de "datos"
 * donde cada elemento sea un string "El elemento es: x"
 * Usa template string
 */
let stringArray = datos.map((x) => `El valor es: ${x}`);

/**
 * m. Crea un nuevo array mediante map que incremente
 * cada elemento de datos en 5 unidades
 */
let array2 = datos.map((x) => x+5);

/**
 * n. Mediante filter, quedate con los numeros impares en un
 * nuevo array impares
 */
let numImpares = datos.filter((x) => x % 2 !== 0)

// o. Usa find para buscar el numero 13
let busquedaNum13 = datos.find((x) => x === 13);

// p. Usa every para comprobar si todos los números son positivos


// q. Calcula la sumatoria del array datos mediante reduce
let sumatoria = datos.reduce((acc, value) => acc + value, 0);

// r. Calcula el valor más pequeño del array mediante reduce.


// s. Usa flat para aplanar el array multidimensional que creaste anteriormente.


/**
 * q. Tenemos la cadena: “Vamos a usar flatMap. Es igual que map. Pero aplana los arrays”. Separa
 * mediante split las distintas frases. Después, mediante map, quita los espacios sobrantes (trim).
 * A continuación, usa flatMap para extraer todas las palabras de cada frase en un único array
 */
