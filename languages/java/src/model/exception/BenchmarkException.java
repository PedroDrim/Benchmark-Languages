package model.exception;

/**
 * Classe para o tratamento de erros no benchmark
 */
public class BenchmarkException extends RuntimeException {

    /**
     * Construtor publico da classe
     * @param message Mensagem de erro
     */
    public BenchmarkException(String message) {
        super(message);
    }
}
