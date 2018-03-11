// Importando bibliotecas
import {SimpleTableAnalysis} from '../model/SimpleTableAnalysis'
import { UserInfo } from '../model/UserInfo';

// Criando uma classe "MinValueAnalysis" que implementa a interface "SimpleTableAnalysis"
export class MinValueAnalysis implements SimpleTableAnalysis {

    // Método de interface, responsável por realizar a análise na lista de "UserInfo"
    // list: List<UserInfo> -> Lista de "UserInfo"
    // RETURN: double -> valor minimo da lista
    public analysis(userInfoList: Array<UserInfo>): number{

        var min: number = Number.MAX_VALUE;

        userInfoList.forEach(userInfo => {
            if(min > userInfo.getCredit()) min = userInfo.getCredit()
        });

        return min;
    }
}