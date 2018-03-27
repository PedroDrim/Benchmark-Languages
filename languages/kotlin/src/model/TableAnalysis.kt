package model

/**
 * Interface para analise dos dados
 * @param <T> Tipo de classe do resultado
 */
interface TableAnalysis<T> {

    /**
     * Realiza a analise dos dados
     * @param userInfoList Lista de dados a ser analisada
     * @return Resultado da analise
     */
    fun analysis(userInfoList: List<UserInfo>): T
}