import {TimeFormat} from './TimeFormat'
/**
 * Interface para captura de estados de tempo (benchmark)
 */
export interface BenchmarkOutput {

    /**
     * Inicio da captura de estado
     * @param tag Nome da captura referente
     */
    start(tag: string): void;

    /**
     * Fim da captura de estado
     * @param tag Nome da captura referente
     */
    end(tag: string): void;

    /**
     * Resultado da captura de estado especifica
     * @param tag Nome da captura referente
     * @param format Formato do resultado
     * @return Tempo decorrido entre o inicio e o fim da captura de estado
     */
    resultByTag(tag: string, format: TimeFormat): number;

    /**
     * Resultado de todas as capturas de estado
     * @param format Formato do resultado
     * @return Mapa contendo o tempo decorrido entre o inicio e o fim da captura de estado para cada estado gerado.
     */
    result(format: TimeFormat): Map<string, number>;

    /**
     * Exporta o resultado no formato de um arquivo
     * @param fileName Nome do arquivo de saida
     * @param format Formato do resultado
     */
    export(fileName: string, format: TimeFormat): void;
}
