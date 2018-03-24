package model

/**
  * Interface para leitura de dados
  */
trait DataReader {

  /**
    * Obtem todos os dados disponiveis
    * @return Lista contendo todos os dados disponiveis
    */
  def read(): List[UserInfo]

  /**
    * Obtem os dados disponiveis dentro de um intervalo
    * @param startIndex Inicio do intervalo
    * @param endIndex Fim do intervalo
    * @return Lista contendo todos os dados disponiveis dentro do intervalo especificado
    */
  def read(startIndex: Int, endIndex: Int): List[UserInfo]
}
