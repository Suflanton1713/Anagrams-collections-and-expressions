# Taller 4: Colecciones y Expresiones For - Anagramas

## Descripción

Este proyecto implementa un sistema para generar anagramas de palabras y frases utilizando colecciones de Scala y expresiones `for`. Un anagrama es un reordenamiento de los caracteres de una palabra o frase que forma nuevas palabras o frases con significado.

## Estructura del Proyecto

El proyecto sigue la estructura estándar de Scala/SBT:

```
Anagrams-collections-and-expressions/
├── src/
│   ├── main/
│   │   └── scala/
│   │       └── Anagramas/
│   │           └── package.scala    # Implementación principal
│   └── test/
│       └── scala/
│           └── Pruebas.sc           # Casos de prueba
├── build.sbt                         # Configuración del proyecto
└── README.md                         # Este archivo
```

## Tipos de Datos

El proyecto define los siguientes tipos:

- **`Palabra`**: `String` - Representa una palabra sin espacios, signos de puntuación ni acentos, en minúsculas
- **`Frase`**: `List[Palabra]` - Representa una frase como lista de palabras
- **`Ocurrencias`**: `List[(Char, Int)]` - Lista de parejas (caracter, número) que indica cuántas veces aparece cada carácter

## Funciones Implementadas

### 1. `lOcPal(p: Palabra): Ocurrencias`
Calcula la lista de ocurrencias de una palabra. Utiliza `groupBy` y `map` para agrupar los caracteres y contar sus ocurrencias.

### 2. `lOcFrase(f: Frase): Ocurrencias`
Calcula la lista de ocurrencias de una frase completa. Concatena todas las palabras de la frase y utiliza `lOcPal` para calcular las ocurrencias.

### 3. `diccionarioPorOcurrencias: Map[Ocurrencias, List[Palabra]]`
Agrupa todas las palabras del diccionario por sus listas de ocurrencias. Esto permite buscar eficientemente anagramas de una palabra.

### 4. `anagramasDePalabra(palabra: Palabra): List[Palabra]`
Devuelve todos los anagramas de una palabra que existen en el diccionario. Utiliza `diccionarioPorOcurrencias` para buscar palabras con la misma lista de ocurrencias.

### 5. `combinaciones(locurrencias: Ocurrencias): List[Ocurrencias]`
Genera todas las posibles sublistas de ocurrencias (subconjuntos con repeticiones) de una lista de ocurrencias dada. Implementada usando expresiones `for`.

### 6. `complemento(lOc: Ocurrencias, sLoc: Ocurrencias): Ocurrencias`
Dada una lista de ocurrencias `lOc` y una sublista `sLoc`, devuelve la sublista complementaria que contiene los caracteres de `lOc` que no están en `sLoc`. Implementada usando recursión de cola.

### 7. `anagramasDeFrase(frase: Frase): List[Frase]`
Función principal que devuelve todos los anagramas de una frase. La estrategia es:
1. Calcular todas las combinaciones posibles de caracteres
2. Para cada combinación, encontrar palabras válidas del diccionario
3. Calcular recursivamente los anagramas del complemento
4. Combinar los resultados usando expresiones `for`

## Diccionario

El diccionario por defecto incluye las siguientes palabras:
- "cosas", "como", "yo", "y", "ocasos", "cayo", "mocosos", "roca", "moco", "sos"

## Ejemplo de Uso

```scala
import Anagramas._

// Calcular ocurrencias de una palabra
lOcPal("casa")

// Generar combinaciones
combinaciones(lOcPal("casa"))

// Anagramas de una frase
val frase = List("cosas", "como", "yo")
anagramasDeFrase(frase)
```

## Ejecución

Para ejecutar el proyecto y las pruebas:

```bash
# Compilar el proyecto
sbt compile

# Ejecutar las pruebas en el worksheet
sbt test
```

## Requisitos

- Scala 3.3.5
- SBT (Scala Build Tool)

## Autoría

Taller desarrollado por:
- Juan Francisco Díaz Frías
- Emily Núñez

Marzo 2025

## Notas Técnicas

- El proyecto utiliza expresiones `for` de Scala para generar combinaciones y anagramas de manera declarativa
- Se aprovecha el método `groupBy` para agrupar eficientemente palabras por sus listas de ocurrencias
- La implementación maneja correctamente caracteres repetidos mediante listas de ocurrencias
- No se distinguen mayúsculas/minúsculas ni signos de puntuación en el procesamiento
