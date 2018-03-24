package model;

import java.util.Map;

/**
 * Interface para captura de estados de tempo (benchmark)
 */
public interface BenchmarkOutput {

    /**
     * Inicio da captura de estado
     * @param tag Nome da captura referente
     */
    void start(String tag);

    /**
     * Fim da captura de estado
     * @param tag Nome da captura referente
     */
    void end(String tag);

    /**
     * Resultado da captura de estado especifica
     * @param tag Nome da captura referente
     * @param format Formato do resultado
     * @return Tempo decorrido entre o inicio e o fim da captura de estado
     */
    double result(String tag, TimeFormat format);

    /**
     * Resultado de todas as capturas de estado
     * @param format Formato do resultado
     * @return Mapa contendo o tempo decorrido entre o inicio e o fim da captura de estado para cada estado gerado.
     */
    Map<String, Double> result(TimeFormat format);

    /**
     * Exporta o resultado no formato de um arquivo
     * @param fileName Nome do arquivo de saida
     * @param format Formato do resultado
     */
    void export(String fileName, TimeFormat format);
}
