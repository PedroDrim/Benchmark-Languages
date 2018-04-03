import {TableAnalysis} from '../model/TableAnalysis'
import {UserInfo} from '../model/UserInfo'
import {InvalidParameterException} from '../model/exception/InvalidParameterException'

/**
 * Classe para ordenacao bubbleSort
 * @see model.TableAnalysis
 */
export class BubbleSortAnalysis implements TableAnalysis<Array<UserInfo>> {

    /**
     * Realiza uma ordenacao bubbleSort
     * @param userInfoList Lista de dados a ser analisada
     * @return Elemento aleatorio da lista
     * @see TableAnalysis
     */
    public analysis(userInfoList: Array<UserInfo>): Array<UserInfo> {
        if(userInfoList == null || userInfoList.length == 0)
            throw new InvalidParameterException("'userInfoList' é null ou vazio");

        var aux: UserInfo;
        let size: number = userInfoList.length;

        for(var index1: number = 0; index1 < size; index1++) {
            for(var index2: number = 1; index2 < (size - index1); index2++) {

                var user1: UserInfo = userInfoList[index2];
                var user2: UserInfo = userInfoList[index2 - 1];

                if(user1.getCredit() > user2.getCredit()) {
                    aux = user1;
                    user1 = user2;
                    user2 = aux;

                    userInfoList[index2] = user1;
                    userInfoList[index2 - 1] = user2;
                }
            }
        }

        return userInfoList;
    }
}
