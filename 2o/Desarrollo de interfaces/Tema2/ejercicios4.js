/**
 * @author Sergio Trillo Rodriguez
 */
// 1. Crea una función que cuente el número de vocales de una cadena de caracteres.
function contarVocales(cadena) {
    let contador = 0;
    for (let letra of cadena)
        if ("aeiouAEIOU".includes(letra)) 
            contador++;
    return contador;
}

console.log(contarVocales("Ejemplo De Prueba")); 

// 2. Crea una función que determine si una cadena es un palíndromo, es decir, que se lee igual hacia delante que hacia atrás.
function esPalindromo(cadena) {
    cadena = cadena.toLowerCase().replace(/\s/g, '');
    let invertida = cadena.split('').reverse().join('');
    return cadena === invertida;
}
console.log(esPalindromo("se anina es"));

// 3. Crea una función que capitalice una cadena de texto. Es decir que todas las palabras empiecen por mayúscula.
function capitalizarCadena(cadena) {
    let palabras = cadena.split(' ');
    let resultado = '';
    for (let palabra of palabras) {
        resultado += palabra.charAt(0).toUpperCase() + palabra.slice(1) + ' ';
    }
    return resultado.trim();
}

function capitalizarCadenaFunciones(cadena) {
    return cadena.split(' ').map(palabra => palabra.charAt(0).toUpperCase() + palabra.slice(1)).join(' ');
}
console.log(capitalizarCadena("hola mundo"));

// 4. Dado un array de cadenas y una longitud n, crea una función que filtre el array dejando solo lascadenas de menor longitud que n.
function filtrarCadenas(array, n) {
    let resultado = [];
    for (let texto of array) 
        if (texto.length < n)
            resultado.push(texto);
    return resultado;
}
console.log(filtrarCadenas(["hola", "mundo", "JavaScript", "es", "genial"], 5));

// 5. Crea una función que cree el acrónimo de una cadena de caracteres tomando la primera letra de cada palabra y convirtiéndola a mayúscula. Por ejemplo la frase anterior sería CUFQCEADU….
function crearAcronimo(cadena) {
    let palabras = cadena.split(' ');
    let acronimo = '';
    for (let palabra of palabras) 
        acronimo += palabra[0].toUpperCase();
    
    return acronimo;
}
console.log(crearAcronimo("Crea una función que cuente las frases")); 


// 6. Crea una función que cuente las frases, palabras y letras presentes en un texto.
function contarTexto(texto) {
    const frases = (texto.match(/[.!?]/g) || []).length;
    const palabras = texto.split(/\s+/).length;
    const letras = texto.replace(/[^a-zA-Z]/g, '').length;
    return { frases, palabras, letras };
}

function contarTexto(texto) {
    let frases = (texto.match(/[.!?]/g) || []).length;
    let palabras = texto.trim().split(/\s+/).length;
    let letras = texto.replace(/[^a-zA-Z]/g, '').length;
    return { frases, palabras, letras };
}
console.log(contarTexto("Hola mundo. Esto es una prueba!"));

// 7. Crea una función que identifique si hay elementos duplicados en un array.
function tieneDuplicados(array) {
    for (let i = 0; i < array.length; i++)
        for (let j = i + 1; j < array.length; j++)
            if (array[i] === array[j]) 
                return true;
    return false;
}

// 8. Crea una función que debe retornar verdadero si alguno de los elementos de un array está repetido n veces.
function repetidoNVeces(array, n) {
    let contador = {};
    for (let elemento of array) {
        if (contador[elemento]) {
            contador[elemento]++;
        } else 
            contador[elemento] = 1;  
    }
    for (let clave in contador) 
        if (contador[clave] === n)
            return true;
    return false;
}

// 9. Crea un array que intercale dos arrays dados. Por ejemplo dados [a,b,c,d] y [1,2,3,4] el resultado sería [a,1,b,2,c,3,d,4]
function intercalarArrays(array1, array2) {
    let resultado = [];
    for (let i = 0; i < array1.length; i++) {
        resultado.push(array1[i]);
        resultado.push(array2[i]);
    }
    return resultado;
}

// 10. Crea una función que rote los elementos de un array n posiciones. Por ejemplo, dado el array [1,2,3,4,5,6] y el número 2 el resultado será: [5,6,1,2,3,4]
function rotarArray(array, n) {
    let parte1 = array.slice(-n);
    let parte2 = array.slice(0, array.length - n);
    return parte1.concat(parte2);
}

// 11. Crea una función que elimine de una cadena los caracteres dados en un array.
function eliminarCaracteres(cadena, caracteres) {
    let resultado = '';
    for (let letra of cadena) 
        if (!caracteres.includes(letra)) 
            resultado += letra;
    return resultado;
}

// 12. Crea una función que rote una matriz de tamaño nxn, 90 grados a la derecha.
function rotarMatriz90Grados(matriz) {
    let nueva = [];
    let n = matriz.length;
    for (let i = 0; i < n; i++) {
        nueva.push([]);
        for (let j = 0; j < n; j++)
            nueva[i][j] = matriz[n - j - 1][i];
    }
    return nueva;
}

// 13. Crea una función que determine si los paréntesis presentes en una cadena de texto están balanceados. Por ejemplo (a(b)) → Balanceado, (a(b(a)) → No balanceado.
function estanBalanceados(cadena) {
    let contador = 0;
    for (let letra of cadena) {
        if (letra === '(')
            contador++;
        if (letra === ')')
            contador--;
        if (contador < 0)
            return false;
    }
    return contador === 0;
}

// 14. Busca una submatriz dentro de una matriz más grande. El resultado debe ser las coordenadas donde se encuentra dicha matriz.
function encontrarSubmatriz(matriz, submatriz) {
    let filasM = matriz.length;
    let columnasM = matriz[0].length;
    let filasS = submatriz.length;
    let columnasS = submatriz[0].length;

    for (let i = 0; i <= filasM - filasS; i++) {
        for (let j = 0; j <= columnasM - columnasS; j++) {
            let encontrada = true;
            for (let x = 0; x < filasS; x++) {
                for (let y = 0; y < columnasS; y++) {
                    if (matriz[i + x][j + y] !== submatriz[x][y]) {
                        encontrada = false;
                        break;
                    }
                }
                if (!encontrada) break;
            }
            if (encontrada)
                return { fila: i, columna: j };
        }
    }
    return null;
}

// 15. Crea una función que verifique si una matriz de 9x9 es una solución de un sudoku.
function esSudokuValido(tablero) {
    function grupoValido(grupo) {
        let numeros = new Set(grupo);
        return numeros.size === 9 && [...numeros].every(n => n >= 1 && n <= 9);
    }

    for (let i = 0; i < 9; i++) {
        if (!grupoValido(tablero[i]))
            return false;
        let columna = [];
        for (let j = 0; j < 9; j++)
            columna.push(tablero[j][i]);
        if (!grupoValido(columna)) return false;
    }

    for (let i = 0; i < 9; i += 3) {
        for (let j = 0; j < 9; j += 3) {
            let subcuadro = [];
            for (let x = 0; x < 3; x++) 
                for (let y = 0; y < 3; y++) 
                    subcuadro.push(tablero[i + x][j + y]);
            if (!grupoValido(subcuadro))
                return false;
        }
    }
    return true;
}
