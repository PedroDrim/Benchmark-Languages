import model.UserInfo

import scala.collection.mutable.ListBuffer

/**
Classe inicial do programa
  */
object main {

  /**
    * Método de inicialização do projeto
    * @param args Lista de parametros obtidos via console
    */
  def main(args: Array[String]): Unit = {

    val tamanho: Int = this.prepareArgs(args)

    var list = new ListBuffer[UserInfo]
    var builder: StringBuilder = new StringBuilder

    val antes = System.currentTimeMillis

    for (index <- 1 to tamanho) {
      builder.append("user").append(index)
      val user: String = builder.toString()

      builder = new StringBuilder

      builder.append("password").append(index)
      val password: String = "password" + index

      list += new UserInfo(user, password)
    }

    val time = System.currentTimeMillis - antes

    builder = new StringBuilder
    builder.append("[OK]Tamanho: ").append(tamanho).append("\n")
    builder.append("[OK]Tempo: ").append(time).append(" ms")

    println(builder.toString)
  }

  /**
    * Método para captura e tratamento dos parametros obtidos via console
    *
    * @param ar Lista de parametros obtidos via console
    * @return Tamanho de usuários á serem gerados
    */
  private def prepareArgs(ar: Array[String]): Int = {
    if (ar.length != 1) {
      println("Parametros inválidos.")
      System.exit(-1)
    }

    val line = ar{0}.toInt

    if (line <= 0) {
      println("Quantidade de linhas menor que 1.")
      System.exit(-1)
    }

    return line
  }
}