
import kotlin.math.abs


object GenerarSerie: ConsoleSystem(){

    private const val MAX =  100
    private const val MIN = 1

    fun generarRangoAleatorio() {
        val numMax = generarNum()
        var numMin = generarNum()

        while (numMax - numMin < abs(30)){
            numMin =  generarNum()
        }

        escritor("Se está generando un rango aleatorio...")
        escritor(". . .")

        generarSerie(numMax,  numMin)
    }

    private fun generarSerie(numMax: Int, numMin: Int){
        val valorMedio = (numMax - numMin) / 2
        val numPedido = lector("Inserte un número [$numMax - $numMin] ->")

        when(numPedido){
            in numMin..<valorMedio -> { escritor("Inserte un número[$numMax - $numMin] -> $numPedido")
                serieDecreciente(numPedido, numMin)}

            in valorMedio..numMax -> { escritor("Inserte un número[$numMax - $numMin] -> $numPedido")
                serieCreciente(numPedido, numMax)}

            else -> {escritor("Ese número no es válido. Pruebe de nuevo: ${generarRangoAleatorio()}")}
        }
    }
    private fun generarNum() = (MIN..MAX).random()

    private fun serieCreciente(num1: Int, num2: Int){
        val rangoNums: IntRange = (num1..num2)
        var valorfinal: Int = 0

        escritor("${rangoNums.forEach {
            valorfinal = it + (it+1)
            escritor("${it + (it + 1)}") }}"
        )
        escritor("SUMA = $valorfinal")
    }

    private fun serieDecreciente(num1: Int, num2: Int){
        val rangoNums: IntRange = (num2..num1)
        var valorfinal: Int = 0

        escritor("${rangoNums.forEach {
            valorfinal = it + (it+1)
            escritor("${it + (it + 1)}") }}"
        )
        escritor("SUMA = $valorfinal")
    }
}