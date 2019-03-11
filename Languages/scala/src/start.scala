import model.Table

import provider.MaxValueAnalysis
import provider.MeanAnalysis
import provider.MinValueAnalysis

/**
 * Classe inicial do programa
 */
object main {

  /**
    * Método de inicialização do projeto
    * @param args Lista de parametros obtidos via console
    */
  def main(args: Array[String]): Unit = {

    val fileName: String = this.prepareArgs(args)

    var builder: StringBuilder = new StringBuilder

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
    builder.append("[OK]Arquivo: " + fileName).append("\n");
    builder.append("[OK]Tempo_leitura: " + (leituraFim - leituraInicio)).append(" ms").append("\n");
    builder.append("[OK]Tempo_analise: " + (analiseFim - analiseInicio)).append(" ms").append("\n");
    builder.append("[OK]Max: " + max).append("\n");
    builder.append("[OK]Min: " + min).append("\n");
    builder.append("[OK]Mean: " + mean);

    println(builder.toString())
  }

  /**
    * Método para captura e tratamento dos parametros obtidos via console
    *
    * @param ar Lista de parametros obtidos via console
    * @return Tamanho de usuários á serem gerados
    */
  private def prepareArgs(ar: Array[String]): String = {
    if (ar.length != 1) {
      println("Parametros inválidos.")
      System.exit(-1)
    }

    val line = ar{0}
    return line
  }
}
