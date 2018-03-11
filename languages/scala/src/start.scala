
import model.Table

import provider.MaxValueAnalysis
import provider.MeanAnalysis
import provider.MinValueAnalysis

object main extends App {

  val fileName = "/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-Languages/outputs/inputclass/inputclass_1e+06.csv"
  val identificador = "scala_10_inputclass_1e+06"

  // Obtendo o tempo inicial de leitura em milissegundos
  val leituraInicio = System.currentTimeMillis

  // Convertendo arquivo em lista de "UserInfo"
  val table = new Table(fileName)

  // Obtendo o tempo final de leitura em milissegundos
  val leituraFim = System.currentTimeMillis

  val list = table.userInfoList
  val maxAnalysis = new MaxValueAnalysis
  val minAnalysis = new MinValueAnalysis
  val meanAnalysis = new MeanAnalysis

  // Obtendo o tempo inicial de analise em milissegundos
  val analiseInicio = System.currentTimeMillis

  // Realizando analises
  val max = maxAnalysis.analysis(list)
  val min = minAnalysis.analysis(list)
  val mean = meanAnalysis.analysis(list)

  // Obtendo o tempo final de analise em milissegundos
  val analiseFim = System.currentTimeMillis

  // Dados de saida
  println("\nIdentificador: " + identificador)
  println("Tempo de leitura (ms): " + (leituraFim - leituraInicio))
  println("Tempo de análise (ms): " + (analiseFim - analiseInicio))
  println("Max: " + max)
  println("Min: " + min)
  println("Mean: " + mean)
}