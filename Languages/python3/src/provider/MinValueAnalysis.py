from src.model.SimpleTableAnalysis import SimpleTableAnalysis
from src.model.UserInfo import UserInfo

# Classe de analise que implementa a interface "SimpleTableAnalysis"
class MinValueAnalysis(SimpleTableAnalysis):

    # Método responsável por obter o menor valor de credit na lista de usuarios
    # @list Lista de usuarios
    # @return Valor minimo da lista
    def analysis(self, userInfoList):
        vmin = 1000000000
        
        for userInfo in userInfoList:
            if(userInfo.getCredit() < vmin): 
                vmin = userInfo.getCredit()

        return vmin
