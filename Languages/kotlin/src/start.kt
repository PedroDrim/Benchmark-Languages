import model.UserInfo
import java.util.ArrayList

/**
 * Função de inicialização do projeto
 * @param args Lista de parametros obtidos via console
 */
fun main(args: Array<String>) {
    val tamanho = prepareArgs(args)

    var builder = StringBuilder()
    val list = ArrayList<UserInfo>()

    val antes = System.currentTimeMillis()

    for (index in 0..tamanho - 1) {
        builder.append("user").append(index)
        val user = builder.toString()

        builder = StringBuilder()

        builder.append("password").append(index)
        val password = builder.toString()

        list.add(UserInfo(user, password))
    }

    val time = System.currentTimeMillis() - antes

    builder = StringBuilder()
    builder.append("[OK]Tamanho: ").append(tamanho).append("\n")
    builder.append("[OK]Tempo: ").append(time).append(" ms")


    println(builder.toString())
}

/**
 * Método para captura e tratamento dos parametros obtidos via console
 * @param codes Lista de parametros obtidos via console
 * *
 * @return Tamanho de usuários á serem gerados
 */
private fun prepareArgs(codes: Array<String>): Int {
    if (codes.size != 1) {
        println("Parametros inválidos.")
        System.exit(-1)
    }

    val line = Integer.parseInt(codes[0])

    if (line <= 0) {
        println("Quantidade de linhas menor que 1.")
        System.exit(-1)
    }

    return line
}