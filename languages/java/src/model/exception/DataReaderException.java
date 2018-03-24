package model.exception;

/**
 * Classe para o tratamento de erro durante a leitura dos dados
 */
public class DataReaderException extends RuntimeException {

    /**
     * Construtor publico da classe
     * @param message Mensagem de erro
     */
    public DataReaderException(String message) {
        super(message);
    }
}
