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

        TableAnalysis<double[]> summaryAnalysis = new SummaryAnalysis();
        TableAnalysis<List<UserInfo>> bubbleSortAnalysis = new BubbleSortAnalysis();
        TableAnalysis<List<UserInfo>> quickSortAnalysis = new QuickSortAnalysis();
        TableAnalysis<List<UserInfo>> languageSortAnalysis = new LanguageSortAnalysis();

        //==================================================
        // Leitura dos dados
        benchmark.start("Read");
        TableReader tableReader = new TableReader(input);
        List<UserInfo> list = tableReader.read();
        benchmark.end("Read");
        //==================================================
        // Analise dos dados (Summary)
        benchmark.start("SummaryAnalyse");
        double[] summary = (double[]) summaryAnalysis.analysis(list);
        benchmark.end("SummaryAnalyse");
        //==================================================
        // Analise dos dados (Bubble)
        benchmark.start("BubbleAnalyse");
        List<UserInfo> bubble = (List<UserInfo>) bubbleSortAnalysis.analysis(list);
        benchmark.end("BubbleAnalyse");
        //==================================================
        // Analise dos dados (Quick)
        benchmark.start("QuickAnalyse");
        List<UserInfo> quick = (List<UserInfo>) quickSortAnalysis.analysis(list);
        benchmark.end("QuickAnalyse");
        //==================================================
        // Analise dos dados (Language)
        benchmark.start("LanguageAnalyse");
        List<UserInfo> lang = (List<UserInfo>) languageSortAnalysis.analysis(list);
        benchmark.end("LanguageAnalyse");
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
