// Importando bibliotecas
import { SimpleTableAnalysis } from '../model/SimpleTableAnalysis'
import { UserInfo } from '../model/UserInfo';

// Criando uma classe "MeanAnalysis" que implementa a interface "SimpleTableAnalysis"
export class MeanAnalysis implements SimpleTableAnalysis {
    
    // Método de interface, responsável por realizar a análise na lista de "UserInfo"
    // list: List<UserInfo> -> Lista de "UserInfo"
    // RETURN: double -> média de valores da lista
    public analysis(userInfoList: Array<UserInfo>): number{

        var sum: number = 0.0;
        userInfoList.forEach(userInfo => sum += userInfo.getCredit() );

        return sum/(userInfoList.length);
    }
}