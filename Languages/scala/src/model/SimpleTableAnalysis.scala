package model

/**
 * Interface para analise de uma lista de usuarios
 */
trait SimpleTableAnalysis {

  /**
   * Método de interface, responsável por realizar uma analise em uma lista de usuarios
   * @param userInfoList Lista de usuarios
   * @return resultado da analise
   */
  def analysis(userInfoList: List[UserInfo]): Double
}
