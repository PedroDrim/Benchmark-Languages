package model

import box.UserInfo

/**
 * Interface para analise de uma lista de usuarios
 */
interface SimpleTableAnalysis {

    /**
     * Método de interface, responsável por realizar uma analise em uma lista de usuarios
     * @param userInfoList Lista de usuarios
     * @return resultado da analise
     */
    fun analysis(userInfoList: List<UserInfo>): Double
}