using System;
using System.Collections.Generic;

namespace experimento.src.model {
 
    /// <summary>
    /// Interface para captura de estados de tempo (benchmark)
    /// </summary>
    public interface BenchmarkOutput {      
 
        /// <summary>
        /// Inicio da captura de estado
        /// </summary>
        /// <param name="tag">Nome da captura referente</param>
        void start(string tag);

        /// <summary>
        /// Fim da captura de estado
        /// </summary>
        /// <param name="tag">Nome da captura referente</param>
        void end(string tag);

        /// <summary>
        /// Resultado da captura de estado especifica
        /// </summary>
        /// <param name="tag">Nome da captura referente</param>
        /// <param name="format">Formato do resultado</param>
        /// <returns>Tempo decorrido entre o inicio e o fim da captura de estado</returns>
        double result(string tag, TimeFormat format);

        /// <summary>
        /// Resultado de todas as capturas de estado
        /// </summary>
        /// <param name="format">Formato do resultado</param>
        /// <returns>Mapa contendo o tempo decorrido entre o inicio e o fim da captura de estado para cada estado gerado.</returns>
        Dictionary<string, double> result(TimeFormat format);

        /// <summary>
        /// Exporta o resultado no formato de um arquivo
        /// </summary>
        /// <param name="fileName">Nome do arquivo de saida</param>
        /// <param name="format">Formato do resultado</param>
        void export(string fileName, TimeFormat format);
    }
}