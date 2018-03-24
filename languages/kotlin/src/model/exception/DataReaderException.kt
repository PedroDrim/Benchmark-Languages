package model.exception

/**
 * Classe para o tratamento de erro durante a leitura dos dados
 * @param message Mensagem de erro
 */
class DataReaderException(override var message: String): Exception(message)