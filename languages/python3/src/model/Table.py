import pandas
from src.model.UserInfo import UserInfo

class Table:

    def __init__(self, fileName):
        self.__fileName = fileName
        self.__userInfoList = self.__deserializeFile(self.__fileName)

    def getFileName(self):
        return self.__fileName

    def getUserInfoList(self):
        return self.__userInfoList

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
