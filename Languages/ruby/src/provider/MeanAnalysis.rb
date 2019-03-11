require './src/model/SimpleTableAnalysis.rb'

# Classe de analise que implementa a interface "SimpleTableAnalysis"
class MeanAnalysis
    include SimpleTableAnalysis

    # Método responsável por obter a media de valores de credit na lista de usuarios
    # @param userInfoList Lista de usuarios
    # @return Valor máximo da lista
    def analysis(userInfoList)
        mean = 0

        userInfoList.each do |userInfo|
            mean += userInfo.credit
        end

        return mean/userInfoList.size
    end
end