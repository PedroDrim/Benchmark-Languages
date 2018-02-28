import box.UserInfo
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {

    val time: Long = measureTimeMillis {

        var list: MutableList<UserInfo> = mutableListOf()
        for (index: Int in 0..1000000) {
            var user: String = "user" + index
            var password: String = "password" + index;
            list.add(UserInfo(user, password))
        }
    }

    println(time)
}