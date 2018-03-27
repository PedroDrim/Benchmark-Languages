using experimento.src.model;
using experimento.src.model.exception;
using System.Collections.Generic;
using System.Linq;

namespace experimento.src.provider {

    /// <summary>
    ///  Classe para ordenacao pela propria linguagem
    /// </summary>
    public class LanguageSortAnalysis : TableAnalysis<List<UserInfo>> {
        
        /// <summary>
        /// Realiza uma ordenacao pela propria linguagem
        /// </summary>
        /// <param name="list">Lista de dados a ser ordenada</param>
        /// <returns>Lista ordenada</returns>
        public List<UserInfo> analysis(List<UserInfo> list) {
            if(list == null || (list.Count == 0))
                throw new InvalidParameterException("'userInfoList' é null ou vazio");

            List<UserInfo> sortedList = list.OrderBy(it => it.credit).ToList();

            return sortedList;
        }
    }
}