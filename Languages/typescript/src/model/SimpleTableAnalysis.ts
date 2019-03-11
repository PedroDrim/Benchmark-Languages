import {UserInfo} from './UserInfo'

// Interface para analise de uma lista de usuarios
export interface SimpleTableAnalysis {
    
    // Método de interface, responsável por realizar uma analise em uma lista de usuarios
    // @param userInfoList Lista de usuarios
    // @return Resultado da analise
    analysis(userInfoList: Array<UserInfo>): number
}