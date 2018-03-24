package provider

import model.{TableAnalysis, UserInfo}

import scala.util.Random

/**
  * Classe para analise de dados, obtem um usuario aleatoriamente
  * @see model.TableAnalysis
  */
class SearchAnalysis extends TableAnalysis[UserInfo]{

  /**
    * Realiza uma analise aleatoria dos dados
    * @param userInfoList Lista de dados a ser analisada
    * @return Elemento aleatorio da lista
    * @see TableAnalysis
    */
  override def analysis(userInfoList: List[UserInfo]): UserInfo = {
    val random = new Random()
    val randomIndex = random.nextInt(userInfoList.length)

    return userInfoList(randomIndex)
  }
}
