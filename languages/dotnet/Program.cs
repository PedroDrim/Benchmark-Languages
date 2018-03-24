using System;
using System.IO;
using System.Collections.Generic;
using experimento.src.model;
using experimento.src.provider;

namespace experimento {

    public class Program {

        static void Main(string[] args) {

            Dictionary<string, string> configuration = getConfiguration("./app.config");
            
            string input = configuration["input"];
            string output = configuration["output"];

            BenchmarkOutput benchmark = new BenchmarkMeasure();

            //==================================================
            // Leitura dos dados
            benchmark.start("READ");
            DataReader tableReader = new TableReader(input);
            benchmark.end("READ");
            //==================================================

            List<UserInfo> list = tableReader.read();
            TableAnalysis<UserInfo> searchAnalysis = new SearchAnalysis();
            TableAnalysis<double[]> rangeValueAnalysis = new RangeValueAnalysis();
            TableAnalysis<double> meanAnalysis = new MeanAnalysis();

            //==================================================
            // Analise dos dados
            benchmark.start("ANALYSE");
            double[] range = rangeValueAnalysis.analysis(list);
            double mean = meanAnalysis.analysis(list);
            benchmark.end("ANALYSE");
            //==================================================

            benchmark.export(output, TimeFormat.MILISSEGUNDOS);
        }

        static Dictionary<string, string> getConfiguration(string fileName) {
            StreamReader file = new StreamReader(fileName);

            Dictionary<string, string> appConfig = new Dictionary<string, string>();
            
            string line;
            while((line = file.ReadLine()) != null) {  
                string[] values = line.Split(":");
                string key = values[0].Trim();
                string val = values[1].Trim();
                appConfig.Add(key, val);
            }  

            file.Close();  
            return appConfig;
        }
    }
}
