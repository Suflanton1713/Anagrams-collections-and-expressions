package object Anagramas {

  type Palabra = String
  type Frase = List[Palabra]
  type Ocurrencias = List[(Char, Int)]

  val diccionario: List[Palabra] = List(
    "cosas", "como", "yo", "y", "ocasos", "cayo", "mocosos", "roca", "moco", "sos"
  )

  def lOcPal(p: Palabra): Ocurrencias = {
    p.toList
          .groupBy(c => c)
          .map{case (letra, ocurrencia) => (letra,ocurrencia.length)}
          .toList;

    /*(for {(letra, ocurrencia) <- p.toList.groupBy(c => c)} yield (letra, ocurrencia.length)).toList
     */
  }

  def lOcFrase(f: Frase): Ocurrencias = {
    // usar lOcPal, mkString, ...
    lOcPal(f.mkString)
  }

  lazy val diccionarioPorOcurrencias: Map[Ocurrencias, List[Palabra]] = {
    // usar groupBy, lOcPal, ...
    diccionario.groupBy(lOcPal)
  }

  def anagramasDePalabra(palabra: Palabra): List[Palabra] = {
    // usar diccionarioPorOcurrencias.get, lOcPal
    diccionarioPorOcurrencias.getOrElse(lOcPal(palabra), Nil);
  }

  def combinaciones(locurrencias: Ocurrencias): List[Ocurrencias] = {
    // usar una expresión for para producir el resultado
      ocurrencias.foldLeft(List(List.empty[(Char, Int)])) {
        case (combisPrevias, (caracter, cantidad)) =>
          for {
            combinacion <- combisPrevias
            n <- 0 to cantidad
          } yield {
            if (n == 0) combinacion
            else combinacion :+ (caracter, n)
          }
      }
    }

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
