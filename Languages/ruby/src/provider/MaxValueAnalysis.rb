require './src/model/SimpleTableAnalysis.rb'

# Classe de analise que implementa a interface "SimpleTableAnalysis"
class MaxValueAnalysis
    include SimpleTableAnalysis

    # Método responsável por obter o maior valor de credit na lista de usuarios
    # @param userInfoList Lista de usuarios
    # @return Valor máximo da lista
    def analysis(userInfoList)

        max = -1000_000_000

        userInfoList.each do |userInfo|
            if(userInfo.credit > max) 
                max = userInfo.credit
            end
        end

        return max
    end
end