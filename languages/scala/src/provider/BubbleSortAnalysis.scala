package provider

import model.exception.InvalidParameterException
import model.{TableAnalysis, UserInfo}

/**
  * Classe para ordenacao bubbleSort
  * @see model.TableAnalysis
  */
class BubbleSortAnalysis extends TableAnalysis[List[UserInfo]]{

  /**
    * Realiza uma ordenacao bubbleSort
    * @param userInfoList Lista de dados a ser analisada
    * @return Lista de dados ordenados
    * @see TableAnalysis
    */
  override def analysis(userInfoList: List[UserInfo]): List[UserInfo] = {
    if(userInfoList == null || userInfoList.isEmpty)
      throw new InvalidParameterException("'userInfoList' é null ou vazio")

    val arrayUserInfo: Array[UserInfo] = userInfoList.toArray
    val size: Int = arrayUserInfo.length - 1
    var aux: UserInfo = null

    for(index1: Int <- 0 to (size)) {
      for(index2: Int <- 1 to (size - index1)) {

        var user1: UserInfo = arrayUserInfo{index2}
        var user2: UserInfo = arrayUserInfo{index2 - 1}

        if(user1.credit > user2.credit){
          aux = user1
          user1 = user2
          user2 = aux

          arrayUserInfo{index2} = user1
          arrayUserInfo{index2 - 1} = user2
        }

      }
    }

    return arrayUserInfo.toList
  }
}
