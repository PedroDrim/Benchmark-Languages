using System;

namespace experimento.src.model.exception {
    
    /// <summary>
    /// Classe para o tratamento de erro para entradas invalidas
    /// </summary>
    public class InvalidParameterException: Exception {
    
        /// <summary>
        /// Construtor publico da classe
        /// </summary>
        /// <param name="message">Mensagem de erro</param>
        /// <returns></returns>
        public InvalidParameterException(String message): base(message) {}
    }
}