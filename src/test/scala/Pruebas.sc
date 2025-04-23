import Anagramas._

lOcPal("")
lOcPal("a")
lOcPal("abc")
lOcPal("moco")
lOcPal("cosas")
lOcPal("aaaa")
lOcPal("oca")
lOcPal("cosacos")
lOcPal("cayosos")
lOcPal("ocasos")

lOcFrase(List("","",""))
lOcFrase(List("aaa","bbb"))
lOcFrase(List("casa","piedra"))
lOcFrase(List("casa","coche"))
lOcFrase(List("moco","cosas"))
lOcFrase(List("oca","sos"))
lOcFrase(List("cayo","sos"))

assert(diccionarioPorOcurrencias(lOcPal("cosas")) == List("cosas"))

anagramasDePalabra("cosas")
anagramasDePalabra("como")
anagramasDePalabra("casa")
anagramasDePalabra("")
anagramasDePalabra("mocosos")
anagramasDePalabra("yo")
anagramasDePalabra("cayo")
anagramasDePalabra("cayos")

combinaciones(Nil)
combinaciones(List(('a', 1)))
combinaciones(List(('b', 2)))
combinaciones(List(('a', 1), ('b', 1)))
combinaciones(List(('a', 2), ('b', 1)))
combinaciones(List(('a', 1), ('b', 2), ('c', 1)))

complemento(Nil, Nil)
complemento(List(('a', 1)), Nil)
complemento(List(('a', 1)), List(('a', 1)))
complemento(List(('a', 2)), List(('a', 1)))
complemento(List(('a', 2), ('b', 1)), List(('a', 1)))
complemento(List(('a', 2), ('b', 1)), List(('a', 2), ('b', 1)))
complemento(List(('a', 3), ('b', 2)),List(('a', 1), ('b', 1)))
complemento(List(('a', 3), ('b', 2), ('c', 3)),List(('a', 1), ('b', 1), ('c', 2)))

anagramasDeFrase(List(""))
anagramasDeFrase(List("cosas"))
anagramasDeFrase(List("yo", "y"))
anagramasDeFrase(List("mocosos"))
anagramasDeFrase(List("yo", "yo"))
anagramasDeFrase(List("yo", "voy"))
anagramasDeFrase(List("cayo", "sos"))
anagramasDeFrase(List("oca", "sos"))
anagramasDeFrase(List("ocasos"))
anagramasDeFrase(List("y", "yo", "como"))


diccionarioPorOcurrencias

