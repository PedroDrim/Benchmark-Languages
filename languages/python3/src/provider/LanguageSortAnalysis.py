from src.model.TableAnalysis import TableAnalysis
from src.model.UserInfo import UserInfo
from src.model.exception.InvalidParameterException import InvalidParameterException

# Classe para analise de dados, obtem um usuario aleatoriamente
# @see TableAnalysis
class LanguageSortAnalysis(TableAnalysis):

    # Realiza uma analise aleatoria dos dados
    # @param userInfoList Lista de dados a ser analisada
    # @return Elemento aleatorio da lista
    # @see TableAnalysis
    def analysis(self, userInfoList):
        if(userInfoList == None or len(userInfoList) == 0):
            raise InvalidParameterException("'userInfoList' é None ou vazio")

        sortedList = sorted(userInfoList, key = lambda userInfo : userInfo.getCredit())
        return sortedList