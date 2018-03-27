using experimento.src.model;
using experimento.src.model.exception;
using System.Collections.Generic;

namespace experimento.src.provider {

    /// <summary>
    ///  Classe para analise de dados, obtem a media dos valores dos creditos dos usuarios
    /// </summary>
    public class SummaryAnalysis : TableAnalysis<double[]> {
        
        /// <summary>
        /// Realiza a analise de media dos dados
        /// </summary>
        /// <param name="list">Lista de dados a ser analisada</param>
        /// <returns>Media dos valores dos creditos</returns>
        public double[] analysis(List<UserInfo> list) {
            if(list == null || (list.Count == 0))
                throw new InvalidParameterException("'userInfoList' é null ou vazio");

            double sum = 0;
            double min = double.MaxValue;
            double max = double.MinValue;
            
            foreach(UserInfo userInfo in list) {
                sum += userInfo.credit;
                if(min > userInfo.credit) min = userInfo.credit;
                if(max > userInfo.credit) max = userInfo.credit;
            }

            double mean = sum/list.Count;
            double[] range = {min, max, mean};
            return range;
        }
    }
}