using System.Collections.Generic;

namespace inputclass.src.model {
    /// <summary>
    /// Interface "SimpleTableAnalysis"
    /// </summary>
    public interface SimpleTableAnalysis {      

        /// <summary>
        /// Método de interface, responsável por realizar a análise na lista de "UserInfo"
        /// </summary>
        /// <param name="list">Lista de "UserInfo"</param>
        /// <returns>valor da análise</returns>
        double analysis(List<UserInfo> list);
    }
}