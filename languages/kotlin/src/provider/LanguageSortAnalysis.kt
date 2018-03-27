package provider

import model.UserInfo
import model.TableAnalysis
import model.exception.InvalidParameterException


/**
 * Classe para ordenacao bubbleSort
 * @see model.TableAnalysis
 */
class LanguageSortAnalysis : TableAnalysis<List<UserInfo>>{

    /**
     * Realiza uma ordenacao pela propria linguagem
     * @param userInfoList Lista de dados a ser analisada
     * @return  Lista ordenada
     * @see TableAnalysis
     */
    override fun analysis(userInfoList: List<UserInfo>): List<UserInfo> {
        if (userInfoList.isEmpty())
            throw InvalidParameterException("'userInfoList' é vazio")

        val sortedList = userInfoList.sortedWith( compareBy(UserInfo::credit) )

        return sortedList
    }
}