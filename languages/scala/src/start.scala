
import model.Table

import provider.MaxValueAnalysis
import provider.MeanAnalysis
import provider.MinValueAnalysis


object  main extends App {

  val fileName = "/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-Languages/outputs/inputclass/inputclass_1e+06.csv"
  val identificador = "scala_10_inputclass_1e+06"

  val leituraInicio = System.currentTimeMillis

  val table = new Table(fileName)

  val leituraFim = System.currentTimeMillis

  val list = table.userInfoList
  val maxAnalysis = new MaxValueAnalysis
  val minAnalysis = new MinValueAnalysis
  val meanAnalysis = new MeanAnalysis

  val analiseInicio = System.currentTimeMillis

  val max = maxAnalysis.analysis(list)
  val min = minAnalysis.analysis(list)
  val mean = meanAnalysis.analysis(list)

  val analiseFim = System.currentTimeMillis

  println("\nIdentificador: " + identificador)
  println("Tempo de leitura (ms): " + (leituraFim - leituraInicio))
  println("Tempo de análise (ms): " + (analiseFim - analiseInicio))
  println("Max: " + max)
  println("Min: " + min)
  println("Mean: " + mean)
}