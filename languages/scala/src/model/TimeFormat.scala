package model

/**
  * Formato de tempos disponiveis
  */
object TimeFormat extends Enumeration {

  type TimeFormat = Value
  val SEGUNDOS = Value("0.001")
  val MILISSEGUNDOS = Value("1")
  val NANOSEGUNDOS = Value("1000")

}