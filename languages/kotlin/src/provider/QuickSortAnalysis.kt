package provider

import model.UserInfo
import model.TableAnalysis
import model.exception.InvalidParameterException

/**
 * Classe para ordenacao quickSort
 * @see model.TableAnalysis
 */
class QuickSortAnalysis : TableAnalysis<List<UserInfo>>{

    private var arrayUserInfo: Array<UserInfo>? = null

    /**
     * Realiza uma analise ordenacao quickSort
     * @param userInfoList Lista de dados a ser analisada
     * @return Elemento aleatorio da lista
     * @see TableAnalysis
     */
    override fun analysis(userInfoList: List<UserInfo>): List<UserInfo> {
        if (userInfoList.isEmpty())
            throw InvalidParameterException("'userInfoList' é vazio")

        this.arrayUserInfo = userInfoList!!.toTypedArray()

        this.quickSort(0, this.arrayUserInfo!!.size - 1)

        return this.arrayUserInfo!!.asList()
    }

    /**
     * Iniciando quickSort
     * @param baixo index inicial
     * @param alto index final
     */
    private fun quickSort(baixo: Int, alto: Int) {
        if (baixo > alto) throw InvalidParameterException("'baixo' é maior que 'alto'")

        var indexInicio = baixo
        var indexFim = alto

        // Get the pivot element from the middle of the list
        val userInfoPivot = arrayUserInfo!![baixo + (alto - baixo) / 2]
        var aux: UserInfo

        // Divide into two lists
        while (indexInicio <= indexFim) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list

            while (arrayUserInfo!![indexInicio].credit < userInfoPivot.credit) {
                indexInicio++
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (arrayUserInfo!![indexFim].credit > userInfoPivot.credit) {
                indexFim--
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (indexInicio <= indexFim) {
                aux = arrayUserInfo!![indexInicio]
                arrayUserInfo!![indexInicio] = arrayUserInfo!![indexFim]
                arrayUserInfo!![indexFim] = aux

                indexInicio++
                indexFim--
            }
        }

        // Recursion
        if (baixo < indexFim) quickSort(baixo, indexFim)
        if (indexInicio < alto) quickSort(indexInicio, alto)
    }

}