using System;
using System.Collections.Generic;

namespace experimento.src.model {
 
    /// <summary>
    /// Interface para analise dos dados
    /// </summary>
    public interface TableAnalysis<T> {      
 
        /// <summary>
        /// Realiza a analise dos dados
        /// </summary>
        /// <param name="userInfoList">Lista de dados a ser analisada</param>
        /// <returns>Resultado da analise</returns>
        T analysis(List<UserInfo> userInfoList);
    }
}