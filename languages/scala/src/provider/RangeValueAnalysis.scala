package provider

import model.{TableAnalysis, UserInfo}

/**
  * Classe para analise de dados, obtem os valores maximo e minimo dos creditos dos usuarios
  * @see model.TableAnalysis
  */
class RangeValueAnalysis extends TableAnalysis[Array[Double]]{

  /**
    * Realiza a analise maxima e minima dos dados
    * @param userInfoList Lista de dados a ser analisada
    * @return Valores maximo e minimo dos creditos
    * @see TableAnalysis
    */
  override def analysis(userInfoList: List[UserInfo]): Array[Double] = {

    var max = Double.MinValue
    var min = Double.MaxValue

    userInfoList.foreach { userInfo =>
      if(userInfo.credit > max) max = userInfo.credit
      if(userInfo.credit < min) min = userInfo.credit
    }

    return Array(min, max)
  }
}
