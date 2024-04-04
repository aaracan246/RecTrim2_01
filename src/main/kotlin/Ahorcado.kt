class Ahorcado(val intentosMax: Int = 5, palabra: Palabra): ConsoleSystem() {


    private val palabraOculta = palabra.obtenerPalabraAleatoria()
    private val palabraOcultada = palabraOculta.toString()
    private val listaLetras = listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")



    private fun ocultarPalabraOculta(): String {
        val palabraOcultada: String = palabraOcultada
        for (letra in palabraOcultada){
            palabraOcultada.replace("$letra",  "_")
        }
        return palabraOcultada
    }

    fun pedirLetra() = lectorChar("Por favor, introduzca una letra: ")


    fun jugar(){
        do {
            ocultarPalabraOculta()

            val letra = pedirLetra()

            if (palabraOcultada.contains(letra)){
                // No me va a dar tiempo a hacerlo pero sé que aquí  debería  buscar la letra que aparezca y cambiar solo  esa. Probablemente  tal como está ahora el  código me  cambie  todos  los "_" por la letra en cuestión.
                    palabraOcultada.replace("_" , letra)
            }

        } while (intentosMax > 0  && palabraOcultada.contains("_") )

        println(palabraOculta)
    }
}

