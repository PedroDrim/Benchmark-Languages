import { SimpleTableAnalysis } from '../model/SimpleTableAnalysis'
import { UserInfo } from '../model/UserInfo';

// Classe de analise que implementa a interface "SimpleTableAnalysis"
export class MeanAnalysis implements SimpleTableAnalysis {
    
    // Método de interface, responsável por realizar obter a media dos valores de credit em uma lista de usuarios
    // @param userInfoList Lista de usuarios
    // @return Media dos valores de credit
    public analysis(userInfoList: Array<UserInfo>): number{

        var sum: number = 0.0;
        userInfoList.forEach(userInfo => sum += userInfo.getCredit() );

        return sum/(userInfoList.length);
    }
}