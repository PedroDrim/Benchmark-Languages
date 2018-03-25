package provider;

import model.TableAnalysis;
import model.UserInfo;
import model.exception.InvalidParameterException;

import java.util.List;

/**
 * Classe para ordenacao quickSort
 * @see TableAnalysis
 */
public class QuickSortAnalysis implements TableAnalysis<List<UserInfo>> {

    private UserInfo[] arrayUserInfo;

    /**
     * Realiza uma analise ordenacao quickSort
     * @param userInfoList Lista de dados a ser analisada
     * @return Elemento aleatorio da lista
     * @see TableAnalysis
     */
    @Override
    public List<UserInfo> analysis(List<UserInfo> userInfoList) {
        if(userInfoList == null || userInfoList.isEmpty())
            throw new InvalidParameterException("'userInfoList' é null ou vazio");

        this.arrayUserInfo = new UserInfo[userInfoList.size()];
        this.arrayUserInfo = userInfoList.toArray(this.arrayUserInfo);

        this.quickSort(0, this.arrayUserInfo.length - 1);

        return List.of(arrayUserInfo);
    }

    /**
     * Iniciando quickSort
     * @param baixo index inicial
     * @param alto index final
     */
    private void quickSort(int baixo, int alto) {
        if(baixo > alto) throw new InvalidParameterException("'baixo' é maior que 'alto'");

        int indexInicio = baixo;
        int indexFim = alto;

        // Get the pivot element from the middle of the list
        UserInfo userInfoPivot = arrayUserInfo[baixo + (alto - baixo)/2];
        UserInfo aux;

        // Divide into two lists
        while (indexInicio <= indexFim) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list

            while (arrayUserInfo[indexInicio].getCredit() < userInfoPivot.getCredit()) {
                indexInicio++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (arrayUserInfo[indexFim].getCredit() > userInfoPivot.getCredit()) {
                indexFim--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (indexInicio <= indexFim) {
                aux = arrayUserInfo[indexInicio];
                arrayUserInfo[indexInicio] = arrayUserInfo[indexFim];
                arrayUserInfo[indexFim] = aux;

                indexInicio++;
                indexFim--;
            }
        }

        // Recursion
        if (baixo < indexFim) quickSort(baixo, indexFim);
        if (indexInicio < alto) quickSort(indexInicio, alto);
    }

}
