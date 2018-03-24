package provider

import box.UserInfo
import model.TableAnalysis

/**
 * Classe para analise de dados, obtem a media dos valores dos creditos dos usuarios
 * @see model.TableAnalysis
 */
class MeanAnalysis: TableAnalysis<Double> {

    /**
     * Realiza a analise de media dos dados
     * @param userInfoList Lista de dados a ser analisada
     * @return Media dos valores dos creditos
     * @see TableAnalysis
     */
    override fun analysis(userInfoList: List<UserInfo>): Double {
        var mean = 0.0
        userInfoList.forEach {
            mean += it.credit
        }

        return mean/userInfoList.size
    }
}