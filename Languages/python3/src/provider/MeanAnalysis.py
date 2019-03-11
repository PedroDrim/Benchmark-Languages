from src.model.SimpleTableAnalysis import SimpleTableAnalysis
from src.model.UserInfo import UserInfo

# Classe de analise que implementa a interface "SimpleTableAnalysis"
class MeanAnalysis(SimpleTableAnalysis):

    # Método responsável por obter a media de valores de credit na lista de usuarios
    # @list Lista de usuarios
    # @return Média de valores da lista
    def analysis(self, userInfoList):
        vsum = 0

        for userInfo in userInfoList:
            vsum += userInfo.getCredit()

        return vsum/len(userInfoList)
