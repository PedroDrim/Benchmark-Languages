# Importando bibliotecas
require './src/model/SimpleTableAnalysis.rb'

# Criando uma classe "MinValueAnalysis" que implementa a interface "SimpleTableAnalysis"
class MinValueAnalysis
    include SimpleTableAnalysis

    # Método de interface, responsável por realizar a análise na lista de "UserInfo"
    # list -> Lista de "UserInfo"
    # RETURN -> valor minimo da lista
    def analysis(userInfoList)

        min = 1_000_000_000

        userInfoList.each do |userInfo|
            if(userInfo.credit < min) 
                min = userInfo.credit
            end
        end

        return min
    end
end