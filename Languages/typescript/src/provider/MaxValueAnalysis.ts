import { SimpleTableAnalysis } from '../model/SimpleTableAnalysis'
import { UserInfo } from '../model/UserInfo';

// Classe de analise que implementa a interface "SimpleTableAnalysis"
export class MaxValueAnalysis implements SimpleTableAnalysis {
   
    // Método de interface, responsável por realizar obter o valor maximo de credit em uma lista de usuarios
    // @param userInfoList Lista de usuarios
    // @return Valor maximo de credit
    public analysis(userInfoList: Array<UserInfo>): number{

        var max: number = Number.MIN_VALUE;

        userInfoList.forEach(userInfo => {
            if(max < userInfo.getCredit()) max = userInfo.getCredit()
        });

        return max;
    }
}