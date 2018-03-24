package provider

import box.UserInfo
import model.DataReader
import java.io.BufferedReader
import java.io.File

/**
 * Classe responsavel por ler e disponibilizar os dados em um formato desejado
 * @see model.DataReader
 */
class TableReader(fileName: String): DataReader {

    /**
     * Lista contendo os dados
     */
    private val userInfoList: List<UserInfo> = this.deserializeFile(fileName)

    /**
     * Obtem todos os dados disponiveis
     * @return Lista contendo todos os dados disponiveis
     */
    override fun read(): List<UserInfo> = userInfoList

    /**
     * Obtem os dados disponiveis dentro de um intervalo
     * @param startIndex Inicio do intervalo
     * @param endIndex Fim do intervalo
     * @return Lista contendo todos os dados disponiveis dentro do intervalo especificado
     */
    override fun read(startIndex: Int, endIndex: Int): List<UserInfo> = userInfoList.subList(startIndex, endIndex)

    /**
     * Desserializa o arquivo de dados, convertendo-o em uma lista de 'UserInfo'
     * @param fileName Nome do arquivo de dados
     * @return Lista contendo os dados desserilizados
     * @throws DataReaderException Lancada caso nao seja possivel ler os dados corretamente
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
                    val userInfo = convertLine(it)
                    list.add(userInfo)
                }
            }
        }

        bufferedReader.close()
        return list.toList()
    }

    /**
     * Converte a linha em um 'UserInfo'
     * @param line Linha a ser desserializada
     * @return Objeto 'UserInfo'
     */
    private fun convertLine(line: String): UserInfo {

        val values = line.split(",")

        val user: String = values[0].trim()
        val password: String = values[1].trim()
        val credit: Double = values[2].trim().toDouble()

        val userInfo = UserInfo(user, password, credit)
        return userInfo
    }
}