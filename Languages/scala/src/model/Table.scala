package model

import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
 * Classe para gerenciar uma tabela de usuarios
 * @param _fileName Nome do arquivo
 */
class Table(private var _fileName: String) {

  /**
   * Obtem o nome do arquivo .csv
   * @param fileName nome do arquivo .csv
   */
  def fileName: String = _fileName

  /**
   * Obtem a lista de usuarios
   * @param userInfoList lista de usuarios
   */  
  def userInfoList: List[UserInfo] = this.deserializeFile(_fileName)

  /**
   * Método privado para conversão do arquivo .csv em uma lista de usuarios
   * @param fileName Nome do arquivo
   * @return Lista convertida de usuarios
   */
  private def deserializeFile(filename: String): List[UserInfo] = {

    var list = new ListBuffer[UserInfo]()
    var header: Boolean = true

    val file = Source.fromFile(_fileName)
    for (line <- file.getLines) {

      if(header) {
        header = false

      } else {
        val values: Array[String] = line.split(",")

        val user: String = values {0}.trim
        val password: String = values {1}.trim
        val credit: Double = values {2}.trim.toDouble

        list += new UserInfo(user, password, credit)
      }
    }

    file.close()
    return list.toList
  }
}
