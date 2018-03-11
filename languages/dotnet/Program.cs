// Importando bibliotecas
using System;
using System.Collections.Generic;
using inputclass.src.model;
using inputclass.src.provider;

// Definindo "package" da aplicação
namespace inputclass {
    // Criando uma classe inicial "Program"
    public class Program {
        // Método primário de execução
        // args: String[] -> lista de parametros iniciais
        static void Main(string[] args) {
            
            string fileName = "/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-Languages/outputs/inputclass/inputclass_1e+06.csv";
            string identificador = "csharp_10_inputclass_1e+06";

            // Obtendo o tempo inicial de leitura em milissegundos
            long leitura_inicio = DateTimeOffset.Now.ToUnixTimeMilliseconds();

            // Convertendo arquivo em lista de "UserInfo"
            Table table = new Table(fileName);

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
            Console.WriteLine("Identificador: " + identificador);
            Console.WriteLine("Tempo de leitura (ms): " + (leitura_fim - leitura_inicio) );
            Console.WriteLine("Tempo de análise (ms): " + (analise_fim - analise_inicio) );
            Console.WriteLine("Max: " + max);
            Console.WriteLine("Min: " + min);
            Console.WriteLine("Mean: " + mean);
        }
    }
}
