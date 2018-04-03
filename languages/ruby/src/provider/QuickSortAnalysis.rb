import {TableAnalysis} from '../model/TableAnalysis'
import {UserInfo} from '../model/UserInfo'
import {InvalidParameterException} from '../model/exception/InvalidParameterException'

/**
 * Classe para ordenacao quickSort
 * @see TableAnalysis
 */
export class QuickSortAnalysis implements TableAnalysis<Array<UserInfo>> {

    private arrayUserInfo: UserInfo[];

    /**
     * Realiza uma analise ordenacao quickSort
     * @param userInfoList Lista de dados a ser analisada
     * @return Elemento aleatorio da lista
     * @see TableAnalysis
     */
    public analysis(userInfoList: Array<UserInfo>): Array<UserInfo> {
        if(userInfoList == null || userInfoList.length == 0)
            throw new InvalidParameterException("'userInfoList' é null ou vazio");

        this.arrayUserInfo = userInfoList;

        this.quickSort(0, this.arrayUserInfo.length - 1);

        return this.arrayUserInfo;
    }

    /**
     * Iniciando quickSort
     * @param baixo index inicial
     * @param alto index final
     */
    private quickSort(baixo: number, alto: number): void {
        if(baixo > alto) throw new InvalidParameterException("'baixo' é maior que 'alto'");

        var indexInicio: number = baixo;
        var indexFim: number = alto;

        // Get the pivot element from the middle of the list
        let index: number = Math.round( baixo + (alto - baixo)/2 );
        var userInfoPivot: UserInfo = this.arrayUserInfo[index];
        var aux: UserInfo;

        // Divide into two lists
        while (indexInicio <= indexFim) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list

            while (this.arrayUserInfo[indexInicio].getCredit() < userInfoPivot.getCredit()) {
                indexInicio++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (this.arrayUserInfo[indexFim].getCredit() > userInfoPivot.getCredit()) {
                indexFim--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (indexInicio <= indexFim) {
                aux = this.arrayUserInfo[indexInicio];
                this.arrayUserInfo[indexInicio] = this.arrayUserInfo[indexFim];
                this.arrayUserInfo[indexFim] = aux;

                indexInicio++;
                indexFim--;
            }
        }

        // Recursion
        if (baixo < indexFim) this.quickSort(baixo, indexFim);
        if (indexInicio < alto) this.quickSort(indexInicio, alto);
    }

}
