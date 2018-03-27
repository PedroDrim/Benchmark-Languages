using experimento.src.model;
using experimento.src.model.exception;
using System.Collections.Generic;
using System.Linq;

namespace experimento.src.provider {

    /// <summary>
    ///  Classe para ordenacao quickSort
    /// </summary>
    public class QuickSortAnalysis : TableAnalysis<List<UserInfo>> {
        
        private UserInfo[] arrayUserInfo;

        /// <summary>
        /// Realiza uma ordenacao quickSort
        /// </summary>
        /// <param name="list">Lista de dados a ser ordenada</param>
        /// <returns>Lista ordenada</returns>
        public List<UserInfo> analysis(List<UserInfo> list) {
            if(list == null || (list.Count == 0))
                throw new InvalidParameterException("'userInfoList' é null ou vazio");

            this.arrayUserInfo = list.ToArray();

            this.quickSort(0, this.arrayUserInfo.Length - 1);

            return this.arrayUserInfo.ToList();
        }

        /// <summary>
        /// Iniciando quickSort
        /// </summary>
        /// <param name="baixo">index inicial</param>
        /// <param name="alto">index final</param>
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

                while (arrayUserInfo[indexInicio].credit < userInfoPivot.credit) {
                    indexInicio++;
                }
                // If the current value from the right list is larger than the pivot
                // element then get the next element from the right list
                while (arrayUserInfo[indexFim].credit > userInfoPivot.credit) {
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
}