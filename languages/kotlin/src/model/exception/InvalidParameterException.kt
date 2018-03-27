package model.exception

/**
 * Classe para o tratamento de erro durante a leitura dos dados
 * @param message Mensagem de erro
 */
class InvalidParameterException(override var message: String): Exception(message)