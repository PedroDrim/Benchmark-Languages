# Importando bibliotecas
from src.model.SimpleTableAnalysis import SimpleTableAnalysis
from src.model.UserInfo import UserInfo

# Criando uma classe "MeanAnalysis" que implementa a interface "SimpleTableAnalysis"
class MeanAnalysis(SimpleTableAnalysis):
    # Método de interface, responsável por realizar a análise na lista de "UserInfo"
    # list -> Lista de "UserInfo"
    # RETURN -> média de valores da lista
    def analysis(self, userInfoList):
        vsum = 0

        for userInfo in userInfoList:
            vsum += userInfo.getCredit()

        return vsum/len(userInfoList)
