package provider

import box.UserInfo
import model.TableAnalysis

/**
 * Classe para analise de dados, obtem os valores maximo e minimo dos creditos dos usuarios
 * @see model.TableAnalysis
 */
class RangeValueAnalysis: TableAnalysis<Array<Double>> {

    /**
     * Realiza a analise maxima e minima dos dados
     * @param userInfoList Lista de dados a ser analisada
     * @return Valores maximo e minimo dos creditos
     * @see TableAnalysis
     */
    override fun analysis(userInfoList: List<UserInfo>): Array<Double> {

        var min: Double = Double.MAX_VALUE
        var max: Double = Double.MIN_VALUE

        userInfoList.forEach {
            if(it.credit > max) max = it.credit
            if(it.credit < min) min = it.credit
        }

        return doubleArrayOf(min, max).toTypedArray()
    }

}