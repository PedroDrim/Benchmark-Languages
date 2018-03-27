package model

/**
 * Interface para leitura de dados
 */
interface DataReader {

    /**
     * Obtem todos os dados disponiveis
     * @return Lista contendo todos os dados disponiveis
     */
    fun read(): List<UserInfo>

    /**
     * Obtem os dados disponiveis dentro de um intervalo
     * @param startIndex Inicio do intervalo
     * @param endIndex Fim do intervalo
     * @return Lista contendo todos os dados disponiveis dentro do intervalo especificado
     */
    fun read(startIndex: Int, endIndex: Int): List<UserInfo>
}