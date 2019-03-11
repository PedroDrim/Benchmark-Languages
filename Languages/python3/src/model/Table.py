import pandas
from src.model.UserInfo import UserInfo

# Classe para gerenciar uma tabela de usuarios
class Table:

    # Construtor publico da classe
    # @param fileName Nome do arquivo .csv
    def __init__(self, fileName):
        self.__fileName = fileName
        self.__userInfoList = self.__deserializeFile(self.__fileName)

    # metodo publico para obter o nome do arquivo
    # @return Nome do arquivo
    def getFileName(self):
        return self.__fileName

    # metodo publico para obter a lista de usuarios
    # @return Lista de usuarios
    def getUserInfoList(self):
        return self.__userInfoList

    # Método privado para conversão do arquivo .csv em uma lista de usuarios
    # @param fileName Nome do arquivo
    # @return Lista convertida de usuarios    
    def __deserializeFile(self, fileName):
        table = pandas.read_csv(fileName)
        
        array = []

        for index, row in table.iterrows():

            user = row["user"].strip()
            password = row["password"].strip()
            credit = row["credit"]

            userInfo = UserInfo(user, password, credit)
            array.append(userInfo)

        return array
