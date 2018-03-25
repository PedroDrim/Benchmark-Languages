package provider

import model.exception.InvalidParameterException
import model.{TableAnalysis, UserInfo}

/**
  * Classe para ordenacao quickSort
  * @see model.TableAnalysis
  */
class QuickSortAnalysis extends TableAnalysis[List[UserInfo]]{

  private var arrayUserInfo: Array[UserInfo] = null;

  /**
    * Realiza uma ordenacao quickSort
    * @param userInfoList Lista de dados a ser analisada
    * @return Lista de dados ordenados
    * @see TableAnalysis
    */
  override def analysis(userInfoList: List[UserInfo]): List[UserInfo] = {
    if(userInfoList == null || userInfoList.isEmpty)
      throw new InvalidParameterException("'userInfoList' é null ou vazio")

    arrayUserInfo = userInfoList.toArray

    quickSort(0, arrayUserInfo.length - 1)

    return arrayUserInfo.toList
  }

  /**
    * Iniciando quickSort
    *
    * @param baixo index inicial
    * @param alto  index final
    */
  private def quickSort(baixo: Int, alto: Int): Unit = {
    if (baixo > alto) throw new InvalidParameterException("'baixo' é maior que 'alto'")

    var indexInicio: Int = baixo
    var indexFim: Int = alto

    // Get the pivot element from the middle of the list
    val userInfoPivot: UserInfo = arrayUserInfo{baixo + (alto - baixo) / 2}
    var aux: UserInfo = null

    // Divide into two lists
    while (indexInicio <= indexFim) {

      // If the current value from the left list is smaller than the pivot
      // element then get the next element from the left list
      while (arrayUserInfo{indexInicio}.credit < userInfoPivot.credit) indexInicio += 1

      // If the current value from the right list is larger than the pivot
      // element then get the next element from the right list
      while (arrayUserInfo{indexFim}.credit > userInfoPivot.credit) indexFim -= 1

      // If we have found a value in the left list which is larger than
      // the pivot element and if we have found a value in the right list
      // which is smaller than the pivot element then we exchange the
      // values.
      // As we are done we can increase i and j
      if (indexInicio <= indexFim) {
        aux = arrayUserInfo{indexInicio}
        arrayUserInfo{indexInicio} = arrayUserInfo{indexFim}
        arrayUserInfo{indexFim} = aux

        indexInicio += 1
        indexFim -= 1
      }
    }

    // Recursion
    if (baixo < indexFim) quickSort(baixo, indexFim)
    if (indexInicio < alto) quickSort(indexInicio, alto)
  }
}
