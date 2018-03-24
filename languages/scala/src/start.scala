import java.io.{FileInputStream, InputStream}
import java.util.Properties

import model.{BenchmarkOutput, TableAnalysis, TimeFormat}
import provider.{BenchmarkMeasure, MeanAnalysis, RangeValueAnalysis, TableReader}

object main {

  def main(args: Array[String]): Unit = {

    val configFile = "config.properties"
    val properties = loadProperties(configFile)

    val input = properties.getProperty("INPUT_FILENAME")
    val output = properties.getProperty("OUTPUT_FILENAME")

    val benchmark: BenchmarkOutput = new BenchmarkMeasure

    //==================================================
    // Leitura dos dados
    benchmark.start("READ")
    val table = new TableReader(input)
    benchmark.end("READ")
    //==================================================

    val list = table.read()
    val rangeValueAnalysis: TableAnalysis[Array[Double]] = new RangeValueAnalysis
    val meanAnalysis: TableAnalysis[Double] = new MeanAnalysis

    //==================================================
    // Analise dos dados
    benchmark.start("ANALYSE")
    val rangeValue: Array[Double] = rangeValueAnalysis.analysis(list)
    val meanValue: Double = meanAnalysis.analysis(list)
    benchmark.end("ANALYSE")
    //==================================================

    benchmark.export(output, TimeFormat.MILISSEGUNDOS)
  }

  def loadProperties(configFile: String): Properties = {

    val input = new FileInputStream (configFile)
    val properties = new Properties()
    properties.load (input)

    return properties
  }

}