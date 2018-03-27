using experimento.src.model;
using experimento.src.model.exception;
using System;
using System.Linq;
using System.Collections.Generic;

namespace experimento.src.provider {

    /// <summary>
    ///  Classe para ordenacao bubbleSort
    /// </summary>
    public class BubbleSortAnalysis : TableAnalysis<List<UserInfo>> {
        
        /// <summary>
        /// Realiza uma ordenacao bubbleSort
        /// </summary>
        /// <param name="list">Lista de dados a ser ordenada</param>
        /// <returns>Lista ordenada</returns>
        public List<UserInfo> analysis(List<UserInfo> list) {
            if(list == null || (list.Count == 0))
                throw new InvalidParameterException("'userInfoList' é null ou vazio");

            UserInfo[] arrayUserInfo = list.ToArray();

            UserInfo aux;
            int size = arrayUserInfo.Length;

            for(int index1 = 0; index1 < size; index1++) {
                for(int index2 = 1; index2 < (size - index1); index2++) {

                    UserInfo user1 = arrayUserInfo[index2];
                    UserInfo user2 = arrayUserInfo[index2 - 1];

                    if(user1.credit > user2.credit) {
                        aux = user1;
                        user1 = user2;
                        user2 = aux;

                        arrayUserInfo[index2] = user1;
                        arrayUserInfo[index2 - 1] = user2;
                    }
                }
            }

            return arrayUserInfo.ToList();
        }
    }
}