using experimento.src.model;
using System.Collections.Generic;

namespace experimento.src.provider {

    /// <summary>
    ///  Classe para analise de dados, obtem a media dos valores dos creditos dos usuarios
    /// </summary>
    public class RangeValueAnalysis : TableAnalysis<double[]> {
        
        /// <summary>
        /// Realiza a analise de media dos dados
        /// </summary>
        /// <param name="list">Lista de dados a ser analisada</param>
        /// <returns>Media dos valores dos creditos</returns>
        public double[] analysis(List<UserInfo> list) {

            double min = double.MaxValue;
            double max = double.MinValue;
            foreach(UserInfo userInfo in list) {
                if(min > userInfo.credit) min = userInfo.credit;
                if(max > userInfo.credit) max = userInfo.credit;
            }

            double[] range = {min, max};
            return range;
        }
    }
}