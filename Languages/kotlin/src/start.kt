import model.SimpleTableAnalysis
import model.Table
import provider.MaxValueAnalysis
import provider.MeanAnalysis
import provider.MinValueAnalysis

/**
 * Função de inicialização do projeto
 * @param args Lista de parametros obtidos via console
 */
fun main(args: Array<String>) {

    val fileName: String = prepareArgs(args)
    var builder = StringBuilder()

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
    builder.append("[OK]Arquivo: " + fileName).append("\n");
    builder.append("[OK]Tempo_leitura: " + (leitura_fim - leitura_inicio)).append(" ms").append("\n");
    builder.append("[OK]Tempo_analise: " + (analise_fim - analise_inicio)).append(" ms").append("\n");
    builder.append("[OK]Max: " + max).append("\n");
    builder.append("[OK]Min: " + min).append("\n");
    builder.append("[OK]Mean: " + mean);

    println(builder.toString())
}

/**
 * Método para captura e tratamento dos parametros obtidos via console
 * @param codes Lista de parametros obtidos via console
 * *
 * @return Tamanho de usuários á serem gerados
 */
private fun prepareArgs(codes: Array<String>): String {
    if (codes.size != 1) {
        println("Parametros inválidos.")
        System.exit(-1)
    }

    val line = codes[0]
    return line
}

    
