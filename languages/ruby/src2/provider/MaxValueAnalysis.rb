# Importando bibliotecas
require './src/model/SimpleTableAnalysis.rb'

# Criando uma classe "MaxValueAnalysis" que implementa a interface "SimpleTableAnalysis"
class MaxValueAnalysis
    include SimpleTableAnalysis

    # Método de interface, responsável por realizar a análise na lista de "UserInfo"
    # list -> Lista de "UserInfo"
    # RETURN -> Valor máximo da lista
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