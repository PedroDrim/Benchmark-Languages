require './src/model/TableAnalysis.rb'
require './src/model/UserInfo.rb'
require './src/model/exception/InvalidParameterException.rb'

# Classe para ordenacao quickSort
# @see TableAnalysis
class QuickSortAnalysis 
    include TableAnalysis

    # Realiza uma analise ordenacao quickSort
    # @param userInfoList Lista de dados a ser analisada
    # @return Elemento aleatorio da lista
    # @see TableAnalysis
    def analysis(userInfoList)
        validation = (userInfoList.nil? || userInfoList.size == 0)
        raise InvalidParameterException.new("'userInfoList' é nil ou vazio") if(validation)

        @arrayUserInfo = userInfoList

        quickSort(0, @arrayUserInfo.length - 1)

        return @arrayUserInfo
    end

    private
    # Iniciando quickSort
    # @param baixo index inicial
    # @param alto index final
    def quickSort(baixo, alto)
        raise InvalidParameterException.new("'baixo' é maior que 'alto'") if (baixo > alto)
        
        indexInicio, indexFim = baixo, alto

        # Get the pivot element from the middle of the list
        index = baixo + (alto - baixo)/2 
        indexPivot = index.round

        # Divide into two lists
        while indexInicio <= indexFim

            indexInicio, indexFim = findIndex(indexPivot, indexInicio, indexFim)    
        
            # If we have found a value in the left list which is larger than
            # the pivot element and If we have found a value in the right list
            # which is smaller than the pivot element then we exchange the
            # values.
            # As we are done we can increase i and j
            if indexInicio <= indexFim
                @arrayUserInfo[indexInicio], @arrayUserInfo[indexFim] = @arrayUserInfo[indexFim], @arrayUserInfo[indexInicio]
                
                indexInicio = indexInicio + 1
                indexFim = indexFim - 1
            end

        end

        # Recursion
        quickSort(baixo, indexFim) if (baixo < indexFim)
        quickSort(indexInicio, alto) if (indexInicio < alto)
    end

    def findIndex(indexPivot, indexStart, indexEnd)
        
        pivotCredit = @arrayUserInfo[indexPivot].getCredit
    
        # If the current value from the left list is smaller than the pivot
        # element then get the next element from the left list
        while @arrayUserInfo[indexStart].getCredit < pivotCredit
            indexStart = indexStart + 1
        end
    
        # If the current value from the right list is larger than the pivot
        # element then get the next element from the right list
        while @arrayUserInfo[indexEnd].getCredit > pivotCredit
            indexEnd = indexEnd - 1
        end       
        
        return indexStart, indexEnd
    end
end
