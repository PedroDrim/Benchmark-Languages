using System;

namespace experimento.src.model.exception {
    
    /// <summary>
    /// Classe para o tratamento de erro durante a leitura dos dados
    /// </summary>
    public class DataReaderException: Exception {
    
        /// <summary>
        /// Construtor publico da classe
        /// </summary>
        /// <param name="message">Mensagem de erro</param>
        /// <returns></returns>
        public DataReaderException(String message): base(message) {}
    }
}