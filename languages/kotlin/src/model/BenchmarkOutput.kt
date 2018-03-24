package model

/**
 * Interface para captura de estados de tempo (benchmark)
 */
interface BenchmarkOutput {

    /**
     * Inicio da captura de estado
     * @param tag Nome da captura referente
     */
    fun start(tag: String)

    /**
     * Fim da captura de estado
     * @param tag Nome da captura referente
     */
    fun end(tag: String)

    /**
     * Resultado da captura de estado especifica
     * @param tag Nome da captura referente
     * @param format Formato do resultado
     * @return Tempo decorrido entre o inicio e o fim da captura de estado
     */
    fun result(tag: String, format: TimeFormat): Double

    /**
     * Resultado de todas as capturas de estado
     * @param format Formato do resultado
     * @return Mapa contendo o tempo decorrido entre o inicio e o fim da captura de estado para cada estado gerado.
     */
    fun result(format: TimeFormat): Map<String, Double>

    /**
     * Exporta o resultado no formato de um arquivo
     * @param fileName Nome do arquivo de saida
     * @param format Formato do resultado
     */
    fun export(fileName: String, format: TimeFormat)
}
