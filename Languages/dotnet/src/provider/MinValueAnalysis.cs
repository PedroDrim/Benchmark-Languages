using inputclass.src.model;
using System.Collections.Generic;

namespace inputclass.src.provider {

    /// <summary>
    /// Classe que implementa a interface "SimpleTableAnalysis",
    /// responsável por obter o menor valor de "credit" em uma lista de usuarios
    /// </summary>
    public class MinValueAnalysis : SimpleTableAnalysis {
        
        /// <summary>
        /// Método de interface, responsável por obter o menor valor de credit na lista de "UserInfo"
        /// </summary>
        /// <param name="list">Lista de "UserInfo"</param>
        /// <returns>Menor valor de credit</returns>
        public double analysis(List<UserInfo> list) {

            double min = double.MaxValue;
            foreach(UserInfo userInfo in list) {
                if(min > userInfo.credit) min = userInfo.credit;
            }

            return min;
        }
    }
}