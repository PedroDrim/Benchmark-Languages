// Importando bibliotecas
import {UserInfo} from './UserInfo'

// Criando uma interface "SimpleTableAnalysis"
export interface SimpleTableAnalysis {
    // Método de interface, responsável por realizar a análise na lista de "UserInfo"
    // list: List<UserInfo> -> Lista de "UserInfo"
    // RETURN: double -> valor da análise
    analysis(userInfoList: Array<UserInfo>): number
}