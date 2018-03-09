package model

import scala.collection.mutable.ListBuffer
import scala.io.Source

class Table(private var _fileName: String) {

  // Get fileName
  def fileName: String = _fileName

  // Get userInfoList
  def userInfoList: List[UserInfo] = this.deserializeFile(_fileName)

  private def deserializeFile(filename: String): List[UserInfo] = {

    // Inicia uma lista modificavel
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
