from src.model.SimpleTableAnalysis import SimpleTableAnalysis
from src.model.UserInfo import UserInfo

# Classe de analise que implementa a interface "SimpleTableAnalysis"
class MaxValueAnalysis(SimpleTableAnalysis):

    # Método responsável por obter o maior valor de credit na lista de usuarios
    # @list Lista de usuarios
    # @return Valor máximo da lista
    def analysis(self, userInfoList):
        vmax = -1000000000
        
        for userInfo in userInfoList:
            if(userInfo.getCredit() > vmax): 
                vmax = userInfo.getCredit()

        return vmax