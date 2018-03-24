package provider

import box.UserInfo
import model.TableAnalysis
import java.util.*

/**
 * Classe para analise de dados, obtem um usuario aleatoriamente
 * @see model.TableAnalysis
 */
class SearchAnalysis : TableAnalysis<UserInfo>{

    /**
     * Realiza uma analise aleatoria dos dados
     * @param userInfoList Lista de dados a ser analisada
     * @return Elemento aleatorio da lista
     * @see TableAnalysis
     */
    override fun analysis(userInfoList: List<UserInfo>): UserInfo {
        val random = Random()
        val randomIndex = random.nextInt(userInfoList.size)

        val userInfo = userInfoList[randomIndex]
        return userInfo
    }
}