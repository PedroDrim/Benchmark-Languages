require "./src/provider/TableReader.rb"
require "./src/model/BenchmarkOutput.rb"
require "./src/provider/BenchmarkMeasure.rb"
require "./src/model/TableAnalysis.rb"
require "./src/provider/SummaryAnalysis.rb"
require "./src/provider/BubbleSortAnalysis.rb"
require "./src/provider/QuickSortAnalysis.rb"
require "./src/provider/LanguageSortAnalysis.rb"
require "./src/model/UserInfo.rb"
require "./src/model/TimeFormat.rb"
require "./src/model/exception/InvalidParameterException.rb"

require "json"

class Start

    def initialize

        configFile = ARGV[0]
        properties = self.getConfig(configFile)

        input = properties["INPUT_FILENAME"]
        output = properties["OUTPUT_FILENAME"]

        benchmark = BenchmarkMeasure.new

        summaryAnalysis = SummaryAnalysis.new
        bubbleSortAnalysis = BubbleSortAnalysis.new
        quickSortAnalysis = QuickSortAnalysis.new
        languageSortAnalysis = LanguageSortAnalysis.new

        #==================================================
        # Leitura dos dados
        benchmark.startState("Read")
        tableReader = TableReader.new(input)
        list = tableReader.readAll
        benchmark.endState("Read")
        #==================================================
        # Analise dos dados (Summary)
        benchmark.startState("SummaryAnalyse")
        summary = summaryAnalysis.analysis(list)
        benchmark.endState("SummaryAnalyse")
        #==================================================
        # Analise dos dados (Bubble)
        benchmark.startState("BubbleAnalyse")
        bubble =  bubbleSortAnalysis.analysis(list)
        benchmark.endState("BubbleAnalyse")
        #==================================================
        # Analise dos dados (Quick)
        benchmark.startState("QuickAnalyse")
        quick =  quickSortAnalysis.analysis(list)
        benchmark.endState("QuickAnalyse")
        #==================================================
        # Analise dos dados (Language)
        benchmark.startState("LanguageAnalyse")
        lang = languageSortAnalysis.analysis(list)
        benchmark.endState("LanguageAnalyse")
        #==================================================

        benchmark.export(output, TimeFormat::MILLISEGUNDOS)
    end

    def getConfig(fileName)
        lines = File.read(fileName)
        return JSON.parse(lines)
    end
    
end

Start.new
