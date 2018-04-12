import model.UserInfo
import model.BenchmarkOutput
import model.TableAnalysis
import model.TimeFormat
import model.exception.InvalidParameterException
import provider.*
import java.util.*
import java.io.FileInputStream

fun main(args: Array<String>) {

    if (args.isEmpty()) throw InvalidParameterException("Parametros iniciais nao encontrados")
    val configFile = args[0]
    val properties = loadProperties(configFile)

    val input = properties.getProperty("INPUT_FILENAME")
    val output = properties.getProperty("OUTPUT_FILENAME")

    var benchmark: BenchmarkOutput = BenchmarkMeasure()

    val bubbleSortAnalysis: TableAnalysis<List<UserInfo>> = BubbleSortAnalysis()
    val quickSortAnalysis: TableAnalysis<List<UserInfo>> = QuickSortAnalysis()
    val languageSortAnalysis: TableAnalysis<List<UserInfo>> = LanguageSortAnalysis()
    val summaryAnalysis: TableAnalysis<Array<Double>> = SummaryAnalysis()

    //==================================================
    // Leitura dos dados
    benchmark.start("Read")
    val table = TableReader(input)
    val list = table.read()
    benchmark.end("Read")
    //==================================================
    // Analise dos dados (Summary)
    benchmark.start("SummaryAnalyse")
    val summaryValue: Array<Double> = summaryAnalysis.analysis(list)
    benchmark.end("SummaryAnalyse")
    //==================================================
    // Analise dos dados (Bubble)
    benchmark.start("BubbleAnalyse")
    val bubbleValue = bubbleSortAnalysis.analysis(list)
    benchmark.end("BubbleAnalyse")
    //==================================================
    // Analise dos dados (Quick)
    benchmark.start("QuickAnalyse")
    val quickValue = quickSortAnalysis.analysis(list)
    benchmark.end("QuickAnalyse")
    //==================================================
    // Analise dos dados (Language)
    benchmark.start("LanguageAnalyse")
    val languageValue = languageSortAnalysis.analysis(list)
    benchmark.end("LanguageAnalyse")
    //==================================================

    benchmark.export(output, TimeFormat.MILISSEGUNDOS)
}

fun loadProperties(configFile: String): Properties {
    if (configFile == null) throw InvalidParameterException("'configFile' é null")

    val input = FileInputStream(configFile)
    val properties = Properties()
    properties.load(input)

    return properties
}