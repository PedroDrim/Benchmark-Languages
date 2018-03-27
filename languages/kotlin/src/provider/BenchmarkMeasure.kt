package provider

import com.google.gson.GsonBuilder
import model.BenchmarkOutput
import model.TimeFormat
import model.exception.BenchmarkException
import java.io.File



/**
 * Classe para captura de estados de tempo
 * @see model.BenchmarkOutput
 */
class BenchmarkMeasure: BenchmarkOutput {

    /**
     * Marca de inicio de estado
     */
    private val START_MARK = "_S"

    /**
     * Marca de fim de estado
     */
    private val END_MARK = "_E"

    /**
     * Mapa de estados
     */
    private var benchMap = mutableMapOf<String, Double>()

    /**
     * Inicio da captura de estado
     * @param tag Nome da captura referente
     */
    override fun start(tag: String) {
        val time = System.currentTimeMillis()
        benchMap[tag + START_MARK] = time.toDouble()
    }

    /**
     * Fim da captura de estado
     * @param tag Nome da captura referente
     */
    override fun end(tag: String) {
        val time = System.currentTimeMillis()
        benchMap[tag + END_MARK] = time.toDouble()
    }

    /**
     * Resultado da captura de estado especifica
     * @param tag Nome da captura referente
     * @param format Formato do resultado
     * @return Tempo decorrido entre o inicio e o fim da captura de estado
     */
    override fun result(tag: String, format: TimeFormat): Double {
        val startTag = benchMap.containsKey(tag + START_MARK)
        val endTag = benchMap.containsKey(tag + END_MARK)

        if (!startTag || !endTag) throw BenchmarkException("Não encontrado par 'inicio-fim' de:" + tag)

        val start = benchMap.getValue(tag + START_MARK)
        val end = benchMap.getValue(tag + END_MARK)

        return (end - start) * format.proportion
    }

    /**
     * Resultado de todas as capturas de estado
     * @param format Formato do resultado
     * @return Mapa contendo o tempo decorrido entre o inicio e o fim da captura de estado para cada estado gerado.
     */
    override fun result(format: TimeFormat): Map<String, Double> {
        val mapResult = mutableMapOf<String, Double>()
        val tagSet = this.benchMap.keys

        for (tagMark in tagSet) {
            val tag = tagMark.split("_")[0]
            val time = this.result(tag, format)
            mapResult[tag] = time
        }

        return mapResult
    }

    /**
     * Exporta o resultado no formato de um arquivo
     * @param fileName Nome do arquivo de saida
     * @param format Formato do resultado
     */
    override fun export(fileName: String, format: TimeFormat) {
        val builder = GsonBuilder()
        val gson = builder.create()

        val resultMap = result(format).toMap()
        val t = gson.toJson(resultMap)

        File(fileName).writeText(t)
    }
}