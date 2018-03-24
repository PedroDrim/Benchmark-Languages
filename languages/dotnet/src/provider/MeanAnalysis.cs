using experimento.src.model;
using System.Collections.Generic;

namespace experimento.src.provider {

    /// <summary>
    ///  Classe para analise de dados, obtem a media dos valores dos creditos dos usuarios
    /// </summary>
    public class MeanAnalysis : TableAnalysis<double> {
        
        /// <summary>
        /// Realiza a analise de media dos dados
        /// </summary>
        /// <param name="list">Lista de dados a ser analisada</param>
        /// <returns>Media dos valores dos creditos</returns>
        public double analysis(List<UserInfo> list) {

            double sum = 0;
            foreach(UserInfo userInfo in list) {
                sum += userInfo.credit;
            }

            return sum/list.Count;
        }
    }
}