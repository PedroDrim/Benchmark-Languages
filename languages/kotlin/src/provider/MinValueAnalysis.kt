package provider

import box.UserInfo
import model.SimpleTableAnalysis

// Criando uma classe "MinValueAnalysis" que implementa a interface "SimpleTableAnalysis"
class MinValueAnalysis: SimpleTableAnalysis {

    /**
     * Método de interface, responsável por realizar a análise na lista de "UserInfo"
     * userInfoList: List<UserInfo> -> Lista de "UserInfo"
     * RETURN: Double -> valor minimo da análise
     */
    override fun analysis(userInfoList: List<UserInfo>): Double {
        var min: Double = Double.MAX_VALUE

        userInfoList.forEach {
            if(it.credit < min) min = it.credit
        }

        return min
    }
}