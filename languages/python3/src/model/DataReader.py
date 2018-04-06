from src.model.UserInfo import UserInfo

# Interface para leitura de dados
class DataReader:

    # Obtem todos os dados disponiveis
    # @return Lista contendo todos os dados disponiveis
    def readAll(self):
        raise NotImplementedError()

    # Obtem os dados disponiveis dentro de um intervalo
    # @param startIndex Inicio do intervalo
    # @param endIndex Fim do intervalo
    # @return Lista contendo todos os dados disponiveis dentro do intervalo especificado
    def read(self, startIndex, endIndex):
        raise NotImplementedError()
