import box.UserInfo
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {

    // Obtem o tempo de execução em milissegundos
    val time: Long = measureTimeMillis {

        // Inicializa uma lista modificavel
        var list: MutableList<UserInfo> = mutableListOf()

        // Adiciona 1.000.000 (um milhão) de "UserInfo" na lista
        for (index: Int in 0..1000000) {
            var user: String = "user" + index
            var password: String = "password" + index;
            list.add(UserInfo(user, password))
        }
    }

    println(time)
}