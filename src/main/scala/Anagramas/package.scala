package object Anagramas {

  type Palabra = String
  type Frase = List[Palabra]
  type Ocurrencias = List[(Char, Int)]

  val diccionario: List[Palabra] = List(
    "cosas", "como", "yo", "y", "ocasos", "cayo", "mocosos", "roca", "moco", "sos"
  )

  def lOcPal(p: Palabra): Ocurrencias = {
    // usar groupBy, map, ...
    ???
  }

  def lOcFrase(f: Frase): Ocurrencias = {
    // usar lOcPal, mkString, ...
    ???
  }

  lazy val diccionarioPorOcurrencias: Map[Ocurrencias, List[Palabra]] = {
    // usar groupBy, lOcPal, ...
    ???
  }

  def anagramasDePalabra(palabra: Palabra): List[Palabra] = {
    // usar diccionarioPorOcurrencias.get, lOcPal
    ???
  }

  def combinaciones(locurrencias: Ocurrencias): List[Ocurrencias] = {
    // usar una expresión for para producir el resultado
    ???
  }

  def complemento(lOc: Ocurrencias, sLoc: Ocurrencias): Ocurrencias = {
    // usar recursión de cola
    ???
  }

  def anagramasDeFrase(sentence: Frase): List[Frase] = {
    // usar expresiones for y funciones auxiliares
    ???
  }
}
