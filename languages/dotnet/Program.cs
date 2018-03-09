using System;
using System.Collections.Generic;
using inputclass.src.model;
using inputclass.src.provider;

namespace inputclass {
    public class Program {
        static void Main(string[] args) {
            
            string fileName = "/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-Languages/outputs/inputclass/inputclass_1e+06.csv";
            string identificador = "csharp_10_inputclass_1e+06";

            long leitura_inicio = DateTimeOffset.Now.ToUnixTimeMilliseconds();

            Table table = new Table(fileName);

            long leitura_fim = DateTimeOffset.Now.ToUnixTimeMilliseconds();

            List<UserInfo> list = table.userInfoList;

            SimpleTableAnalysis maxValue = new MaxValueAnalysis();
            SimpleTableAnalysis minValue = new MinValueAnalysis();
            SimpleTableAnalysis meanValue = new MeanAnalysis();

            long analise_inicio = DateTimeOffset.Now.ToUnixTimeMilliseconds();

            double max = maxValue.analysis(list);
            double min = minValue.analysis(list);
            double mean = meanValue.analysis(list);

            long analise_fim = DateTimeOffset.Now.ToUnixTimeMilliseconds();

            Console.WriteLine("Identificador: " + identificador);
            Console.WriteLine("Tempo de leitura (ms): " + (leitura_fim - leitura_inicio) );
            Console.WriteLine("Tempo de análise (ms): " + (analise_fim - analise_inicio) );
            Console.WriteLine("Max: " + max);
            Console.WriteLine("Min: " + min);
            Console.WriteLine("Mean: " + mean);
        }
    }
}
