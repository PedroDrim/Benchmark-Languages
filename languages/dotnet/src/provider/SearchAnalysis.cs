using experimento.src.model;
using System;
using System.Collections.Generic;

namespace experimento.src.provider {

    /// <summary>
    ///  Classe para analise de dados, obtem a media dos valores dos creditos dos usuarios
    /// </summary>
    public class SearchAnalysis : TableAnalysis<UserInfo> {
        
        /// <summary>
        /// Realiza a analise de media dos dados
        /// </summary>
        /// <param name="list">Lista de dados a ser analisada</param>
        /// <returns>Media dos valores dos creditos</returns>
        public UserInfo analysis(List<UserInfo> list) {
            Random random = new Random();
            int randomIndex = random.Next(list.Count);
            
            UserInfo userInfo = list[randomIndex];
            return userInfo;
        }
    }
}