package provider

import model.{TableAnalysis, UserInfo}

/**
  * Classe para analise de dados, obtem os valores máximo, minimo e media de valores
  * @see model.TableAnalysis
  */
class SummaryAnalysis extends TableAnalysis[Array[Double]]{

  /**
    * Realiza um resumo dos dados
    * @param userInfoList Lista de dados a ser analisada
    * @return Valores maximo, minimo e media
    * @see TableAnalysis
    */
  override def analysis(userInfoList: List[UserInfo]): Array[Double] = {

    var max = Double.MinValue
    var min = Double.MaxValue
    var sum: Double = 0.0

    userInfoList.foreach { userInfo =>
      sum += userInfo.credit
      if(userInfo.credit > max) max = userInfo.credit
      if(userInfo.credit < min) min = userInfo.credit
    }

    val mean: Double = sum/userInfoList.length

    return Array(max, min, mean)
  }
}
