import {UserInfo} from './UserInfo'

/**
 * Interface para analise dos dados
 * @param <T> Tipo de classe do resultado
 */
export interface TableAnalysis<T> {

    /**
     * Realiza a analise dos dados
     * @param userInfoList Lista de dados a ser analisada
     * @return Resultado da analise
     */
    analysis(userInfoList: Array<UserInfo>): T;
}
