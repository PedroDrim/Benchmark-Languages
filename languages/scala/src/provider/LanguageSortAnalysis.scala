package provider

import model.exception.InvalidParameterException
import model.{TableAnalysis, UserInfo}

/**
  * Classe para ordenacao pela propria linguagem
  * @see model.TableAnalysis
  */
class LanguageSortAnalysis extends TableAnalysis[List[UserInfo]]{

  /**
    * Realiza uma ordenacao pela propria linguagem
    * @param userInfoList Lista de dados a ser analisada
    * @return Lista de dados ordenados
    * @see TableAnalysis
    */
  override def analysis(userInfoList: List[UserInfo]): List[UserInfo] = {
    if(userInfoList == null || userInfoList.isEmpty)
      throw new InvalidParameterException("'userInfoList' é null ou vazio")

    return userInfoList.sortWith(_.credit > _.credit)
  }
}
