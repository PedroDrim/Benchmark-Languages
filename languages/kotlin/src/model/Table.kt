package model

import box.UserInfo
import java.io.BufferedReader
import java.io.File

class Table(fileName: String) {

    // Get e Set de fileName é gerado pelo construtor
    // Get de userInfoList é gerado manualmente
    val userInfoList: List<UserInfo> = this.deserializeFile(fileName)

    /**
     * Método privado para encriptar senhas
     * password: String -> senha a ser encriptada
     * RETURN: String -> nova senha
     */
    private fun deserializeFile(fileName: String): List<UserInfo> {

        var list = mutableListOf<UserInfo>()

        val bufferedReader: BufferedReader = File(fileName).bufferedReader()
        var header: Boolean = true

        bufferedReader.useLines {

            lines -> lines.forEach {

                if(header) {
                    header = false
                }else {

                    val values = it.split(",")

                    val user: String = values[0].trim()
                    val password: String = values[1].trim()
                    val credit: Double = values[2].trim().toDouble()

                    val userInfo = UserInfo(user, password, credit)

                    list.add(userInfo)
                }
            }
        }

        bufferedReader.close()
        return list.toList()
    }
}