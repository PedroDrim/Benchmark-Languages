import model.SimpleTableAnalysis
import model.Table
import provider.MaxValueAnalysis
import provider.MeanAnalysis
import provider.MinValueAnalysis

fun main(args: Array<String>) {

    val fileName ="/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-Languages/outputs/inputclass/inputclass_1e+06.csv"
    val identificador = "kotlin_10_inputclass_1e+06"

    val leitura_inicio: Long = System.currentTimeMillis()

    val table = Table(fileName)

    val leitura_fim: Long = System.currentTimeMillis()

    val list = table.userInfoList

    val maxAnalysis: SimpleTableAnalysis = MaxValueAnalysis()
    val minAnalysis: SimpleTableAnalysis = MinValueAnalysis()
    val meanAnalysis: SimpleTableAnalysis = MeanAnalysis()

    val analise_inicio: Long = System.currentTimeMillis()

    val max = maxAnalysis.analysis(list)
    val min = minAnalysis.analysis(list)
    val mean = meanAnalysis.analysis(list)

    val analise_fim: Long = System.currentTimeMillis()

    println("\nIdentificador: " + identificador)
    println("Tempo de leitura (ms): " + (leitura_fim - leitura_inicio))
    println("Tempo de análise (ms): " + (analise_fim - analise_inicio))
    println("Max: " + max)
    println("Min: " + min)
    println("Mean: " + mean)
}