# Importando bibliotecas
from src.model.SimpleTableAnalysis import SimpleTableAnalysis
from src.model.UserInfo import UserInfo

# Criando uma classe "MinValueAnalysis" que implementa a interface "SimpleTableAnalysis"
class MinValueAnalysis(SimpleTableAnalysis):
    # Método de interface, responsável por realizar a análise na lista de "UserInfo"
    # list -> Lista de "UserInfo"
    # RETURN -> valor minimo da lista
    def analysis(self, userInfoList):
        vmin = 1000000000
        
        for userInfo in userInfoList:
            if(userInfo.getCredit() < vmin): 
                vmin = userInfo.getCredit()

        return vmin