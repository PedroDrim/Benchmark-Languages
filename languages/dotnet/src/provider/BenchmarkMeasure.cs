using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;

namespace experimento.src.model {
 
    /// <summary>
    /// Classe para captura de estados de tempo (benchmark)
    /// </summary>
    public class BenchmarkMeasure : BenchmarkOutput {      

        /// <summary>
        /// Mapa de estados
        /// </summary>
        private Dictionary<string, double> benchMap;

        /// <summary>
        /// Marca de inicio de estado
        /// </summary>
        private string START_MARK = "_S";

        /// <summary>
        /// Marca de final de estado
        /// </summary>
        private string END_MARK = "_E";

        public BenchmarkMeasure() {
            this.benchMap = new Dictionary<string, double>();
        }

        /// <summary>
        /// Inicio da captura de estado
        /// </summary>
        /// <param name="tag">Nome da captura referente</param>
        public void start(string tag) {
            double time = DateTimeOffset.Now.ToUnixTimeMilliseconds();
            this.benchMap.Add(tag + START_MARK, time);
        }

        /// <summary>
        /// Fim da captura de estado
        /// </summary>
        /// <param name="tag">Nome da captura referente</param>
        public void end(string tag) {
            double time = DateTimeOffset.Now.ToUnixTimeMilliseconds();
            this.benchMap.Add(tag + END_MARK, time);
        }

        /// <summary>
        /// Resultado da captura de estado especifica
        /// </summary>
        /// <param name="tag">Nome da captura referente</param>
        /// <param name="format">Formato do resultado</param>
        /// <returns>Tempo decorrido entre o inicio e o fim da captura de estado</returns>
        public double result(string tag, TimeFormat format) {
            double start = this.benchMap[tag + START_MARK];
            double end = this.benchMap[tag + END_MARK];
            return (end - start) * Math.Pow(10,(int)format);
        }

        /// <summary>
        /// Resultado de todas as capturas de estado
        /// </summary>
        /// <param name="format">Formato do resultado</param>
        /// <returns>Mapa contendo o tempo decorrido entre o inicio e o fim da captura de estado para cada estado gerado.</returns>
        public Dictionary<string, double> result(TimeFormat format) {
            Dictionary<string, double> mapResult = new Dictionary<string, double>();
            ICollection<string> tagSet = this.benchMap.Keys;

            foreach(String tagMark in tagSet) {
                String tag = tagMark.Split("_")[0];
                double time = this.result(tag, format);
                mapResult[tag] = time;
            }

            return mapResult;
        }

        /// <summary>
        /// Exporta o resultado no formato de um arquivo
        /// </summary>
        /// <param name="fileName">Nome do arquivo de saida</param>
        /// <param name="format">Formato do resultado</param>
        public void export(string fileName, TimeFormat format) {
            
            Dictionary<string, double> mapResult = this.result(format);
            string jsonString = JsonConvert.SerializeObject(mapResult);
            
            Console.WriteLine(jsonString);
        }
    }
}