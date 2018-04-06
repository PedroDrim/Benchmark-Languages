from src.model.TableAnalysis import TableAnalysis
from src.model.UserInfo import UserInfo
from src.model.exception.InvalidParameterException import InvalidParameterException

# Classe para ordenacao quickSort
# @see TableAnalysis
class QuickSortAnalysis(TableAnalysis):

    # Realiza uma analise ordenacao quickSort
    # @param userInfoList Lista de dados a ser analisada
    # @return Elemento aleatorio da lista
    # @see TableAnalysis
    def analysis(self, userInfoList):
        validation = (userInfoList == None or len(userInfoList) == 0 )
        if(validation):
            raise InvalidParameterException("'userInfoList' é None ou vazio")

        self.__arrayUserInfo = userInfoList

        self.__quickSort(0, len(self.__arrayUserInfo) - 1)

        return self.__arrayUserInfo

    # Iniciando quickSort
    # @param baixo index inicial
    # @param alto index final
    def __quickSort(self, baixo, alto):
        if (baixo > alto):
            raise InvalidParameterException("'baixo' é maior que 'alto'")
        
        indexInicio = baixo
        indexFim = alto

        # Get the pivot element from the middle of the list
        index = baixo + (alto - baixo)/2 
        indexPivot = int(index)

        # Divide into two lists
        while (indexInicio <= indexFim):

            pivotCredit = self.__arrayUserInfo[indexPivot].getCredit()
        
            # If the current value from the left list is smaller than the pivot
            # element then get the next element from the left list
            while (self.__arrayUserInfo[indexInicio].getCredit() < pivotCredit):
                indexInicio = indexInicio + 1
        
            # If the current value from the right list is larger than the pivot
            # element then get the next element from the right list
            while (self.__arrayUserInfo[indexFim].getCredit() > pivotCredit):
                indexFim = indexFim - 1

            # If we have found a value in the left list which is larger than
            # the pivot element and If we have found a value in the right list
            # which is smaller than the pivot element then we exchange the
            # values.
            # As we are done we can increase i and j
            if (indexInicio <= indexFim):
                aux = self.__arrayUserInfo[indexInicio]
                self.__arrayUserInfo[indexFim] = self.__arrayUserInfo[indexFim]
                self.__arrayUserInfo[indexInicio] = aux
                
                indexInicio = indexInicio + 1
                indexFim = indexFim - 1

        # Recursion
        if (baixo < indexFim):
            self.__quickSort(baixo, indexFim)
        
        if (indexInicio < alto): 
            self.__quickSort(indexInicio, alto) 
