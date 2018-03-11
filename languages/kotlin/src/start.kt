import model.SimpleTableAnalysis
import model.Table
import provider.MaxValueAnalysis
import provider.MeanAnalysis
import provider.MinValueAnalysis

fun main(args: Array<String>) {

    val fileName ="/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-Languages/outputs/inputclass/inputclass_1e+06.csv"
    val identificador = "kotlin_10_inputclass_1e+06"

    // Obtendo o tempo inicial de leitura em milissegundos
    val leitura_inicio: Long = System.currentTimeMillis()

    // Convertendo arquivo em lista de "UserInfo"
    val table = Table(fileName)

    // Obtendo o tempo final de leitura em milissegundos
    val leitura_fim: Long = System.currentTimeMillis()

    val list = table.userInfoList

    val maxAnalysis: SimpleTableAnalysis = MaxValueAnalysis()
    val minAnalysis: SimpleTableAnalysis = MinValueAnalysis()
    val meanAnalysis: SimpleTableAnalysis = MeanAnalysis()

    // Obtendo o tempo inicial de analise em milissegundos
    val analise_inicio: Long = System.currentTimeMillis()

    // Realizando analises
    val max = maxAnalysis.analysis(list)
    val min = minAnalysis.analysis(list)
    val mean = meanAnalysis.analysis(list)

    // Obtendo o tempo final de analise em milissegundos
    val analise_fim: Long = System.currentTimeMillis()

    // Dados de saida
    println("\nIdentificador: " + identificador)
    println("Tempo de leitura (ms): " + (leitura_fim - leitura_inicio))
    println("Tempo de análise (ms): " + (analise_fim - analise_inicio))
    println("Max: " + max)
    println("Min: " + min)
    println("Mean: " + mean)
}