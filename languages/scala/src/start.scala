import java.io.{FileInputStream, InputStream}
import java.util.Properties

import model.exception.InvalidParameterException
import model.{BenchmarkOutput, TableAnalysis, TimeFormat, UserInfo}
import provider._

object main {

  def main(args: Array[String]): Unit = {

    val configFile = "config.properties"
    val properties = loadProperties(configFile)

    val input = properties.getProperty("INPUT_FILENAME")
    val output = properties.getProperty("OUTPUT_FILENAME")

    val benchmark: BenchmarkOutput = new BenchmarkMeasure

    val summaryAnalysis: TableAnalysis[Array[Double]] = new SummaryAnalysis
    val bubbleSortAnalysis: TableAnalysis[List[UserInfo]] = new BubbleSortAnalysis
    val quickSortAnalysis: TableAnalysis[List[UserInfo]] = new QuickSortAnalysis

    //==================================================
    // Leitura dos dados
    benchmark.start("Read")
    val table = new TableReader(input)
    val list = table.read()
    benchmark.end("Read")
    //==================================================
    // Analise dos dados (Summary)
    benchmark.start("SummaryAnalyse")
    val summaryValue: Array[Double] = summaryAnalysis.analysis(list)
    benchmark.end("SummaryAnalyse")
    //==================================================
    // Analise dos dados (Bubble)
    benchmark.start("BubbleAnalyse")
    val bubbleValue: List[UserInfo] = bubbleSortAnalysis.analysis(list)
    benchmark.end("BubbleAnalyse")
    //==================================================
    // Analise dos dados (Quick)
    benchmark.start("QuickAnalyse")
    val quickValue: List[UserInfo] = quickSortAnalysis.analysis(list)
    benchmark.end("QuickAnalyse")
    //==================================================

    benchmark.export(output, TimeFormat.MILISSEGUNDOS)
  }

  def loadProperties(configFile: String): Properties = {
    if (configFile == null) throw new InvalidParameterException("'configFile' é null")

    val input = new FileInputStream (configFile)
    val properties = new Properties
    properties.load (input)

    return properties
  }

}