import box.UserInfo
import model.BenchmarkOutput
import model.TableAnalysis
import model.TimeFormat
import provider.*
import java.util.*
import java.io.FileInputStream

fun main(args: Array<String>) {

    val configFile = "config.properties"
    val properties = loadProperties(configFile)

    val input = properties.getProperty("INPUT_FILENAME")
    val output = properties.getProperty("OUTPUT_FILENAME")

    var benchmark: BenchmarkOutput = BenchmarkMeasure()

    //==================================================
    // Leitura dos dados
    benchmark.start("READ")
    val table = TableReader(input)
    benchmark.end("READ")
    //==================================================

    val list = table.read()
    val searchAnalysis: TableAnalysis<UserInfo> = SearchAnalysis()
    val rangeValueAnalysis: TableAnalysis<Array<Double>> = RangeValueAnalysis()
    val meanAnalysis: TableAnalysis<Double> = MeanAnalysis()


    //==================================================
    // Analise dos dados
    benchmark.start("ANALYSE")
    val searchValue = searchAnalysis.analysis(list)
    val rangeValue = rangeValueAnalysis.analysis(list)
    val mean = meanAnalysis.analysis(list)
    benchmark.end("ANALYSE")
    //==================================================

    benchmark.export(output, TimeFormat.MILISSEGUNDOS)
}

fun loadProperties(configFile: String): Properties {
    val input = FileInputStream(configFile)
    val properties = Properties()
    properties.load(input)

    return properties
}