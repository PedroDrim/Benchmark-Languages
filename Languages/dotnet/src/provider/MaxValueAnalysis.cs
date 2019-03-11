using System;
using inputclass.src.model;
using System.Collections.Generic;

namespace inputclass.src.provider {
    
    /// <summary>
    /// Classe que implementa a interface "SimpleTableAnalysis",
    /// responsável por obter o maior valor de "credit" em uma lista de usuarios
    /// </summary>
    public class MaxValueAnalysis : SimpleTableAnalysis {
    
        /// <summary>
        /// Método de interface, responsável por obter o maior valor de credit na lista de "UserInfo"
        /// </summary>
        /// <param name="list">Lista de "UserInfo"</param>
        /// <returns>Maio valor de credit</returns>
        public double analysis(List<UserInfo> list) {

            double max = double.MinValue;
            foreach(UserInfo userInfo in list) {
                if(max < userInfo.credit) max = userInfo.credit;
            }

            return max;
        }
    }
}