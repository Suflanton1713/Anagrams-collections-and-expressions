import scala.annotation.tailrec

package object Anagramas {

  type Palabra = String
  type Frase = List[Palabra]
  type Ocurrencias = List[(Char, Int)]

  val diccionario: List[Palabra] = List(
    "cosas", "como", "yo", "y", "ocasos", "cayo", "mocosos", "roca", "moco", "sos"
  )

  def lOcPal(p: Palabra): Ocurrencias = {
    // usar groupBy, map, ...
    val agrupadas:Map[Char, String] = p.groupBy((letra: Char) => letra) //internamente es como si hiciera p.toList.groupBy
    val conteo: Map[Char, Int] = agrupadas.map { case (letra, stringDeLetras) =>
      (letra, stringDeLetras.length)
    }
    conteo.toList
  }

  def lOcFrase(f: Frase): Ocurrencias = {
    // usar lOcPal, mkString, ...
    lOcPal(f.mkString)
  }

  lazy val diccionarioPorOcurrencias: Map[Ocurrencias, List[Palabra]] = {
    // usar groupBy, lOcPal, ...
    diccionario.groupBy((pal: Palabra) => lOcPal(pal))
  }

  def anagramasDePalabra(palabra: Palabra): List[Palabra] = {
    // usar diccionarioPorOcurrencias.get, lOcPal
    diccionarioPorOcurrencias.getOrElse(lOcPal(palabra), Nil)
  }

  def combinaciones(locurrencias: Ocurrencias): List[Ocurrencias] = locurrencias match {
    case Nil => List(Nil)  // Caso base: la única combinación es la lista vacía
    case (c,n) :: tail =>

      val restoCombinaciones = combinaciones(tail)// Genera las combinaciones para el resto (recursión)

      (for {
        sublista <- restoCombinaciones
        k <- 1 to n
      } yield (c, k) :: sublista) ++ restoCombinaciones // Para cada sublista del resto, añade el carácter actual con k=1 hasta maxFrec
  }

  def complemento( lOc: Ocurrencias,  slOc : Ocurrencias): Ocurrencias = {
    // usar recursión de cola s
    @tailrec
    def comp(LOc: Ocurrencias, sLoc: Ocurrencias, acc: Ocurrencias): Ocurrencias = LOc match {
      case Nil => acc
      case (char, n) :: tail =>
        val cantidadUsada = slOc.find(_._1 == char).map(_._2).getOrElse(0)
        val nuevaCantidad = n - cantidadUsada
        val nuevoAcc = if (nuevaCantidad > 0) (char, nuevaCantidad) :: acc else acc
        comp(tail, slOc, nuevoAcc)
    }

    comp(lOc, slOc, Nil)
  }

  def anagramasDeFrase(sentence: Frase): List[Frase] = {
    // usar expresiones for y funciones auxiliares
    ???
  }
}
