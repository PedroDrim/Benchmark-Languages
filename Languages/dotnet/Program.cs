using System;
using System.Text;
using System.Linq;
using System.Collections.Generic;
using inputclass.src.model;
using inputclass.src.provider;

namespace inputclass {

    /// <summary>
    /// Criando uma classe inicial "Program"
    /// </summary>
    public class Program {

        /// <summary>
        /// Método primário de execução 
        /// </summary>
        /// <param name="args">Lista de parametros iniciais</param>
        static void Main(string[] args) {
            
            string arquivo = prepareArgs(args);

            // Obtendo o tempo inicial de leitura em milissegundos
            long leitura_inicio = DateTimeOffset.Now.ToUnixTimeMilliseconds();

            // Convertendo arquivo em lista de "UserInfo"
            Table table = new Table(arquivo);

            // Obtendo o tempo final de leitura em milissegundos
            long leitura_fim = DateTimeOffset.Now.ToUnixTimeMilliseconds();

            List<UserInfo> list = table.userInfoList;

            SimpleTableAnalysis maxValue = new MaxValueAnalysis();
            SimpleTableAnalysis minValue = new MinValueAnalysis();
            SimpleTableAnalysis meanValue = new MeanAnalysis();

            // Obtendo o tempo inicial de analise em milissegundos
            long analise_inicio = DateTimeOffset.Now.ToUnixTimeMilliseconds();

            // Realizando analises
            double max = maxValue.analysis(list);
            double min = minValue.analysis(list);
            double mean = meanValue.analysis(list);

            // Obtendo o tempo final de analise em milissegundos
            long analise_fim = DateTimeOffset.Now.ToUnixTimeMilliseconds();

            // Dados de saida
            StringBuilder builder = new StringBuilder();
            builder.Append("[OK]Arquivo: ").Append(arquivo).Append("\n");
            builder.Append("[OK]Tempo_leitura: ").Append(leitura_fim - leitura_inicio).Append(" ms").Append("\n");
            builder.Append("[OK]Tempo_analise: ").Append(analise_fim - analise_inicio).Append(" ms").Append("\n");
            builder.Append("[OK]Max: ").Append(max).Append("\n");
            builder.Append("[OK]Min: ").Append(min).Append("\n");
            builder.Append("[OK]Mean: ").Append(mean).Append("\n");

            Console.WriteLine(builder.ToString());
        }

        /// <summary>
        /// Método para captura e tratamento dos parametros obtidos via console
        /// </summary>
        /// <param name="args">Lista de parametros iniciais</param>
        private static string prepareArgs(string[] codes) {
            if(codes.Length != 1) {
                Console.WriteLine("Parametros inválidos.");
                Environment.Exit(-1);
            }

            return codes[0];
        }
    }
}
