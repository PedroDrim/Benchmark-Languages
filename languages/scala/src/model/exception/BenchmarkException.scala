package model.exception

/**
  * Classe para o tratamento de erros no benchmark
  * @param message Mensagem de erro a ser exibida
  */
class BenchmarkException(message : String) extends Exception(message) {

  /**
    * Construtor publico de super classe
    * @param message Mensagem de erro a ser exibida
    * @param cause Causa do erro
    */
  def this(message: String, cause: Throwable) {
    this(message)
    initCause(cause)
  }

  /**
    * Construtor publico da super classe
    * @param cause Causa do erro
    */
  def this(cause: Throwable) {
    this(Option(cause).map(_.toString).orNull, cause)
  }

  /**
    * Construtor publico da super classe
    */
  def this() {
    this(null: String)
  }

}
