import com.google.gson.Gson
import java.io.File

class Palabra {
    companion object {
        const val RUTA_TEXTO = "src/palabras.txt"
        const val RUTA_JSON = "src/palabras.json"
        const val ES_JSON = true

        fun leerFicheroTexto(ruta: String): List<String> = File(ruta).readLines()

        fun leerFicheroJSON(ruta: String): List<String> {
            val json = File(ruta).readText()
            return Gson().fromJson(json, Palabras::class.java).palabras
        }
    }
    data class Palabras(val palabras: List<String>)

    fun obtenerPalabraAleatoria(){
        if (ES_JSON){
            leerFicheroJSON(RUTA_JSON)
        }
        else leerFicheroTexto(RUTA_TEXTO)
    }
}


