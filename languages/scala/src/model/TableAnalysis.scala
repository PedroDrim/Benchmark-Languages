package model

/**
  * Interface para analise dos dados
  */
trait TableAnalysis[A] {

  /**
    * Realiza a analise dos dados
    * @param userInfoList Lista de dados a ser analisada
    * @return Resultado da analise
    */
  def analysis(userInfoList: List[UserInfo]): A
}
