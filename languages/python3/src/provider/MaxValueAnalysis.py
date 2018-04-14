# Importando bibliotecas
from src.model.SimpleTableAnalysis import SimpleTableAnalysis
from src.model.UserInfo import UserInfo

# Criando uma classe "MaxValueAnalysis" que implementa a interface "SimpleTableAnalysis"
class MaxValueAnalysis(SimpleTableAnalysis):
    # Método de interface, responsável por realizar a análise na lista de "UserInfo"
    # list -> Lista de "UserInfo"
    # RETURN -> Valor máximo da lista
    def analysis(self, userInfoList):
        vmax = -1000000000
        
        for userInfo in userInfoList:
            if(userInfo.getCredit() > vmax): 
                vmax = userInfo.getCredit()

        return vmax