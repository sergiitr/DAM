// a. Crea una cadena multilínea con comillas dobles.
let textoMultilinea = "Esta es la primera línea.\nEsta es la segunda línea.\nEsta es la tercera línea.";

// b. Añade a la cadena algún retorno de carro y tabuladores con el símbolo de escape.
let textoConEscape = "Primera línea con tabulador:\tAquí hay un tab.\nSegunda línea con retorno de carro.\rEste es el retorno de carro.";

// c. Añade a la cadena el carácter \
let ejemploBarra = "Este es un ejemplo de la barra invertida: \\";

// d. Concatena otra cadena con el operador +
let textoConcatenado = textoMultilinea + " Esta es una nueva línea concatenada.";

// e. Concatena cadenas usando una template string, muestra el valor de varias variables en el template string
let nombre = "Juan";
let edad = 25;
let ciudad = "Madrid";
let infoTemplate = `Mi nombre es ${nombre}, tengo ${edad} años y vivo en ${ciudad}.`;

// f. Separa un texto que tenga varias frases en un array que tenga cada frase por separado.
let texto = "Esta es la primera frase. Esta es la segunda frase. Esta es la tercera frase.";
let arrayFrases = texto.split('. ');

// g. Convierte un texto dado a minúsculas.
let textoMayusculas = "ESTE ES UN TEXTO EN MAYÚSCULAS.";
let textoMinusculas = textoMayusculas.toLowerCase();

// h. Convierte un texto dado a mayúsculas.
let textoMinus = "este es un texto en minúsculas.";
let textoMayus = textoMinus.toUpperCase();

// i. Recorre con un bucle el texto caracter a caracter imprimiéndolo.
let textoParaRecorrer = "Recorre este texto.";
for (let caracter of textoParaRecorrer) {
    console.log(caracter);
}

// j. Busca una subcadena en un texto.
let subcadena = "frase";
let posicionSubcadena = texto.indexOf(subcadena);
console.log(`La subcadena '${subcadena}' se encuentra en la posición: ${posicionSubcadena}`);

// k. Extrae en una variable la subcadena desde la posición 3 hasta el final del texto.
let subcadenaDesdePosicion = textoParaRecorrer.substring(3);
console.log(subcadenaDesdePosicion);

// l. Extrae en una variable la subcadena desde la posición 3 hasta la primera ocurrencia de una palabra en el texto.
let palabraBuscar = "texto";
let subcadenaHastaPalabra = textoParaRecorrer.substring(3, textoParaRecorrer.indexOf(palabraBuscar));
console.log(subcadenaHastaPalabra);

// m. Reemplaza todos los espacios del texto por un -
let textoConEspacios = "Este es un texto con espacios.";
let textoConGuiones = textoConEspacios.replace(/ /g, "-");
console.log(textoConGuiones);

// n. Elimina los espacios antes y después del texto.
let textoConEspaciosExtremos = " Este texto tiene espacios al inicio y al final. ";
let textoSinEspaciosExtremos = textoConEspaciosExtremos.trim();
console.log(textoSinEspaciosExtremos);

// o. Crea una cadena que no tenga ningún espacio partiendo de otra dada.
let textoSinEspacios = textoConEspacios.replace(/\s/g, "");
console.log(textoSinEspacios);

// p. Crea una función que invierta una cadena de texto.
function invertirCadena(cadena) {
    return cadena.split('').reverse().join('');
}
let cadenaInvertida = invertirCadena("Invertir esta cadena");
console.log(cadenaInvertida);

// q. Usa una expresión regular para comprobar que la cadena tiene números.
let cadenaConNumeros = "Este texto tiene números 1234.";
let tieneNumeros = /\d/.test(cadenaConNumeros);
console.log(`La cadena tiene números? ${tieneNumeros}`);

// r. Usa una expresión regular para comprobar que la cadena termina en punto.
let cadenaConPuntoFinal = "Esta cadena termina en punto.";
let terminaEnPunto = /\.$/.test(cadenaConPuntoFinal);
console.log(`La cadena termina en punto? ${terminaEnPunto}`);

// s. Usa una expresión regular para comprobar que la cadena comienza por una mayúscula.
let cadenaConMayuscula = "Este texto comienza con mayúscula.";
let comienzaConMayuscula = /^[A-Z]/.test(cadenaConMayuscula);
console.log(`La cadena comienza con mayúscula? ${comienzaConMayuscula}`);

// t. Usa una expresión regular para comprobar si la cadena contiene un teléfono con código internacional.
let cadenaConTelefono = "El número de contacto es +34 123 456 789.";
let tieneTelefonoInternacional = /\+\d{1,3}\s\d{3}\s\d{3}\s\d{3}/.test(cadenaConTelefono);
console.log(`La cadena contiene un teléfono con código internacional? ${tieneTelefonoInternacional}`);

// u. Reemplaza cualquier ocurrencia de un + seguido de números por la cadena SECRETO
let textoConCodigoSecreto = cadenaConTelefono.replace(/\+\d{1,3}/g, "SECRETO");
console.log(textoConCodigoSecreto);