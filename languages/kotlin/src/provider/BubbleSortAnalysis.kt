package provider

import model.UserInfo
import model.TableAnalysis
import model.exception.InvalidParameterException


/**
 * Classe para ordenacao bubbleSort
 * @see model.TableAnalysis
 */
class BubbleSortAnalysis : TableAnalysis<List<UserInfo>>{

    /**
     * Realiza uma ordenacao bubbleSort
     * @param userInfoList Lista de dados a ser analisada
     * @return Elemento aleatorio da lista
     * @see TableAnalysis
     */
    override fun analysis(userInfoList: List<UserInfo>): List<UserInfo> {
        if (userInfoList.isEmpty())
            throw InvalidParameterException("'userInfoList' é vazio")

        var arrayUserInfo = userInfoList.toTypedArray()

        var aux: UserInfo
        val size = arrayUserInfo.size

        for (index1 in 0 until size) {
            for (index2 in 1 until size - index1) {

                var user1 = arrayUserInfo[index2]
                var user2 = arrayUserInfo[index2 - 1]

                if (user1.credit > user2.credit) {
                    aux = user1
                    user1 = user2
                    user2 = aux

                    arrayUserInfo[index2] = user1
                    arrayUserInfo[index2 - 1] = user2
                }
            }
        }

        return arrayUserInfo.asList()
    }
}