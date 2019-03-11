using inputclass.src.model;
using System.Collections.Generic;

namespace inputclass.src.provider {

    /// <summary>
    /// Classe que implementa a interface "SimpleTableAnalysis",
    /// responsável por obter a media de valores de "credit" em uma lista de usuarios
    /// </summary>
    public class MeanAnalysis : SimpleTableAnalysis {

        /// <summary>
        /// Método de interface, responsável por obter a media de valores de credit na lista de "UserInfo"
        /// </summary>
        /// <param name="list">Lista de "UserInfo"</param>
        /// <returns>Média de valor de credit</returns>
        public double analysis(List<UserInfo> list) {

            double sum = 0;
            foreach(UserInfo userInfo in list) {
                sum += userInfo.credit;
            }

            return sum/list.Count;
        }
    }
}