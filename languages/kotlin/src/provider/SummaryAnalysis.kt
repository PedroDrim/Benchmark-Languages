package provider

import model.UserInfo
import model.TableAnalysis
import model.exception.InvalidParameterException

/**
 * Classe para analise de dados, obtem os valores maximos, minimos e media dos creditos dos usuarios
 * @see model.TableAnalysis
 */
class SummaryAnalysis: TableAnalysis<Array<Double>> {

    /**
     * Realiza um resumo dos dados
     * @param userInfoList Lista de dados a ser analisada
     * @return Resumo dos valores dos creditos
     * @see TableAnalysis
     */
    override fun analysis(userInfoList: List<UserInfo>): Array<Double> {
        if (userInfoList.isEmpty())
            throw InvalidParameterException("'userInfoList' é vazio")

        var value = 0.0
        var min: Double = Double.MAX_VALUE
        var max: Double = Double.MIN_VALUE

        userInfoList.forEach {
            value += it.credit
            if(it.credit > max) max = it.credit
            if(it.credit < min) min = it.credit
        }

        val mean = value/userInfoList.size

        return doubleArrayOf(min, max, mean).toTypedArray()
    }
}