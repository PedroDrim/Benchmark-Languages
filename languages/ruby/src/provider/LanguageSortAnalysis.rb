require './src/model/TableAnalysis.rb'
require './src/model/UserInfo.rb'
require './src/model/exception/InvalidParameterException.rb'

# Classe para analise de dados, obtem um usuario aleatoriamente
# @see TableAnalysis
class LanguageSortAnalysis
    include TableAnalysis

    # Realiza uma analise aleatoria dos dados
    # @param userInfoList Lista de dados a ser analisada
    # @return Elemento aleatorio da lista
    # @see TableAnalysis
    def analysis(userInfoList)
        if(userInfoList.nil? || userInfoList.size == 0)
            raise InvalidParameterException.new("'userInfoList' é nil ou vazio")
        end

        sortedList = userInfoList.sort_by do |u1| 
            u1.getCredit
        end

        return sortedList
    end
end
