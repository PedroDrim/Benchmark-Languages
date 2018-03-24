package provider

import model.{DataReader, UserInfo}

import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Classe responsavel por ler e disponibilizar os dados em um formato desejado
  * @param _fileName Nome do arquivo de dados a ser lido
  * @see model.DataReader
  */
class TableReader(private var _fileName: String) extends DataReader {

  /**
    * Lista contendo os dados
    */
  private val userInfoList = this.deserializeFile(_fileName)

  /**
    * Obtem o nome do arquivo de dados a ser lido
    * @return Nome do arquivo de dados a ser lido
    */
  def fileName: String = _fileName

  /**
    * Obtem todos os dados disponiveis
    *
    * @return Lista contendo todos os dados disponiveis
    */
  override def read(): List[UserInfo] = this.userInfoList

  /**
    * Obtem os dados disponiveis dentro de um intervalo
    *
    * @param startIndex Inicio do intervalo
    * @param endIndex   Fim do intervalo
    * @return Lista contendo todos os dados disponiveis dentro do intervalo especificado
    */
  override def read(startIndex: Int, endIndex: Int): List[UserInfo] = this.userInfoList.slice(startIndex, endIndex)

  /**
    * Desserializa o arquivo de dados, convertendo-o em uma lista de 'UserInfo'
    * @param fileName Nome do arquivo de dados
    * @return Lista contendo os dados desserilizados
    */
  private def deserializeFile(fileName: String): List[UserInfo] = {

    var list = new ListBuffer[UserInfo]()
    var header: Boolean = true

    val file = Source.fromFile(_fileName)
    for (line <- file.getLines) {

      if(header) {
        header = false

      } else {
        val userInfo = this.convertLine(line)
        list += userInfo
      }
    }

    file.close()
    return list.toList
  }

  /**
    * Converte a linha em um 'UserInfo'
    * @param line Linha a ser desserializada
    * @return Objeto 'UserInfo'
    */
  private def convertLine(line: String): UserInfo = {

    val values = line.split(",")

    val user: String = values {0}.trim
    val password: String = values {1}.trim
    val credit: Double = values {2}.trim.toDouble

    val userInfo = new UserInfo(user, password, credit)
    return userInfo
  }
}
