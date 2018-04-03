import {TableAnalysis} from '../model/TableAnalysis'
import {UserInfo} from '../model/UserInfo'
import {InvalidParameterException} from '../model/exception/InvalidParameterException'

/**
 * Classe para analise de dados, obtem um usuario aleatoriamente
 * @see TableAnalysis
 */
export class LanguageSortAnalysis implements TableAnalysis<Array<UserInfo>> {

    /**
     * Realiza uma analise aleatoria dos dados
     * @param userInfoList Lista de dados a ser analisada
     * @return Elemento aleatorio da lista
     * @see TableAnalysis
     */
    public analysis(userInfoList: Array<UserInfo>): Array<UserInfo> {
        if(userInfoList == null || userInfoList.length == 0)
            throw new InvalidParameterException("'userInfoList' é null ou vazio");

        return userInfoList.sort( (u1, u2) => u1.getCredit() > u2.getCredit()? 1 : -1 );
    }
}
