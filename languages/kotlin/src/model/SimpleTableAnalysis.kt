package model

import box.UserInfo

// Criando uma interface "SimpleTableAnalysis"
interface SimpleTableAnalysis {

    /**
     * Método de interface, responsável por realizar a análise na lista de "UserInfo"
     * userInfoList: List<UserInfo> -> Lista de "UserInfo"
     * RETURN: Double -> valor da análise
     */
    fun analysis(userInfoList: List<UserInfo>): Double
}