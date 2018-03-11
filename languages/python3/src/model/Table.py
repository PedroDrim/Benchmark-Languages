# Importando bibliotecas
import pandas
from src.model.UserInfo import UserInfo

# Criando uma classe "Table"
class Table:

    # Construtor publico da classe
    # fileName -> Nome do arquivo .csv
    def __init__(self, fileName):
        self.__fileName = fileName
        self.__userInfoList = self.__deserializeFile(self.__fileName)

    # método getter de "fileName"
    def getFileName(self):
        return self.__fileName

    # método getter de "UserInfoList"
    def getUserInfoList(self):
        return self.__userInfoList

    # Método privado para conversão do arquivo .csv em uma lista de "UserInfo"
    # fileName -> Nome do arquivo
    # RETURN -> Lista convertida de "UserInfo"
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
