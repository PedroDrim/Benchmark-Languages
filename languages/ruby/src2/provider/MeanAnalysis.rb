# Importando bibliotecas
require './src/model/SimpleTableAnalysis.rb'

# Criando uma classe "MeanAnalysis" que implementa a interface "SimpleTableAnalysis"
class MeanAnalysis
    include SimpleTableAnalysis

    # Método de interface, responsável por realizar a análise na lista de "UserInfo"
    # list -> Lista de "UserInfo"
    # RETURN -> média de valores da lista
    def analysis(userInfoList)
        mean = 0

        userInfoList.each do |userInfo|
            mean += userInfo.credit
        end

        return mean/userInfoList.size
    end
end