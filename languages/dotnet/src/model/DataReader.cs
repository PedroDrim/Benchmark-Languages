using System;
using System.Collections.Generic;

namespace experimento.src.model {
 
    /// <summary>
    /// Interface para leitura de dados
    /// </summary>
    public interface DataReader {      
 
        /// <summary>
        /// Obtem todos os dados disponiveis
        /// </summary>
        /// <returns>Lista contendo todos os dados disponiveis</returns>
        List<UserInfo> read();

        /// <summary>
        /// Obtem os dados disponiveis dentro de um intervalo
        /// </summary>
        /// <param name="startIndex">Inicio do intervalo</param>
        /// <param name="endIndex">Fim do intervalo</param>
        /// <returns>Lista contendo todos os dados disponiveis dentro do intervalo especificado</returns>
        List<UserInfo> read(int startIndex, int endIndex);

    }
}