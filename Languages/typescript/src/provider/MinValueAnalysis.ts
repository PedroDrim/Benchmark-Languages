import {SimpleTableAnalysis} from '../model/SimpleTableAnalysis'
import { UserInfo } from '../model/UserInfo';

// Classe de analise que implementa a interface "SimpleTableAnalysis"
export class MinValueAnalysis implements SimpleTableAnalysis {

    // Método de interface, responsável por realizar obter o valor minimo de credit em uma lista de usuarios
    // @param userInfoList Lista de usuarios
    // @return Valor minimo de credit
    public analysis(userInfoList: Array<UserInfo>): number{

        var min: number = Number.MAX_VALUE;

        userInfoList.forEach(userInfo => {
            if(min > userInfo.getCredit()) min = userInfo.getCredit()
        });

        return min;
    }
}