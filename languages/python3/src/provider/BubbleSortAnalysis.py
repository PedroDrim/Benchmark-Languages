from src.model.TableAnalysis import TableAnalysis
from src.model.UserInfo import UserInfo
from src.model.exception.InvalidParameterException import InvalidParameterException

# Classe para ordenacao bubbleSort
# @see model.TableAnalysis
class BubbleSortAnalysis(TableAnalysis):

    # Realiza uma ordenacao bubbleSort
    # @param userInfoList Lista de dados a ser analisada
    # @return Elemento aleatorio da lista
    # @see TableAnalysis
    def analysis(self, userInfoList):
        if(userInfoList == None or len(userInfoList) == 0):
            raise InvalidParameterException("'userInfoList' é None ou vazio")

        size = len(userInfoList)

        for index1 in range(0,size):
            for index2 in range(1, size - index1):

                user1 = userInfoList[index2]
                user2 = userInfoList[index2 - 1]

                if user1.getCredit() > user2.getCredit():
                    aux = user1
                    user1 = user2
                    user2 = aux

                    userInfoList[index2] = user1
                    userInfoList[index2 - 1] = user2

        return userInfoList