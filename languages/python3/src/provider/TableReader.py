from src.model.UserInfo import UserInfo
from src.model.exception.InvalidParameterException import InvalidParameterException
from src.model.exception.DataReaderException import DataReaderException
from src.model.DataReader import DataReader

# Classe responsavel por ler e disponibilizar os dados em um formato desejado
# @see model.DataReader
class TableReader(DataReader):

    # Construtor publico da classe
    # @param fileName Nome do arquivo de dados a ser lido
    # @throws DataReaderException Lancada caso nao seja possivel ler os dados corretamente
    def __init__(self, fileName):
        if(fileName == None):
            raise InvalidParameterException("'fileName' é None")

        self.__fileName = fileName
        self.__userInfoList = self.__deserializeFile(fileName)

    # Obtem o nome do arquivo de dados a ser lido
    # @return Nome do arquivo de dados a ser lido
    def getFileName(self):
        return self.__fileName

    # Obtem todos os dados disponiveis
    # @return Lista contendo todos os dados disponiveis
    def readAll(self):
        return self.__userInfoList
    
    # Obtem os dados disponiveis dentro de um intervalo
    # @param startIndex Inicio do intervalo
    # @param endIndex Fim do intervalo
    # @return Lista contendo todos os dados disponiveis dentro do intervalo especificado
    def read(self, startIndex, endIndex):
        if(startIndex < 0):
            raise InvalidParameterException("'startIndex' é menor que 0")
        
        if(endIndex < 0):
            raise InvalidParameterException("'endIndex' é menor que 0")
    
        if(startIndex >= endIndex):
            raise InvalidParameterException("'startIndex' é maior ou igual á 'endIndex'")

        return self.__userInfoList[startIndex:endIndex]

    # Desserializa o arquivo de dados, convertendo-o em uma lista de 'UserInfo'
    # @param fileName Nome do arquivo de dados
    # @return Lista contendo os dados desserilizados
    # @throws DataReaderException Lancada caso nao seja possivel ler os dados corretamente
    def __deserializeFile(self, fileName):
        if(fileName == None):
            raise InvalidParameterException("'fileName' é None")

        userInfoList = []

        f = open(fileName, "r")
        f.readline()

        while(True):
            line = f.readline().replace("\n","")

            if(line == "" or line == None):
                break

            values = line.split(",")

            user = values[0].strip()
            password = values[1].strip()
            credit = values[2].strip()

            userInfo = UserInfo(user, password, credit)
            userInfoList.append(userInfo)

        return userInfoList
        

            
        