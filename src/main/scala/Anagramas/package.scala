import scala.annotation.tailrec

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
  }

  def lOcFrase(f: Frase): Ocurrencias = {
    // usar lOcPal, mkString, ...
    lOcPal(f.mkString)
  }

  lazy val diccionarioPorOcurrencias: Map[Ocurrencias, List[Palabra]] = {
    // usar groupBy, lOcPal, ...
    diccionario.groupBy(x=>lOcPal(x).toSet).map(y => (y._1.toList,y._2))
  }

  def anagramasDePalabra(palabra: Palabra): List[Palabra] = {
    // usar diccionarioPorOcurrencias.get, lOcPal
    diccionarioPorOcurrencias.getOrElse(lOcPal(palabra), Nil);
  }

  def combinaciones(locurrencias: Ocurrencias): List[Ocurrencias] = {
    // usar una expresión for para producir el resultado
      locurrencias.foldLeft(List(List.empty[(Char, Int)])) {
        case (combisPrevias, (caracter, cantidad)) =>
          for {
            combinacion <- combisPrevias
            n <- 0 to cantidad
          } yield {
            if (n == 0) combinacion
            else (caracter, n) :: combinacion
          } 
      }
  }

  def complemento(lOc: Ocurrencias, slOc: Ocurrencias): Ocurrencias = {
    // usar recursión de cola
    @tailrec
    def compIter(restantes: Ocurrencias, acumulador: Ocurrencias): Ocurrencias = restantes match {
      case Nil => acumulador.reverse
      case (char, cantidad) :: tail =>
        val cantidadUsada = slOc.filter(_._1 == char).headOption.map(_._2).getOrElse(0)
        val nuevaCantidad = cantidad - cantidadUsada

        val nuevoAcumulador =
          if (nuevaCantidad > 0) (char, nuevaCantidad) :: acumulador
          else acumulador
        compIter(tail, nuevoAcumulador)
    }

    compIter(lOc, Nil)

  }

  def anagramasDeFrase(sentence: Frase): List[Frase] = {
    // usar expresiones for y funciones auxiliares
    def aux(oc: Ocurrencias): List[Frase] = {
      if (oc.isEmpty) List(Nil)
      else {
        for {
          sub <- combinaciones(oc) 
          palabra <- diccionarioPorOcurrencias.getOrElse(sub.reverse, Nil)
          resto <- aux(complemento(oc, sub))
        } yield palabra :: resto
      }
    }
    aux(lOcFrase(sentence))
  }

}
