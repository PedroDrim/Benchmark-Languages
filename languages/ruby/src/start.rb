require "./provider/TableReader.rb";
require "./model/BenchmarkOutput.rb";
require "./provider/BenchmarkMeasure.rb";
require "./model/TableAnalysis.rb";
require "./provider/SummaryAnalysis.rb";
require "./provider/BubbleSortAnalysis.rb";
require "./provider/QuickSortAnalysis.rb";
require "./provider/LanguageSortAnalysis.rb";
require "./model/UserInfo.rb";
require "./model/TimeFormat.rb";
require "./model/exception/InvalidParameterException.rb";

class Start

    def initialize

        configFile = "./config.json";
        properties = require(configFile);

        input: string = properties.INPUT_FILENAME;
        output: string = properties.OUTPUT_FILENAME;

        benchmark: BenchmarkOutput = new BenchmarkMeasure();

        summaryAnalysis: TableAnalysis<Array<number>> = new SummaryAnalysis();
        bubbleSortAnalysis: TableAnalysis<Array<UserInfo>> = new BubbleSortAnalysis();
        quickSortAnalysis: TableAnalysis<Array<UserInfo>> = new QuickSortAnalysis();
        languageSortAnalysis: TableAnalysis<Array<UserInfo>> = new LanguageSortAnalysis();

        //==================================================
        // Leitura dos dados
        benchmark.start("Read");
        let tableReader: TableReader = new TableReader(input);
        let list: Array<UserInfo> = tableReader.readAll();
        benchmark.end("Read");
        //==================================================
        // Analise dos dados (Summary)
        benchmark.start("SummaryAnalyse");
        let summary: Array<number> = summaryAnalysis.analysis(list);
        benchmark.end("SummaryAnalyse");
        //==================================================
        // Analise dos dados (Bubble)
        benchmark.start("BubbleAnalyse");
        let bubble: Array<UserInfo> =  bubbleSortAnalysis.analysis(list);
        benchmark.end("BubbleAnalyse");
        //==================================================
        // Analise dos dados (Quick)
        benchmark.start("QuickAnalyse");
        let quick: Array<UserInfo> =  quickSortAnalysis.analysis(list);
        benchmark.end("QuickAnalyse");
        //==================================================
        // Analise dos dados (Language)
        benchmark.start("LanguageAnalyse");
        let lang: Array<UserInfo> =   languageSortAnalysis.analysis(list);
        benchmark.end("LanguageAnalyse");
        //==================================================

        benchmark.export(output, TimeFormat.MILLISEGUNDOS);
    end
end

start = Start.new()
