from src.model.TableAnalysis import TableAnalysis
from src.model.exception.InvalidParameterException import InvalidParameterException
from src.model.UserInfo import UserInfo

# Classe para analise de dados, obtem os valores maximo e minimo dos creditos dos usuarios
# @see model.TableAnalysis
class SummaryAnalysis(TableAnalysis): 
    
    # Realiza a analise maxima e minima dos dados
    # @param userInfoList Lista de dados a ser analisada
    # @return Valores maximo e minimo dos creditos
    # @see TableAnalysis
    def analysis(self, userInfoList):
        if(userInfoList == None or len(userInfoList) == 0):
            raise InvalidParameterException("'userInfoList' é None ou vazio")

        max = -1000000000.0
        min = -1000000000.0
        sum = 0.0

        for userInfo in userInfoList:
            sum += userInfo.getCredit()
            if(userInfo.getCredit() > max):
                max = userInfo.getCredit()  

            if(userInfo.getCredit() > min):
                min = userInfo.getCredit()             
    
        mean = sum/len(userInfoList)

        return [min, max, mean]

