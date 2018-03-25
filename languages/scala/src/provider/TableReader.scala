package provider

import java.io.FileNotFoundException

import model.exception.{DataReaderException, InvalidParameterException}
import model.{DataReader, UserInfo}

import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Classe responsavel por ler e disponibilizar os dados em um formato desejado
  * @param _fileName Nome do arquivo de dados a ser lido
  * @see model.DataReader
  */
class TableReader(private var _fileName: String) extends DataReader {

  if (_fileName == null) throw new InvalidParameterException("'fileName' é null")

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
  override def read(startIndex: Int, endIndex: Int): List[UserInfo] = {
    if (startIndex < 0) throw new InvalidParameterException("'startIndex' é menor que 0")
    if (endIndex < 0) throw new InvalidParameterException("'endIndex' é menor que 0")
    if (startIndex >= endIndex) throw new InvalidParameterException("'startIndex' é maior ou igual á 'endIndex'")

    return this.userInfoList.slice(startIndex, endIndex)
  }

  /**
    * Desserializa o arquivo de dados, convertendo-o em uma lista de 'UserInfo'
    * @param fileName Nome do arquivo de dados
    * @return Lista contendo os dados desserilizados
    */
  private def deserializeFile(fileName: String): List[UserInfo] = {
    if (fileName == null) throw new InvalidParameterException("'fileName' é null")

    var list = new ListBuffer[UserInfo]()
    var header: Boolean = true

    try {

      val file = Source.fromFile(_fileName)
      for (line <- file.getLines) {

        if (header) {
          header = false

        } else {
          val userInfo = this.convertLine(line)
          list += userInfo
        }
      }

      file.close()

    } catch {
      case e: RuntimeException => throw new DataReaderException("Erro ao ler arquivo:" + fileName, e)
    }

    return list.toList
  }

  /**
    * Converte a linha em um 'UserInfo'
    * @param line Linha a ser desserializada
    * @return Objeto 'UserInfo'
    */
  private def convertLine(line: String): UserInfo = {
    if (line == null) throw new InvalidParameterException("'line' é null")

    val values = line.split(",")

    val user: String = values {0}.trim
    val password: String = values {1}.trim
    val credit: Double = values {2}.trim.toDouble

    val userInfo = new UserInfo(user, password, credit)
    return userInfo
  }
}
