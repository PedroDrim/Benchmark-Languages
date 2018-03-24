package model.exception;

/**
 * Classe para o tratamento de erro durante a passagem de parametros
 */
public class InvalidParameterException extends RuntimeException{

    /**
     * Construtor publico da classe
     * @param message Mensagem de erro
     */
    public InvalidParameterException(String message) {
        super(message);
    }
}
