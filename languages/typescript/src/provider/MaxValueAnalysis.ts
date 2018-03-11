// Importando bibliotecas
import { SimpleTableAnalysis } from '../model/SimpleTableAnalysis'
import { UserInfo } from '../model/UserInfo';

// Criando uma classe "MaxValueAnalysis" que implementa a interface "SimpleTableAnalysis"
export class MaxValueAnalysis implements SimpleTableAnalysis {
    // Método de interface, responsável por realizar a análise na lista de "UserInfo"
    // list: List<UserInfo> -> Lista de "UserInfo"
    // RETURN: double -> valor máximo da lista
    public analysis(userInfoList: Array<UserInfo>): number{

        var max: number = Number.MIN_VALUE;

        userInfoList.forEach(userInfo => {
            if(max < userInfo.getCredit()) max = userInfo.getCredit()
        });

        return max;
    }
}