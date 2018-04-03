import {TableAnalysis} from '../model/TableAnalysis'
import {InvalidParameterException} from '../model/exception/InvalidParameterException'
import { UserInfo } from '../model/UserInfo';

/**
 * Classe para analise de dados, obtem os valores maximo e minimo dos creditos dos usuarios
 * @see model.TableAnalysis
 */
export class SummaryAnalysis implements TableAnalysis<number[]> {

    /**
     * Realiza a analise maxima e minima dos dados
     * @param userInfoList Lista de dados a ser analisada
     * @return Valores maximo e minimo dos creditos
     * @see TableAnalysis
     */
    public analysis(userInfoList: Array<UserInfo>): number[] {
        if(userInfoList == null || userInfoList.length == 0)
            throw new InvalidParameterException("'userInfoList' é null ou vazio");

        let max: number = Number.MIN_VALUE;
        let min: number = Number.MAX_VALUE;
        let sum: number = 0;

        for(let userInfo of userInfoList){
            var credit: number = userInfo.getCredit();
            sum += credit;
            if(max < credit) max = credit;
            if(min > credit) min = credit;
        }

        let mean: number = sum/userInfoList.length;
        return [min, max, mean];
    }
}

