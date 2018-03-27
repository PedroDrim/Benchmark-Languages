using System;

namespace experimento.src.model.exception {
    
    /// <summary>
    /// Classe para o tratamento de benchmark
    /// </summary>
    public class BenchmarkException: Exception {
    
        /// <summary>
        /// Construtor publico da classe
        /// </summary>
        /// <param name="message">Mensagem de erro</param>
        /// <returns></returns>
        public BenchmarkException(String message): base(message) {}
    }
}