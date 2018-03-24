package provider

import model.{TableAnalysis, UserInfo}

/**
  * Classe para analise de dados, obtem a media dos valores dos creditos dos usuarios
  * @see model.TableAnalysis
  */
class MeanAnalysis extends TableAnalysis[Double] {

  /**
    * Realiza a analise de media dos dados
    * @param userInfoList Lista de dados a ser analisada
    * @return Media dos valores dos creditos
    * @see TableAnalysis
    */
  override def analysis(userInfoList: List[UserInfo]): Double = {

    var sum: Double = 0.0

    userInfoList.foreach(sum += _.credit)

    return sum/userInfoList.length
  }
}
